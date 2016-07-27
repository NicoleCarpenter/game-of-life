(ns game-of-life.core
  (:require [game-of-life.patterns :as patterns]
            [game-of-life.io :as io]))

(def countif (comp count filter))

(defn- find-square-plot [cell-location]
  (for [x [-1 0 1]
        y [-1 0 1]]
    [(+ (first cell-location) x) (+ (last cell-location) y)]))

(defn- find-neighbor-indices [cell-location]
  (let [self-and-neighbors (find-square-plot cell-location)]
    (filter #(not= cell-location %) self-and-neighbors)))

(defn- find-world-upper-boundary [world]
  [(dec (count world)) (dec (count (last world)))])

(defn- within-lower-bounds? [neighbor-cell-location]
  (every? #(>= % 0) neighbor-cell-location))

(defn- within-upper-bounds? [boundary neighbor-cell-location]
  (every? #(>= % 0) [(- (first boundary) (first neighbor-cell-location)) (- (last boundary) (last neighbor-cell-location))]))

(defn- remove-out-of-bounds [world cell-location]
  (let [neighbors (find-neighbor-indices cell-location)
        upper-boundary (find-world-upper-boundary world)]
    (filter #(and (within-lower-bounds? %) (within-upper-bounds? upper-boundary %)) neighbors)))

(defn- count-number-of-living-neighbors [world cell-location]
  (let [neighbor-locations (remove-out-of-bounds world cell-location)]
  (countif #(= 1 (get-in world %)) neighbor-locations)))

(defn- evaluate-life [world cell-location]
  (let [living-neighbors (count-number-of-living-neighbors world cell-location)
        cell-value (get-in world cell-location)]
    (cond
      (< living-neighbors 2)
        0
      (> living-neighbors 3)
        0
      (= living-neighbors 3)
        1
      :else
        cell-value)))

(defn- find-world-locations [world]
  (for [[x row] (map-indexed vector world) 
        [y val] (map-indexed vector row)]
    [x y]))

(defn- find-world-rows [world]
  (count (first world)))

(defn- flatten-rows [world]
  (for [row world]
    (clojure.string/join " " row)))

(defn- add-newline-to-rows [world]
  (let [flattened-rows (flatten-rows world)]
    (for [row flattened-rows]
      (str row "\n"))))

(defn- format-world [world]
  (let [formatted-rows (add-newline-to-rows world)]
    (clojure.string/join formatted-rows)))

(defn- replace-with-printable-chars [world]
  (let [formatted-world (format-world world)]
    (clojure.string/replace formatted-world #"0|1" {"0" " " "1" "▇"})))

(defn evolve [world]
  (let [world-locations (find-world-locations world)
        row-count (find-world-rows world)]
    (mapv vec (partition row-count (mapv #(evaluate-life world %) world-locations)))))

(defn -main []
  (loop [pattern patterns/caterer]
    (let [formatted-world (replace-with-printable-chars pattern)]
      (io/sleep 1000)
      (io/clear-scr)
      (io/display formatted-world)
      (recur (evolve pattern)))))
(ns game-of-life.core
  (:require [game-of-life.patterns :as patterns]))

(def countif (comp count filter))

(defn- find-square-plot [cell-location]
  (for [x [-1 0 1]
        y [-1 0 1]]
    [(+ (first cell-location) x) (+ (last cell-location) y)]))

(defn- find-neighbor-indices [cell-location]
  (let [self-and-neighbors (find-square-plot cell-location)]
    (filter #(not= cell-location %) self-and-neighbors)))

(defn- find-board-upper-boundary [board]
  [(dec (count board)) (dec (count (last board)))])

(defn- within-lower-bounds? [neighbor-cell-location]
  (every? #(>= % 0) neighbor-cell-location))

(defn- within-upper-bounds? [boundary neighbor-cell-location]
  (every? #(>= % 0) [(- (first boundary) (first neighbor-cell-location)) (- (last boundary) (last neighbor-cell-location))]))

(defn- remove-out-of-bounds [board cell-location]
  (let [neighbors (find-neighbor-indices cell-location)
        upper-boundary (find-board-upper-boundary board)]
    (filter #(and (within-lower-bounds? %) (within-upper-bounds? upper-boundary %)) neighbors)))

(defn- count-number-of-living-neighbors [board cell-location]
  (let [neighbor-locations (remove-out-of-bounds board cell-location)]
  (countif #(= 1 (get-in board %)) neighbor-locations)))

(defn- evaluate-life [board cell-location]
  (let [living-neighbors (count-number-of-living-neighbors board cell-location)
        cell-value (get-in board cell-location)]
    (cond
      (< living-neighbors 2)
        0
      (> living-neighbors 3)
        0
      (= living-neighbors 3)
        1
      :else
        cell-value)))

(defn- find-board-locations [board]
  (for [[x row] (map-indexed vector board) 
        [y val] (map-indexed vector row)]
    [x y]))

(defn- find-board-rows [board]
  (count board))

(defn evolve [board]
  (let [board-locations (find-board-locations board)
        row-count (find-board-rows board)]
    (mapv vec (partition row-count (mapv #(evaluate-life board %) board-locations)))))

(defn -main []
  (let [initial-pattern patterns/blinker]
    (evolve initial-pattern)))
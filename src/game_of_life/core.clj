(ns game-of-life.core)

(def blinker [[0 0 0]
              [1 1 1]
              [0 0 0]])

(def countif (comp count filter))

(defn- find-square-plot [space]
  (for [x [-1 0 1]
        y [-1 0 1]]
    [(+ (first space) x) (+ (last space) y)]))

(defn- find-neighbor-indices [space]
  (let [self-and-neighbors (find-square-plot space)]
    (filter #(not= space %) self-and-neighbors)))

(defn- find-board-upper-boundary [board]
  [(dec (count board)) (dec (count (last board)))])

(defn- within-lower-bounds? [neighbor-space]
  (every? #(>= % 0) neighbor-space))

(defn- within-upper-bounds? [boundary neighbor-space]
  (every? #(>= % 0) [(- (first boundary) (first neighbor-space)) (- (last boundary) (last neighbor-space))]))

(defn- remove-out-of-bounds [board space]
  (let [neighbors (find-neighbor-indices space)
        upper-boundary (find-board-upper-boundary board)]
    (filter #(and (within-lower-bounds? %) (within-upper-bounds? upper-boundary %)) neighbors)))

(defn- count-number-of-living-neighbors [neighbor-locations board]
  (countif #(= 1 (get-in board %)) neighbor-locations))

(defn- living-condition [board]
  ; alive if living-neighbors < 2 or > 3, => 0
  ; alive if living-neighbors == 2 or 3 => 1
  ; alive if living-neighbors == 3 => 1 
  ; alive if living-neighbors == 3 =>
  )

(defn- evolve [board]
  ; for each space, evaluate # living neighbors
  ; replace old value with new value for each space
  )

(defn run [initial-pattern]
  (let [space [1 1]
        valid-neighbor-spaces (remove-out-of-bounds initial-pattern space)]
    (count-number-of-living-neighbors valid-neighbor-spaces initial-pattern)))

(defn -main []
  (let [initial-pattern blinker]
    (run initial-pattern)))
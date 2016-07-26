(ns game-of-life.core
  (:require [speclj.core :refer :all]
            [game-of-life.core :as game]))

(def blinker [[0 0 0]
              [1 1 1]
              [0 0 0]])

(describe "evolve"
  (it "changes the values of the board cells"
    (let [board blinker
          new-board (game/evolve board)]
      (should= 0 (get-in new-board [0 0]))
      (should= 1 (get-in new-board [0 1]))
      (should= 0 (get-in new-board [0 2]))
      (should= 0 (get-in new-board [1 0]))
      (should= 1 (get-in new-board [1 1]))
      (should= 0 (get-in new-board [1 2]))
      (should= 0 (get-in new-board [2 0]))
      (should= 1 (get-in new-board [2 1]))
      (should= 0 (get-in new-board [2 2])))))
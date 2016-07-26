(ns game-of-life.core
  (:require [speclj.core :refer :all]
            [game-of-life.core :as game]))

(def blinker [[0 0 0]
              [1 1 1]
              [0 0 0]])

(describe "run"
  (it "dies if there are fewer than 2 adjacent cells"
    (let [board blinker
          new-board (game/run board)]
      (should= 0 (get-in new-board [0 0]))
      (should= 1 (get-in new-board [0 1]))
      (should= 0 (get-in new-board [0 2]))
      (should= 0 (get-in new-board [1 0]))
      (should= 1 (get-in new-board [1 1]))
      (should= 0 (get-in new-board [1 2]))
      (should= 0 (get-in new-board [2 0]))
      (should= 1 (get-in new-board [2 1]))
      (should= 0 (get-in new-board [2 2])))))
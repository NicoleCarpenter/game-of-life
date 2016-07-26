(ns game-of-life.core
  (:require [speclj.core :refer :all]
            [game-of-life.patterns :as patterns]
            [game-of-life.core :as game]))

(describe "evolve block"
  (it "does not change the values of the block cells"
    (let [first-gen patterns/block
          second-gen (game/evolve first-gen)]
      (should= second-gen first-gen))))

(describe "evolve beehive"
  (it "does not change the values of the beehive cells"
    (let [first-gen patterns/beehive
          second-gen (game/evolve first-gen)]
      (should= second-gen first-gen))))

(describe "evolve blinker"
  (it "changes the values of the blinker cells"
    (let [first-gen patterns/blinker
          second-gen (game/evolve first-gen)
          third-gen (game/evolve second-gen)]
      (should= second-gen
               [[0 0 0 0 0]
                [0 0 1 0 0]
                [0 0 1 0 0]
                [0 0 1 0 0]
                [0 0 0 0 0]])

      (should= third-gen first-gen))))

(describe "evolve beacon"
  (it "changes the values of the beacon cells"
    (let [first-gen patterns/beacon
          second-gen (game/evolve first-gen)
          third-gen (game/evolve second-gen)]
      (should= second-gen
               [[0 0 0 0 0 0]
                [0 1 1 0 0 0] 
                [0 1 1 0 0 0]
                [0 0 0 1 1 0]
                [0 0 0 1 1 0]
                [0 0 0 0 0 0]])

      (should= third-gen first-gen))))

(describe "evolve toad"
  (it "changes the values of the toad cells"
    (let [first-gen patterns/toad
          second-gen (game/evolve first-gen)
          third-gen (game/evolve second-gen)]
      (should= second-gen
               [[0 0 0 0 0 0]
                [0 0 0 1 0 0]
                [0 1 0 0 1 0]
                [0 1 0 0 1 0]
                [0 0 1 0 0 0]
                [0 0 0 0 0 0]])

      (should= third-gen first-gen))))

(describe "evolve caterer"
  (it "changes the values of the caterer cells"
    (let [first-gen patterns/caterer
          second-gen (game/evolve first-gen)
          third-gen (game/evolve second-gen)
          fourth-gen (game/evolve third-gen)]
      (should= second-gen
               [[0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 1 1 0 0 0 0 0 0 0]
                [0 0 0 1 1 1 1 0 1 0 0 0]
                [0 0 0 1 0 1 0 0 1 1 1 0]
                [0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 0 0 1 1 0 0 0]
                [0 0 0 0 0 0 0 1 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0]])

      (should= third-gen
               [[0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 1 0 0 0 0 0 0 0 0]
                [0 0 1 0 0 0 1 1 1 0 0 0]
                [0 0 0 1 0 1 1 1 1 1 0 0]
                [0 0 0 0 0 0 0 1 0 0 0 0]
                [0 0 0 0 0 0 0 1 1 0 0 0]
                [0 0 0 0 0 0 0 1 1 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0]])

      (should= fourth-gen first-gen))))

(describe "evolve pulsar"
  (it "changes the values of the pulsar cells"
    (let [first-gen patterns/pulsar
          second-gen (game/evolve first-gen)
          third-gen (game/evolve second-gen)
          fourth-gen (game/evolve third-gen)]
      (should= second-gen
               [[0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0]
                [0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0]
                [0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                [0 1 1 1 0 0 1 1 0 1 1 0 0 1 1 1 0]
                [0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 0 0]
                [0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0]
                [0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 0 0]
                [0 1 1 1 0 0 1 1 0 1 1 0 0 1 1 1 0]
                [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0]
                [0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0]
                [0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]])

      (should= third-gen
               [[0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 1 1 0 0 0 0 0 1 1 0 0 0 0]
                [0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0]
                [0 0 1 0 0 1 0 1 0 1 0 1 0 0 1 0 0]
                [0 0 1 1 1 0 1 1 0 1 1 0 1 1 1 0 0]
                [0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 0 0]
                [0 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 0]
                [0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 0 0]
                [0 0 1 1 1 0 1 1 0 1 1 0 1 1 1 0 0]
                [0 0 1 0 0 1 0 1 0 1 0 1 0 0 1 0 0]
                [0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0]
                [0 0 0 0 1 1 0 0 0 0 0 1 1 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]])

      (should= fourth-gen first-gen))))





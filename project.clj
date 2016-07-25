(defproject game-of-life "0.1.0-SNAPSHOT"
  :description "Conway's Game of Life console application in Clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "2.0.0"]]
  :plugins [[speclj "3.3.1"]]
  :profiles {:dev {:dependencies [[speclj "3.3.1"]]}}
  :test-paths ["spec"]
  :main game-of-life.core)
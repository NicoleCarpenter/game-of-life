(ns game-of-life.user-interface)

(defn- flatten-rows [board]
  (for [row board]
    (clojure.string/join " " row)))

(defn- format-board [board]
  (let [flattened-rows (flatten-rows board)]
    (for [row flattened-rows]
      (str row "\n"))))

(defn print-board [board]
  (let [formatted-board (format-board board)]
    (println (clojure.string/join formatted-board))))
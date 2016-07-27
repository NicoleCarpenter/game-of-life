(ns game-of-life.io)

(defn display [output]
  (println output))

(defn clear-scr []
  (let [esc (char 27)]
    (print (str esc "[2J"))
    (print (str esc "[;H"))))

(defn sleep [ms]
  (Thread/sleep ms))
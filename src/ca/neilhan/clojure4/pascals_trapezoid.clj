(ns ca.neilhan.clojure4.pascals-trapezoid
  (:gen-class))

(defn -main [& args]
  (println
    (take 10
          (#(letfn [(pascals [xs]
                      (into [] (map +' (concat xs [0]) (concat [0] xs))))
                    ]
              (iterate pascals %1)
              )
            [2 4 2]
            )
          )
    )
  (println args))

(fn [xs]
  (iterate
    #(map +' (concat [0] %) (concat % [0]))
    xs)
  )
(ns ca.neilhan.clojure4.pascals-trapezoid
  (:gen-class))

(defn -main [& args]
  (println
    (take 100
          (#(letfn [
                    (pascals [xs]
                      (let [l (concat xs [0]),
                            r (concat [0] xs)]
                        (into [] (map +' l r))
                        ))
                    (pascals-lazy-seq [xs]
                      (lazy-seq (cons xs (pascals-lazy-seq (pascals xs)))))]
              (pascals-lazy-seq %1)
              )
            [2 4 2]
            )
          )
    )
  (println args))


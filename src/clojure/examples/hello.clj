(ns clojure.examples.hello
  (:gen-class)
  (:require [clojure.set :as set]))


(#(letfn [
          (get-max [& n] (->> n
                              (map (fn [x] (if (< x 1) (numerator x) x)))
                              (reduce *)
                              )
            )
          (get-1m-set [max n] (let [count (/ max n)] (map * (range 1 (inc count)) (repeat n))))
          (get-lcm [& n] (->> n
                              (map (fn [x] (get-1m-set (apply get-max n) x)))
                              (map set)
                              (reduce clojure.set/intersection)
                              (apply min)
                              )
            )
          ]
    (println
      (apply get-lcm %&)
      )
    )
  7N 5/7 2 3/5
  )


; (println (get-max 1/3 2/5))
; (println (get-1m-set (get-max 1/3 2/5) 1/3))
; (println (get-lcm 1/3 2/5))


(ns ca.neilhan.clojure4.flipping_out
  (:gen-class)
  (:require [clojure.set :as set]))


(def __
  (fn [f]
    (fn [a b]
      (f b a))
    )
  )

; Write a higher-order function which flips the order of the arguments of an input function.


(println
  (= 3 ((__ nth) 2 [1 2 3 4 5]))
  )

(println (= true ((__ >) 7 8))
         )

(println
  (= 4 ((__ quot) 2 8))
  )

(println
  (= [1 2 3] ((__ take) [1 2 3 4 5] 3)))
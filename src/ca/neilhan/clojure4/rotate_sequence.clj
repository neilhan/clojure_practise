(ns ca.neilhan.clojure4.rotate_sequence
  (:gen-class)
  (:require [clojure.set :as set]))


(def __
  (fn [start xs]
    (let [size (count xs)]
      (->> xs
           cycle
           (drop (mod start size))
           (take size)
           )
      )
    )
  )

; Write a function which can rotate a sequence in either direction.

(println
  (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
  )
(println
  (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
  )
(println
  (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
  )
(println
  (= (__ 1 '(:a :b :c)) '(:b :c :a))
  )
(println
  (= (__ -4 '(:a :b :c)) '(:c :a :b))
  )


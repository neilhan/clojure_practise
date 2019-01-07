(ns ca.neilhan.clojure4.reverse_interleave
  (:gen-class)
  (:require [clojure.set :as set]))

(def __
  (fn [xs ng]
    (apply map vector (partition ng xs)))
  )
; Write a function which reverses the interleave process into x number of subsequences.

(println
  (= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
  )
(println
  (= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
  )
(println
  (= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))
  )


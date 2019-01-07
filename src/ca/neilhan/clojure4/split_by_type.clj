(ns ca.neilhan.clojure4.split_by_type
  (:gen-class)
  (:require [clojure.set :as set]))

; other solutions
; #(vals (group-by type %))
(def __
  (fn [xs] (->> xs
                (map #(hash-map (type %) `(~%)))
                (apply merge-with concat)
                vals
                ))
  )
;(vals
;  (apply merge-with concat
;         (map #(hash-map (type %) `(~%)) xs))
;  ))

; Write a function which takes a sequence consisting of items with different types and splits them
; up into a set of homogeneous sub-sequences. The internal order of each sub-sequence should be maintained,
; but the sub-sequences themselves can be returned in any order (this is why 'set' is used in the test cases).

(println
  (= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))

(println
  (= (set (__ [:a "foo" "bar" :b])) #{[:a :b] ["foo" "bar"]}))

(println
  (= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}))

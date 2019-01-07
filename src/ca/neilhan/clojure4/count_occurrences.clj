(ns ca.neilhan.clojure4.count_occurrences
  (:gen-class)
  (:require [clojure.set :as set]))

(def __
  (fn [xs] (->> xs
                (group-by identity)
                (#((fn [m] (for [[k v] m] [k (count v)])) %))
                (into {})))
  )

;Write a function which returns a map containing the number of occurences of each distinct item in a sequence.

(println
  (= (__ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))

(println
  (= (__ [:b :a :b :a :b]) {:a 2, :b 3}))

(println
  (= (__ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2}))
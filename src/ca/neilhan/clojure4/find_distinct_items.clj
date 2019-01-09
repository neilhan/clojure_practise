(ns ca.neilhan.clojure4.find_distinct_items
  (:gen-class))

; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.

; others solution:
; #(sort-by (fn [i] (.indexOf % i)) (map first (group-by identity %)))
(defn __
  [xs]
  (println (sort-by (fn [x] (.indexOf xs x)) (map first (group-by identity xs))))
  )

; my first try
(defn ___
  [xs]
  (second (reduce (fn [[the_set result], x] (if (contains? the_set x)
                                              [the_set result]
                                              (list (conj the_set x) (conj result x))))
          [#{} []] xs))
  ) 


(println 
  (= (__ [1 2 1 3 1 2 4]) [1 2 3 4]))

(println 
  (= (__ [:a :a :b :b :c :c]) [:a :b :c]))

(println 
  (= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))

(println 
  (= (__ (range 50)) (range 50)))

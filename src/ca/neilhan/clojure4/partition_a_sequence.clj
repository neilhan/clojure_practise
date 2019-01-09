(ns ca.neilhan.clojure4.partition_a_sequence
  (:gen-class))

; Write a function which returns a sequence of lists of x items each. Lists of less than x items should not be returned.
(defn __
  [n xs]
  (letfn [(recur-next [n xs]
            (if (or (< (count xs) n)(empty? xs))
              nil
              (lazy-seq (cons (take n xs) (recur-next n (drop n xs))))) 
              )
          ]
    (recur-next n xs)
    )
  )


(println 
  (= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))

(println 
  (= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))

(println 
  (= (__ 3 (range 8)) '((0 1 2) (3 4 5))))

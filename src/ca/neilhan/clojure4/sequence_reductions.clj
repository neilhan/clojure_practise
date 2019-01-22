(ns ca.neilhan.clojure4.sequence_reductions
  (:gen-class))

; Write a function which behaves like reduce, 
; but returns each intermediate value of the reduction. 
; Your function must accept either two or three arguments, 
; and the return sequence must be lazy.

(defn __ 
  ([f xs] (__ f (first xs) (next xs)))
  ([f init xs] (if (empty? xs)
                 (cons init nil)
                 (lazy-seq (cons init (__ f (f init (first xs)) (next xs)))))))

(println (take 5 (__ + (range))))

(println (__ conj [1] [2 3 4]))

(println
  (= (take 5 (__ + (range))) [0 1 3 6 10]))

(println
  (= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]]))

(println
  (= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120))


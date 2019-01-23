(ns ca.neilhan.clojure4.perfect_numbers
  (:gen-class))


; A number is "perfect" if the sum of its divisors equal the number itself. 
; 6 is a perfect number because 1+2+3=6. Write a function which returns true for perfect numbers and false otherwise.

(defn __ [n]
  (letfn [(get_divisors [n]
            (->> (range 1 (inc (/ n 2)))
                (filter #(= 0 (rem n %)))))]
    (= (apply + (get_divisors n)) n)))


(println
  (= (__ 6) true))

(println
  (= (__ 7) false))

(println
  (= (__ 496) true))

(println
  (= (__ 500) false))

(println
  (= (__ 8128) true))

; other's interesting solution
; (fn [n]
;    (->> (range 1 n)
;         (filter #(zero? (mod n %)))
;         (apply +)
;         (= n)))

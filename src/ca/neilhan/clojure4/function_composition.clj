(ns ca.neilhan.clojure4.function_composition
  (:gen-class))


; Write a function which allows you to create function compositions. 
; The parameter list should take a variable number of functions, 
; and create a function that applies them from right-to-left.

(defn __
	[& fns]
	(fn [& v]
      (let [start (apply (first (reverse fns)) v)
            rvs-fns (reverse fns)]
        (reduce (fn [acc x] (x acc)) start (rest rvs-fns))))
)

(println 
  (= [3 2 1] ((__ rest reverse) [1 2 3 4])))

(println 
  (= 5 ((__ (partial + 3) second) [1 2 3 4])))

(println 
  (= true ((__ zero? #(mod % 8) +) 3 5 7 9)))

(println 
  (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world")))

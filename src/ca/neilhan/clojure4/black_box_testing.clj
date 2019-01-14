(ns ca.neilhan.clojure4.black_box_testing
  (:gen-class))

; Some of the intersting solutions:
; #({{} :map #{} :set} (empty %) (if (reversible? %) :vector :list))

;(comp #(cond (= % {}) :map (= % #{}) :set (= (conj % 1 2) [1 2]) :vector true :list) empty)

; #(condp = (nth (str %) 0)
;   \{ :map
;   \c :list
;   \[ :vector
;   \# :set)

(defn __ [col]
  (letfn [
          (isMap? [c]
            (and (associative? c) (not (reversible? c))))
          (isSet? [c]
            (and (not (associative? c)) 
                 (not (reversible? c))
                 (= (count (conj c 1)) (count (conj c 1 1))))
            )
          (isVector? [c]
             (and (associative? c) (reversible? c)))
          ]
    (cond
      (isMap? col) :map
      (isSet? col) :set
      (isVector? col) :vector
      :else :list)))


; Clojure has many sequence types, which act in subtly different ways. 
; The core functions typically convert them into a uniform "sequence" type 
; and work with them that way, but it can be important to understand the behavioral 
; and performance differences so that you know which kind is appropriate for your application.

; Write a function which takes a collection and returns one of 
; :map, :set, :list, or :vector - describing the type of collection it was given.

; You won't be allowed to inspect their class or use the built-in predicates like list? 
; - the point is to poke at them and understand their behavior.


(println 
  (= :map (__ {:a 1, :b 2})))

(println
  (= :list (__ (range (rand-int 20)))))
 
(println
  (= :vector (__ [1 2 3 4 5 6])))

(println
  (= :set (__ #{10 (rand-int 5)})))

(println
  (= [:map :set :vector :list] (map __ [{} #{} [] ()])))



(ns ca.neilhan.clojure4.word_sorting
  (:gen-class))

(defn __ [s]
  (sort-by clojure.string/lower-case (re-seq #"\w+" s)))

; Write a function that splits a sentence up into a sorted list of words. 
; Capitalization should not affect sort order and punctuation should be ignored.

(println 
  (= (__  "Have a nice day.")
     ["a" "day" "Have" "nice"]))
 
(println
  (= (__  "Clojure is a fun language!")
     ["a" "Clojure" "fun" "is" "language"]))

(println
  (= (__  "Fools fall for foolish follies.")
     ["fall" "follies" "foolish" "Fools" "for"]))

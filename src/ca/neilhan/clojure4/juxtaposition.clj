(ns ca.neilhan.clojure4.juxtaposition
  (:gen-class)
  (:require [clojure.set :as set]))

(defn __
  [ & fs]
  (fn [ & xs]
    (for [f fs]
        (apply f xs)
      )
    )
  )

; Take a set of functions and return a new function that takes a variable number of arguments and returns a sequence containing the result of applying each function left-to-right to the argument list.

(println
  (= [21 6 1] ((__ + max min) 2 3 5 1 6 4)))

(println
  (= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello")))

(println
  (= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10})))

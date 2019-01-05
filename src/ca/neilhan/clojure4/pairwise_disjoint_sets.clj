(ns ca.neilhan.clojure4.pairwise_disjoint_sets
  (:gen-class)
  (:require [clojure.set :as set]))

; other solution
; #(apply distinct? (apply concat %))

(def __
  "Given a set of sets, create a function which returns true if no two of those sets
  have any elements in common1 and false otherwise. Some of the test cases are a bit tricky,
  so pay a little more attention to them.\n\n1Such sets are usually called pairwise disjoint
  or mutually disjoint."
  (fn [s]
    (= (reduce #(+ %1 (count %2)) 0 s)
       (count
         (reduce clojure.set/union s)
         )
       )
    )
  )

(println
  (= (__ #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
     true)
  )

(println
  (= (__ #{#{:a :b :c :d :e}
           #{:a :b :c :d}
           #{:a :b :c}
           #{:a :b}
           #{:a}})
     false)
  )

(println
  (= (__ #{#{[1 2 3] [4 5]}
           #{[1 2] [3 4 5]}
           #{[1] [2] 3 4 5}
           #{1 2 [3 4] [5]}})
     true)
  )

(println
  (= (__ #{#{'a 'b}
           #{'c 'd 'e}
           #{'f 'g 'h 'i}
           #{''a ''c ''f}})
     true)
  )

(println
  (= (__ #{#{'(:x :y :z) '(:x :y) '(:z) '()}
           #{#{:x :y :z} #{:x :y} #{:z} #{}}
           #{'[:x :y :z] [:x :y] [:z] [] {}}})
     false)
  )

(println
  (= (__ #{#{(= "true") false}
           #{:yes :no}
           #{(class 1) 0}
           #{(symbol "true") 'false}
           #{(keyword "yes") ::no}
           #{(class '1) (int \0)}})
     false)
  )

(println
  (= (__ #{#{distinct?}
           #{#(-> %) #(-> %)}
           #{#(-> %) #(-> %) #(-> %)}
           #{#(-> %) #(-> %) #(-> %)}})
     true)
  )

(println
  (= (__ #{#{(#(-> *)) + (quote mapcat) #_nil}
           #{'+ '* mapcat (comment mapcat)}
           #{(do) set contains? nil?}
           #{,,, #_,, empty?}})
     false)
  )

(println
  (= (__ #{#{(#(-> *)) + (quote mapcat) #_nil}
           #{'+ '* mapcat (comment mapcat)}
           #{(do) set contains? nil?}
           #{,,, #_,, empty?}})
     false)
  )


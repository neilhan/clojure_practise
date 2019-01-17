(ns ca.neilhan.clojure4.filter_perfect_squares
  (:gen-class))

; better solution
; #(->> (re-seq #"\d+" %)
;  (map read-string)
;  (filter (fn [x] (== (Math/sqrt x) (int (Math/sqrt x)))))
;  (clojure.string/join ","))

(defn __ [s]
    (->> (re-seq #"\d+" s)
        (map #(java.lang.Integer/valueOf %))
        (filter (fn [x] (== (Math/sqrt x) (int (Math/sqrt x)))))
        (clojure.string/join ",")
        )
  )

; first impl
(defn ___ [s]
  (letfn [
          (perfect_squares 
            ([] (map #(* % %) (range)))
            ([max] (take-while #(<= % max) (perfect_squares))))
          ]
    (->> (re-seq #"\d+" s)
        (map #(java.lang.Integer/valueOf %))
        (filter #(contains? (set (perfect_squares %)) %))
        (clojure.string/join ",")
        )
    )
  )

; Given a string of comma separated integers, write a function which returns 
; a new comma separated string that only contains the numbers which are perfect squares.

(println 
  (= (__ "4,5,6,7,8,9") "4,9"))

(println 
  (= (__ "15,16,25,36,37") "16,25,36"))

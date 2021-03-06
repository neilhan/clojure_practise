(ns ca.neilhan.clojure4.anagram_finder
  (:gen-class))

(defn __ [words]
  (->> words
       (group-by set)
       vals
       (filter #(> (count %) 1))
       (map set)
       set
       ))

(println 
  (__ ["meat" "mat" "team" "mate" "eat"]))

; Write a function which finds all the anagrams in a vector of words. 
; A word x is an anagram of word y if all the letters in x can be rearranged 
; in a different order to form y. Your function should return a set of sets, 
; where each sub-set is a group of words which are anagrams of each other. 
; Each sub-set should have at least two words. Words without any anagrams should not be included in the result.

(println
  (= (__ ["meat" "mat" "team" "mate" "eat"])
		#{#{"meat" "team" "mate"}}))

(println
  (= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
		#{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}}))


; other interesting solution
; #(->> (group-by sort %)
;   vals
;   (filter next)
;   (map set)
;   set)


(ns ca.neilhan.clojure4.prime_numbers
  (:gen-class))

(defn __ [n]
  (import 'java.math.BigInteger)
  (letfn [
          (primes [n] 
            (lazy-seq (cons n (primes (.nextProbablePrime (BigInteger/valueOf n))))))
         ]
         (take n (primes 2))))


; Write a function which returns the first x number of prime numbers.

(println
  (= (__ 2) [2 3]))

(println
  (= (__ 5) [2 3 5 7 11]))

(println
  (= (last (__ 100)) 541))

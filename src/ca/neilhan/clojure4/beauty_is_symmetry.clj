(ns ca.neilhan.clojure4.beauty-is-symmetry
  (:gen-class))

(defn -main [& args]
  (let [t1 '(:a (:b nil nil) (:b nil nil)),
        t2 '(:a (:b nil nil) nil),
        t3 '(:a (:b nil nil) (:c nil nil)),
        t4 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
            [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]],
        t5 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
            [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]],
        t6 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
            [2 [3 nil [4 [6 nil nil] nil]] nil]]]
    (letfn [(is-tree? [_] (= 3 (count _)))
            (make-mirror-tree [[root l r]]
              [root
               (if (is-tree? r)
                 (make-mirror-tree r)
                 r)
               (if (is-tree? l)
                 (make-mirror-tree l)
                 l)]
              )
            (is-tree-symmetry? [[root l r]]
              (= l (make-mirror-tree r)))
            ]
      (println "t1 is tree?" (is-tree? t1))
      (println "t1 is symmetry?" (is-tree-symmetry? t1))
      (println "t2 is symmetry?" (is-tree-symmetry? t2))
      (println "t3 is symmetry?" (is-tree-symmetry? t3))
      (println "t4 is symmetry?" (is-tree-symmetry? t4))
      (println "t5 is symmetry?" (is-tree-symmetry? t5))
      (println "t6 is symmetry?" (is-tree-symmetry? t6))
      )
    )
  (println args))


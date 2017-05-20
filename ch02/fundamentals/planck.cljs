(def inc2 
  (fn [x] 
    (+ x 1)))

(defn inc3 [x]
  (+ x 1))

(defn yell []
  (println "Aaaaagh!"))

(defn main [& args]
  (println "A simple function call: (+ 1 2) =>" (+ 1 2))
  (println "Implement our own `inc`: (inc2 8) =>" (inc2 8))
  (println "Our own `inc` using `defn`: (inc3 4) =>" (inc3 4))
  (println "Functions *do not* require arguments: (yell) =>" (yell))
  (println)
  (println "Notice that the 'yelling' ('Aaaaagh!') occurs *before* printing the explanation ('Functions...').")
  (println "This behavior occurs because the expression `(yell)` is evaluated, printing the yell, *before*")
  (println "applying `println` to its arguments. `yell` prints text and returns `nil` (which `println` then")
  (println "converts to 'nothing').")
  (println)
  (println "To fix this, use `print` and evaluate `(yell)` immediately afterwards:")
  (print "Functions *do not* require arguments: (yell) => ")
  (yell))

(main)

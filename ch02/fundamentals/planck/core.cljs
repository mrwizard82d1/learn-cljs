(require-macros '[utils.core :as utils-m])
(require '[utils.core :as utils])

(def inc2 
  (fn [x] 
    (+ x 1)))

(defn inc3 [x]
  (+ x 1))

(defn yell []
  (println "Aaaaagh!"))

(defn inc4 
  "Alternate incrementer.
  
  Supply a single argument and returns one more than that argument. Supply multiple arguments and 
  returns one more than the *sum* of the two values.
  "
  ([x] (+ x 1))
  ([x y] (+ x y 1)))

(defn sum 
  "Given any number of numbers, sum them together."
  [& args]
  (apply + args))

(defn minimum-variadic
  "Define a function with a minimum of *two* arguments."
  [x y & args]
  (println "first" x)
  (println "second" y)
  (println "rest" args))

(defn main [& args]
  ;; Simple functions
  (utils/section "Simple functions")
  (utils/demonstrate "A simple function call" (+ 1 2))
  (utils/demonstrate "Implement our own `inc`" (inc2 8))
  (utils/demonstrate "Our own `inc` using `defn`" (inc3 4))
  (utils/demonstrate "Functions *do not* require arguments" (yell))
  (println)
  (println "Notice that the 'yelling' ('Aaaaagh!') occurs *before* printing the result (';; => <>').")
  (println "This behavior occurs because the expression `(yell)` is evaluated, printing the yell, *before*")
  (println "applying `println` to its result `yell` prints text and returns `nil` (which `println` then")
  (println "converts to _nothing_).")
  (println)
  (println "To fix this, use `print` and evaluate `(yell)` immediately afterwards:")
  (print "Functions *do not* require arguments: (yell) => ")
  (yell)
  
  ;; Multiarity functions
  (utils/section "ClojureScript supports multiarity (different implementations based on *number* of arguments).")
  (utils/demonstrate "`inc4` supports a single argument" (inc4 3) 
                     "and supports *two* arguments" (inc4 3 4))

  ;; Variadic functions
  (utils/section "ClojureScript supports variadic functions (functions that take any number of arguments)")
  (utils/demonstrate "`sum()` returns" (sum)
                     "`sum(5)` returns" (sum 5)
                     "`sum(5 4 3 2 1)` returns" (sum 5 4 3 2 1))
  (println)
  (println "Variadic functions can have a minimum number of arguments")
  (utils/demonstrate "`minimum-variadic(1 2 3 4)` results in" (minimum-variadic 1 2 3 4))

  ;; Anonymous functions
  (utils/section "Anonymous functions are supported")
  (utils/demonstrate "Immediate invocation of the anonymous function produces", 
                     ((fn [x] (println "The argument to this function is:" x)) "Bonkers!"))
  (println "The ClojureScript reader supports another form of anonymous functions")
  (println "  (#(println \"The argument to this function is:\" %) \"Bonkers!\")")
  (#(println "The argument to this function is:" %) "Bonkers!")
  (println)
  (utils/print-expansion "Interestingly, here's it's expanded form"
                         (#(println "The argument to this function is:" %) "Bonkers!")))

(main)

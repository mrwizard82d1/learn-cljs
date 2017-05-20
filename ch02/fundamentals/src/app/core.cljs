(ns app.core
  (:require [cljs.nodejs :as nodejs])
  (:require-macros [utils.core :as utils]))

(nodejs/enable-util-print!)

(def inc2 
  (fn [x] 
    (+ x 1)))

(defn inc3 [x]
  (+ x 1))

(defn yell []
  (println "Aaaaagh!"))

(defn main [& args]
  (utils/demonstrate "A simple function call" (+ 1 2))
  (utils/demonstrate "Implement our own `inc`" (inc2 8))
  (utils/demonstrate "Our own `inc` using `defn`" (inc3 4))
  (utils/demonstrate "Functions *do not* require arguments" (yell))
  (println)
  (println "Notice that the 'yelling' ('Aaaaagh!') occurs *before* printing the result (';; => ').")
  (println "This behavior occurs because the expression `(yell)` is evaluated, printing the yell, *before*")
  (println "applying `println` to its result `yell` prints text and returns `nil` (which `println` then")
  (println "converts to _nothing_).")
  (println)
  (println "To fix this, use `print` and evaluate `(yell)` immediately afterwards:")
  (print "Functions *do not* require arguments: (yell) => ")
  (yell))

(set! *main-cli-fn* main)

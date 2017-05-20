(ns utils.core)

(defmacro demo-one [prefix expr]
  `(do
     (println (str ~prefix ":"))
     (println (str"  " '~expr))
     (println (str"  ;; => " ~expr))))

(defmacro demonstrate-helper
  ([] nil)
  ([prefix expr] `(demo-one ~prefix ~expr))
  ([prefix expr & args]
   `(do 
      (demo-one ~prefix ~expr)
      (demonstrate-helper ~@args)))) 

(defmacro demonstrate [& args]
  "Demonstrate a particular ClojureScript feature."
  `(do
     (println)
     (demonstrate-helper ~@args)))

(defmacro print-expansion [prefix expr]
  `(do
     (println (str ~prefix ":"))
     (println (str"  " '~expr))))


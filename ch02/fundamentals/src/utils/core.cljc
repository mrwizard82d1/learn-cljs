(ns utils.core)

(defmacro demo-separate [prefix expr]
  `(do
     (println)
     (println (str ~prefix ":"))
     (println (str"  " '~expr))
     (println (str"  ;; => " ~expr))))

(defmacro demo-one [prefix expr]
  `(do
     (println (str ~prefix ":"))
     (println (str"  " '~expr))
     (println (str"  ;; => " ~expr))))


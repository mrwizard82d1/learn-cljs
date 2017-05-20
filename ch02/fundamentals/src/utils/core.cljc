(ns utils.core)

(defmacro demonstrate [prefix expr]
  `(do
     (println)
     (println (str ~prefix ":"))
     (println (str"  " '~expr))
     (println (str"  ;; => " ~expr))))

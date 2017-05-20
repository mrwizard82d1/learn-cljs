(ns utils.core
  (:require [clojure.string :as str]))

(defmacro demo-expr [expr]
  `(do 
     (println (str "  " '~expr))
     (println (str "  ;; => " (if ~expr ~expr "nil")))))

(defmacro demo-exprs
  ([] nil)
  ([expr] `(demo-expr ~expr))
  ([expr & exprs]
   `(do
      (demo-expr ~expr)
      (demo-exprs ~@exprs))))

(defmacro demo-one [prefix expr]
  `(do
     (println (str ~prefix ":"))
     (demo-expr ~expr)))

(defmacro demonstrate-helper
  ([] nil)
  ([prefix expr] `(demo-one ~prefix ~expr))
  ([prefix expr & args]
   `(do 
      (demo-one ~prefix ~expr)
      (demonstrate-helper ~@args)))) 

(def separator println)

(defmacro demonstrate [& args]
  "Demonstrate a particular ClojureScript feature."
  `(do
     (separator)
     (demonstrate-helper ~@args)))

(defmacro demonstrate-many [prefix expr & exprs]
  `(do
     (separator)
     (demo-one ~prefix ~expr)
     (demo-exprs ~@exprs)))

(defmacro print-expansion [prefix expr]
  `(do
     (println (str ~prefix ":"))
     (println (str"  " '~expr))))

(defn section [header]
  (separator)
  (println header)
  (println (str/join "" (repeat (count header) "-"))))

(defmacro falsey? [x]
  `(if ~x
     (str ~x " is truthy")
     (str ~x " is falsey")))



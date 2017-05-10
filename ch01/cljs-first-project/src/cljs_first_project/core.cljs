(ns cljs-first-project.core
  (:require [clojure.browser.repl :as repl]))

;; Use `defonce` to ensure single connection persists across reloads.
(defonce conn
  (repl/connect "http://localhost:9000/repl"))

(js/alert "Hello, First ClojureScript REPL!")

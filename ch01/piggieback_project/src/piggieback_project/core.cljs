(ns piggieback-project.core
  (:require [clojure.browser.repl :as repl]))

;; `defonce` allows the connection to persist during many different builds
(defonce conn
  (repl/connect "http://localhost:9000/repl"))

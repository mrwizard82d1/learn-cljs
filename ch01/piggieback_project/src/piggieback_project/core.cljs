(ns piggieback-project.core
  (:require [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

(defn -main [&args]
  (println "Hello World, from Node.js!"))

(set! *main-cli-fn* -main)

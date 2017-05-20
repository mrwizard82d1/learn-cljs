(ns app.core
  (:require [app.functions :as functions]))


(defn -main [& args]
  (let [function-map {"functions" functions/main}]
    (doseq [arg args]
      ((function-map arg)))))


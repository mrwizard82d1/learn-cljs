(ns app.core
  (:require [app.functions :as functions]
            [app.scalars :as scalars]
            ))


(defn -main [& args]
  (let [function-map {"functions" functions/main
                      "scalars" scalars/main
                      }]
    (doseq [arg args]
      ((function-map arg)))))


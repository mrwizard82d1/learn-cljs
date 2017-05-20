(ns app.core
  (:require [cljs.nodejs :as nodejs]
            [app.functions :as functions]
            [app.scalars :as scalars]
            [utils.core :as utils :include-macros true]))

(nodejs/enable-util-print!)

(defn main [& args]
  (let [function-map {"functions" functions/main
                      "scalars" scalars/main
                      }]
    (doseq [arg args]
      ((function-map arg)))))

(set! *main-cli-fn* main)

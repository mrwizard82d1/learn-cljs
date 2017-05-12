;; I am very surprised to see this namespace with the name `figwheel-node-repl because it is in the 
;; project directory src/figwheel_node. I think it can be "misnamed" because it is only served to figwheel
;; but I do no know. We will see.
(ns ^:figwheel-always figwheel-node-repl.core
  (:require [cljs.nodejs :as nodejs]))

;; Enable translating `println` to `console.log`
(nodejs/enable-util-print!)

;; Define the "main" function for the Node.js process. As you can see, it does nothing.
(def -main (fn [] nil))

;; Set the entrypoint for Node.js
(set! *main-cli-fn* -main)


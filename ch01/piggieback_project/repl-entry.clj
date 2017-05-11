;; Code to enter at the REPL to connect to the Node.js

(require 'cljs.build.api)
(require 'cljs.repl.node)

(cljs.build.api/build "src"
                      {:main 'piggieback_project.core ;; The entry point (on the classpath)
                       ;; compile all code into this file
                       :output-to "out/main.js" ;; Compile all code into this JavaScript file
                       :verbose true ;; Display "extra" output
                       })

;; Now start the REPL connected to Node.js 
(cemerick.piggieback/cljs-repl (cljs.repl.node/repl-env))


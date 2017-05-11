;; Code to enter at the REPL to connect to the browser

(require 'cljs.build.api)

;; Build everything in "src". 
;; Start executing `piggieback-project.core`
;; Put the compiled output in "out/main.js"
;; Verbose output
(cljs.build.api/build "src"
                      {:main 'piggieback-project.core
                       :output-to "out/main.js"
                       :verbose true})

(require 'cljs.repl.browser)

;; Connect the ClojureScript REPL to the browser
(cemerick.piggieback/cljs-repl (cljs.repl.browser/repl-env))

;; (js/alert "Hello, World, from Piggieback!")

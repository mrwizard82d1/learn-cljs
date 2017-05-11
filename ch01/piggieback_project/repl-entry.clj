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

;; We're using Weasel to communicate
(require 'weasel.repl.websocket)O

;; Connect the ClojureScript REPL to the browser
(cemerick.piggieback/cljs-repl (weasel.repl.websocket/repl-env :ip "0.0.0.0"
                                                               :port 9001))

;; (js/alert "Hello, World, from Weasel!")

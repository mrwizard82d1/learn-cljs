(defproject figwheel_node "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.521"]]
  ;; We use both the ClojureScript and Figwheel plugins. `lein-cljsbuild` allows one to invoke the compiler
  ;; via the command line: `lein cljsbuild`. I'm unclear what else this plugin supports.
  :plugins [[lein-cljsbuild "1.1.6"]
            [lein-figwheel "0.5.10"]]
  ;; Directory(ies) to clean
  :clean ["out"]
  ;; Configure the ClojureScript builds (even though we only define one).
  :cljsbuild {:builds [{;; We call this build externally "server-dev"
                        :id "server-dev"
                        ;; Our code is in "src"
                        :source-paths ["src"] 
                        ;; "Automagically" inserts our application code into figwheel
                        :figwheel true
                        ;; Configure the compiler itself
                        :compiler {;; Begine by executing `figwheel-node-repl.core. Apparently, the value can
                                   ;; be either a `Symbol` or a string (the name of the `Symbol`)
                                   :main figwheel-node-repl.core
                                   ;; The path of the produced JavaScript file
                                   :output-to "out/figwheel_node_repl.js"
                                   ;; Location of temporary files produced during compilation
                                   :output-dir "out"
                                   ;; Target output for Node.js (default JavaScript)
                                   :target :nodejs
                                   ;; Set the optimization level. I'm uncertain if it must be none for
                                   ;; Node.js - but based on previous work, I do not believe so.
                                   :optimizations :none
                                   ;; Include a source map (for debugging)
                                   :source-map true}}]}
  ;; I believe we supply *no* options to `figwheel`
  :figwheel {})

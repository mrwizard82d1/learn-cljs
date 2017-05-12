(defproject figwheel_project "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.521"]]
  ;; figwheel is a lein plugin. A plugin allows us to execute `lein figwheel` to start our server.
  :plugins [[lein-figwheel "0.5.10"]] 
  :clean-targets [:target-path "out"] ;; clean the "out" directory
  ;; Configure the ClojureScript build process. See 
  ;; https://github.com/clojure/clojurescript/wiki/Compiler-Options#output-to for details
  :cljsbuild { 
              ;; it supports multiple build targets
              :builds [{
                        :id "dev" ;; each build is distinguished by an :id
                        :source-paths ["src"] ;; the paths containing ClojureScript to be compiled
                        :figwheel true ;; use figwheel to compile source
                        ;; configure the compiler
                        :compiler {
                                   ;; start executing code in this namespace
                                   :main "figwheel-project.core" 
                                   ;; relative url of scripts loaded by web server
                                   :asset-path "js/out" 
                                   ;; path of JavaScript file to be output (default "out")
                                   :output-to "resources/public/js/main.js" 
                                   ;; directory of files emitted in compilation
                                   :output-dir "resources/public/js/out"}}]})

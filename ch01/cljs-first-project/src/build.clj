(require 'cljs.build.api)

(cljs.build.api/build "src"
                      {:output-to "out/main.js"}) ;; The path of the JavaScript file to output.
                       


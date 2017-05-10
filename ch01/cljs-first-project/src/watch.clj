(require 'cljs.build.api)

(cljs.build.api/watch "src"
                      {
                       ;; The program entry point. `goog` loads and executes this module / namespace.
                       ;; By specifying the entry point, I *need not* specify it as the text of the last
                       ;; `script` tag.
                       :main 'cljs-first-project.core 
                       ;; The path of the JavaScript file to output.
                       :output-to "out/main.js"}) 


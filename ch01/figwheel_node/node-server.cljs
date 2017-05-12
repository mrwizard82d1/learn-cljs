;; "Import" the `http` module

(def http (js/require "http"))

;; Use threading macro to better communicate procedural code
(-> http
    (.createServer (fn [req res]
                     (do
                       (.writeHead res
                                   200 ;; Report success
                                   (js-obj "Content-Type" 
                                           "text/plain" ;; Return plain text
                                           ))
                       (.end res
                             "Hello World from Node.js!" ;; response content
                             ))))
    (.listen 1337 ;; listen on port
             "127.0.0.1" ;; on IP address (localhost)
             )) 

(ns app.scalars
  (:require [utils.core :as utils :include-macros true]))

(def a 4)

(defn main []
  ;; Numbers
  (utils/section "Numbers")
  (utils/demonstrate "ClojureScript numbers are just JavaScript numbers" (type 3)
                     "Not just integers - ClojureScript floating point numbers" (type 1.1)
                     "ClojureScript big integers numbers" (type (js/parseInt "141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948"))
                     "As are very small numbers" (type (js/parseFloat "0.00000000000057829734923")))

  ;; Working with numbers
  (utils/section "Working with numbers")
  (utils/demonstrate-many "ClojureScript supports typical arithmetic expressions"
                          (+ 1 2)
                          (- 5 1)
                          (* 3 2)
                          (/ 8 2))
  (utils/demonstrate "ClojureScript does not have a single character modulo operator" (rem 10 3))

  ;; Strings and characters
  (utils/section "Strings and Characters")
  (utils/demonstrate "ClojureScript strings are just JavaScript strings" (type "A String"))
  (utils/demonstrate "ClojureScript characters are single-character JavaScript strings" (type \a))

  ;; Coercing expressions to strings
  (utils/demonstrate-many "We can coerce expressions to strings"
                          (str {})
                          (str 1))
  
  ;; Converting keywords to strings
  (utils/demonstrate "`str` on a keyword preserves the leading colon (:)" (str :hamburger))
  (utils/demonstrate "But `name` on a keyword removes it" (name :sandwich))

  ;; Concatenating strings
  (utils/demonstrate "`str` will concatenate individual strings" (str "this" "is" "all" "one" "word" "now"))

  (utils/demonstrate "Use `count` to calculate the length of a string" (count "my string"))

  (utils/demonstrate "Finally, use `subs` to extract a substring from a string" 
                     (subs "parents just don't understand" 8 18))

  ;; ClojureScript `nil`
  (utils/section "ClojureScript `nil`")
  (utils/demonstrate "ClojureScript `nil` is built on JavaScript `null` - but not the same", (type nil))

  ;; Boolean types and values
  (utils/section "Boolean Types and Values")
  (utils/demonstrate-many "ClojureScript `true` and `false` and just JavaScript booleans" 
                          (type true)
                          (type false))
  (utils/demonstrate-many "A ClojureScript value is 'falsey' if it is either value `false` or `nil`"
                          (utils/falsey? false)
                          (utils/falsey? nil))
  (utils/demonstrate-many "*All* other values are truthy"
                          (utils/falsey? (js-obj "field" "value"))
                          (utils/falsey? 5))
  (utils/demonstrate-many "Surprisingly, empty collections are falsey"
                          (utils/falsey? [])
                          (utils/falsey? {}))

  ;; Special predicates
  (utils/section "Special predicates")
  (utils/demonstrate-many "We use a special predicate `nil?` to test for a literal `nil` value" 
                          (nil? nil)
                          (nil? '()))
  (utils/demonstrate-many (str "Similarly, we use special predicates, `true?` and `false?`,"
                               "\nto test for a literal `true` and `false` values, respectively")
                          (true? true)
                          (true? 5)
                          (false? false)
                          (false? nil))

  ;; Keywords
  (utils/section "Keywords")
  (utils/demonstrate "Keywords are values that evaluate to themselves." :some-keyword)
  (utils/demonstrate (str "A keyword prefixed with a single colon is a global keyword. Use a double colon (\"::\")"
                          "\nto limit a keyword to the current namespace.") ::some-ns-keyword )

  ;; Symbols
  (utils/section "Symbols")
  (utils/demonstrate "Symbols evaluate to other values; however, we can examine a symbol itself" (type 'a))
  (utils/demonstrate "But remember, a symbol typically evaluates to a value" (type a))
  (println (str   Notice that, in the REPL, evaluating `(type 'a)` prints `cljs.core/Symbol`,"
                "\nBut this program prints out the source of a function. Very strange... ))
  )


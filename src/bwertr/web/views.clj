(ns bwertr.web.views
  (:require [hiccup.element :refer [link-to unordered-list]]
            [hiccup.page :refer [html5]]))

(defn template [title & content]
  (html5
   [:head
    [:title "bwertr - " title]]
   [:body
    [:nav
     (unordered-list [(link-to "/" "Willkommen")
                      (link-to "/results" "Ergebnisse")])]
    [:div#content content]]))

(defn welcome []
  (template "willkommen"
            [:h1 "Willkommen auf der JavaLand 2014!"]
            [:p "Ich hoffe, mein Vortrag gefällt Ihnen."]))

(defn results []
  (template "ergebnisse"
            [:h1 "Ergebnisse"]))

(ns bwertr.web.views
  (:require [hiccup.element :refer [link-to unordered-list]]
            [hiccup.form :refer [form-to label select-options submit-button]]
            [hiccup.page :refer [html5 include-css]]))

(defn template [title & content]
  (html5
   [:head
    [:title "bwertr - " title]
    (include-css "/css/bwertr.css")]
   [:body
    [:nav
     (unordered-list [(link-to "/" "Willkommen")
                      (link-to "/results" "Ergebnisse")])]
    [:div#content content]]))

(defn rating-form []
  (list
   [:p "Wenn Sie helfen wollen, ihn zu verbessern, geben Sie bitte eine Wertung ab (1 - am schlechtesten, 10 - am besten):"]
   (form-to [:post "/ratings"]
            (label :rating "Bitte wählen Sie: ")
            [:select#rating {:name :rating}
             (select-options (range 1 11))]
            (submit-button "Jetzt bewerten."))))

(defn average-rating-part [average-rating]
  (if average-rating
    [:p "Im Durchschnitt wurde der Vortrag mit " average-rating " bewertet."]
    [:p "Der Vortrag wurde noch nicht bewertet."]))

(defn welcome [own-rating]
  (template "willkommen"
            [:h1 "Willkommen auf der JavaLand 2014!"]
            [:p "Ich hoffe, mein Vortrag gefällt Ihnen."]
            (if own-rating
              [:p "Sie haben ihn mit " own-rating " von 10 Punkten bewertet."]
              (rating-form))))

(defn results [average-rating]
  (template "ergebnisse"
            [:h1 "Ergebnisse"]
            (average-rating-part average-rating)))

(defn thank-you [own-rating average-rating]
  (template "vielen dank"
            [:h1 "Vielen Dank, ..."]
            [:p "... dass Sie diesen Vortrag mit " own-rating " bewertet haben."]
            (average-rating-part average-rating)))

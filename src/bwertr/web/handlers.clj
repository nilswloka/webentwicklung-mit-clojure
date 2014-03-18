(ns bwertr.web.handlers
  (:require [bwertr.model.ratings :as ratings]
            [bwertr.web.views :as v]))

(defn welcome [request]
  (let [session (:session request)]
    (v/welcome (:own-rating session))))

(defn results [request]
  (v/results (ratings/average)))

(defn admin [request]
  (v/admin (ratings/stats)))

(defn rate [request]
  (let [params (:params request)
        session (:session request)
        rating-param (get params "rating")
        rating-value (Integer/valueOf rating-param)]
    (ratings/add! rating-value)
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body (v/thank-you rating-value (ratings/average))
     :session (into session {:own-rating rating-value})}))

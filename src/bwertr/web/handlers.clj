(ns bwertr.web.handlers
  (:require [bwertr.model.ratings :as ratings]
            [bwertr.web.views :as v]))

(defn welcome [request]
  (v/welcome))

(defn results [request]
  (v/results (ratings/average)))

(defn rate [request]
  (let [params (:params request)
        rating-param (get params "rating")
        rating-value (Integer/valueOf rating-param)]
    (ratings/add! rating-value)
    (v/thank-you rating-value (ratings/average))))

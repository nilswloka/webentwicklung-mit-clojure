(ns bwertr.web.handlers
  (:require [bwertr.web.views :as v]))

(defn welcome [request]
  (v/welcome))

(defn results [request]
  (v/results))

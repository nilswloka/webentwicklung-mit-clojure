(ns bwertr.web.routes
  (:require [bwertr.web.handlers :as h]
            [compojure.core :refer [defroutes GET]]
            [hiccup.middleware :refer [wrap-base-url]]))

(defroutes app-routes
  (GET "/" [] h/welcome)
  (GET "/results" [] h/results))

(def app
  (-> app-routes
      wrap-base-url))

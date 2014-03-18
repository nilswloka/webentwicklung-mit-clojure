(ns bwertr.web.routes
  (:require [bwertr.web.handlers :as h]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [hiccup.middleware :refer [wrap-base-url]]))

(defroutes app-routes
  (GET "/" [] h/welcome)
  (GET "/results" [] h/results)
  (route/resources "/")
  (route/not-found "<h1>Page not found.</h1>"))

(def app
  (-> app-routes
      wrap-base-url))

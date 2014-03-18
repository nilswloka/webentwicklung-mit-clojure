(ns bwertr.web.routes
  (:require [compojure.core :refer [defroutes GET]]))

(defn welcome [request]
  {:status 200
   :headers {"ContentType" "text/html"}
   :body "<h1>Willkommen auf der JavaLand 2014!</h1>"})

(defroutes app
  (GET "/" [] welcome)
  (GET "/results" [] "<h1>Results</h1>"))

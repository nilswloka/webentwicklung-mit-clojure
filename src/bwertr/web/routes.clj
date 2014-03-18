(ns bwertr.web.routes
  (:require [bwertr.model.users :as users]
            [bwertr.web.handlers :as h]
            [cemerick.friend :as friend]
            [cemerick.friend.credentials :as credentials]
            [cemerick.friend.workflows :as workflows]
            [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [hiccup.middleware :refer [wrap-base-url]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.session :refer [wrap-session]]
            [ring.middleware.session.cookie :refer [cookie-store]]))

(defroutes app-routes
  (GET "/" [] h/welcome)
  (GET "/results" [] h/results)
  (GET "/admin" [] (friend/authenticated #{::admin} h/admin))
  (POST "/ratings" [] h/rate)
  (route/resources "/")
  (route/not-found "<h1>Page not found.</h1>"))

(def app
  (-> app-routes
      wrap-base-url
      wrap-params
      (wrap-session {:store (cookie-store {:key "JavaLand2014!!!!"})})
      (friend/authenticate {:allow-anon? true
                            :unauthenticated-handler #(workflows/http-basic-deny "bwertr" %)
                            :workflows [(workflows/http-basic
                                         :credential-fn #(credentials/bcrypt-credential-fn (users/all) %)
                                         :realm "bwertr")]})))

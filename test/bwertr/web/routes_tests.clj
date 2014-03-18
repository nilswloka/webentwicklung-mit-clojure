(ns bwertr.web.routes-tests
  (:require [bwertr.web.routes :refer :all]
            [clojure.test :refer :all]
            [ring.mock.request :refer [request]]))

(deftest root-route-shows-welcome-page
  (let [get-root (request :get "/")
        response-body (-> get-root app :body)]
    (is (.contains response-body "Willkommen auf der JavaLand 2014!"))))

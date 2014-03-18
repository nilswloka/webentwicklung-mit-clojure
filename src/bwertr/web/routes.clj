(ns bwertr.web.routes
  (:require [bwertr.web.handlers :as h]
            [compojure.core :refer [defroutes GET]]))

(defroutes app
  (GET "/" [] h/welcome)
  (GET "/results" [] h/results))

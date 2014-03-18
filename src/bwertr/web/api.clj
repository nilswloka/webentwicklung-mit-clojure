(ns bwertr.web.api
  (:require [bwertr.model.ratings :as ratings]
            [clojure.data.json :as json]
            [liberator.core :refer [defresource]]))

(defresource ratings
  :available-media-types ["application/json"]
  :handle-ok (fn [_] (json/write-str (ratings/all))))

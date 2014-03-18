(ns bwertr.model.users
  (:require [cemerick.friend.credentials :as credentials]))

(defn all []
  {"admin" {:username "admin"
            :password (credentials/hash-bcrypt "admin")
            :roles #{::admin}}})

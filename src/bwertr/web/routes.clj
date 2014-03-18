(ns bwertr.web.routes)

(defn app [request]
  {:status 200
   :headers {"ContentType" "text/html"}
   :body "<h1>Willkommen auf der JavaLand 2014!</h1>"})

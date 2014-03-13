(defproject bwertr "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[compojure "1.1.6"]
                 [com.cemerick/friend "0.2.0"]
                 [hiccup "1.0.4"]
                 [liberator "0.10.0"]
                 [org.clojure/clojure "1.5.1"]                 
                 [org.clojure/data.json "0.2.3"]
                 [ring/ring "1.2.1"]]
  :profiles {:dev {:dependencies [[lein-ring "0.8.8"]
                                  [ring-mock "0.1.5"]]}}
  :plugins [[lein-ring "0.8.8"]]
  :ring {:handler bwertr.web.routes/app})

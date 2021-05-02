(ns todo-api.main
  (:require [compojure.core :refer [defroutes routes]]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.adapter.jetty :as jetty]
            [clojure.walk :refer [prewalk prewalk-demo]]
            [todo-api.config.http.cors :as cors])
  (:gen-class :main true))


(defroutes default
           (route/resources "/")
           (route/not-found "Not Found"))
(def app
  (-> (routes default)
      (wrap-json-response)
      (cors/wrap-response-cors)))

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port) :join? false}))
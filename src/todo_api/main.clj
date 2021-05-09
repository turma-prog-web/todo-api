(ns todo-api.main
  (:require [compojure.core :refer [defroutes routes]]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.adapter.jetty :as jetty]
            [clojure.walk :refer [prewalk prewalk-demo]]
            [todo-api.config.http.cors :as cors]
            [todo-api.domains.tasks.route :refer :all]
            [todo-api.domains.user.route :refer :all])
  (:gen-class :main true))

(def app
  (-> (routes task-routes user-routes)
      (wrap-json-response)
      (cors/wrap-response-cors)))

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port) :join? false}))
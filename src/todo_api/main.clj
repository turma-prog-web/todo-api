(ns todo-api.main
  (:require [compojure.core :refer [defroutes routes]]
            [compojure.route :as route]
            [clojure.walk :refer [prewalk prewalk-demo]])
  (:gen-class :main true))

(defroutes default
           (route/resources "/")
           (route/not-found "Not Found"))
(def app
  (-> (routes default)))
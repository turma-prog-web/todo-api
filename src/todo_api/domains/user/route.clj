(ns todo-api.domains.user.route
  (:require  [compojure.core :refer :all]
             [clojure.data.json :as json]
             [todo-api.shared.http-utils]))


(defroutes user-routes
           (OPTIONS "/users" []
             {:status 200}))
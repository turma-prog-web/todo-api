(ns todo-api.tasks.route
  (:require [compojure.core :refer :all]
            [clojure.data.json :as json]
            [todo-api.tasks.service :as service]
            [todo-api.shared.http-utils :as http-utils]))
(defn todo-representation [todo]
  (assoc todo :url (str "/todos/" (:id todo))))

(defroutes task-routes
           (OPTIONS "/tasks" []
             {:status 200})
           (GET "/todos/:id" {{id :id} :params}
             (-> (service/get-todo id)
                 todo-representation
                 http-utils/res->ok)))
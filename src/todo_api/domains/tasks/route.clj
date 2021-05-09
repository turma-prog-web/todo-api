(ns todo-api.domains.tasks.route
  (:require [compojure.core :refer :all]
            [clojure.data.json :as json]
            [todo-api.domains.tasks.service :as service]
            [todo-api.shared.http-utils :as http-utils]))

(defn tasks-representation [task]
  (assoc task :url (str "/tasks/" (:id task))))

(defroutes task-routes
           (OPTIONS "/tasks" []
             {:status 200})
           (GET "/tasks/:id" {{id :id} :params}
             (-> (service/get-task-by-id id)
                 tasks-representation
                 http-utils/res->ok)))
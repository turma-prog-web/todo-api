(ns todo-api.domains.tasks.service
  (:require [clojure.java.jdbc :as jdbc]
            [todo-api.config.database.conn :as db]))
(defn as-todo [row]
  (dissoc (assoc row :order (:sequence row)) :sequence))

(defn get-task-by-id [id]
  (let [query (str "select * from tbl_tasks where id=" id)]
    (first (jdbc/query db/pg [query] :row-fn as-todo))))
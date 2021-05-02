(ns todo-api.tasks.service
  (:require [clojure.java.jdbc :as jdbc]
            [todo-api.config.database.conn :as db]))
(defn as-todo [row]
  (dissoc (assoc row :order (:sequence row)) :sequence))

(defn get-todo [id]
  (let [query (str "select * from tasks where id=" id)]
    (first (jdbc/query db/pg [query] :row-fn as-todo))))
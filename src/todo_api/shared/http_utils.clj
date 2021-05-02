(ns todo-api.shared.http-utils)

(defn res->ok [body]
  {:status 200 :body body})
(ns todo-api.config.http.cors)

(defn cors-headers [request]
  (merge {"access-control-allow-origin" "*"}
         (cond
           (= :options (:request-method request)) {"access-control-allow-headers" "accept, content-type"
                                                   "access-control-allow-methods" "GET,HEAD,POST,DELETE,OPTIONS,PUT,PATCH"}
           :else {})))

(defn wrap-response-cors [app]
  (fn [request]
    (let [response (app request)]
      (assoc-in response [:headers]
                (merge (cors-headers request) (:headers response))))))

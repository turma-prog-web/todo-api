(defproject todo-api "0.1.0-SNAPSHOT"
  :main "todo-api.main"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/data.json "0.2.4"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.3.0"]
                 [ring-server "0.3.1"]
                 [compojure "1.6.1"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [org.clojure/java.jdbc "0.3.6"]
                 [log4j "1.2.17"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler todo-api.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})

(ns sokr-clj.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [sokr-clj.routes :as router]))

(def db-spec
  {:classname   "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname     "//localhost:5434/sokr"
   :user        "postgres"
   :password    "postgres"}
  )

(defn -main
  [& _args]
  (run-jetty router/app {:port 3000})
  (println "ok"))
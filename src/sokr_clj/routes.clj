(ns sokr-clj.routes
  (:require [compojure.api.sweet :refer [api routes]]
            [sokr-clj.handlers :as handlers]))

(def swagger-config
  {:ui "/swagger"
   :spec "/swagger.json"
   :options {:ui {:validatorUrl nil}
             :data {:info {:version "1.0.0", :title "Restful CRUD API"}}}})

(def app (api {:swagger swagger-config}
              (apply routes (concat handlers/user-routes))))
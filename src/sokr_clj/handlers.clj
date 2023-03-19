(ns sokr-clj.handlers
  (:require [schema.core :as s]
            [clojure.pprint]
            [sokr-clj.utils :as util]
            [clojure.set :refer [rename-keys]]
            [ring.util.http-response :refer [created ok not-found]]
            [compojure.api.sweet :refer [POST GET PUT DELETE]]))

(defn valid-username? [name]
  (util/non-blank-with-max-length? 50 name))

(defn valid-password? [password]
  (util/length-in-range? 5 50 password))

(s/defschema UserRequestSchema
  {:username (s/constrained s/Str valid-username?)
   :password (s/constrained s/Str valid-password?)
   :email (s/constrained s/Str util/email?)})

(defn get-users-handler []
   (ok {:message "hello"}))

(defn id->created [id]
  (created (str "/users/" id) {:id id}))

(defn canonicalize-user-req [user-req]
  (-> (update user-req :password hashers/derive)
      (rename-keys {:password :password_hash})))

(defn post-user-handler [create-user-req]
  (->> (canonicalize-user-req create-user-req)
       :id
       id->created))

(def user-routes
  [(GET "/users" [] (get-users-handler))
   (POST "/users" [] 
     :body [create-user-req UserRequestSchema]
     (post-user-handler create-user-req))
   ])
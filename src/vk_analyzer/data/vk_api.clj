(ns vk-analyzer.data.vk-api
  (:require [clj-http.client :as client]))

(defn default-token
  [] "fedfc0f5b921a6c72d368a7182b07bf69a464f68e881184d7a2c6e25f4d42275421deba86b116d5b24760")

(defn prepare-params [params]
  (reduce str (map #(str "&" (name (%1 0)) "=" (%1 1)) params)))


(defn api-path
  ([method params]
   (api-path method params (default-token)))
  ([method params access-token]
   (str "https://api.vk.com/method/" method "?v=5.37" params "&access_token=" access-token)))

(defn get-body [path]
  ((client/get path) :body))


(defn get-user[params]
  (get-body (api-path "users.get" (prepare-params params))))

(defn get-wall[params]
  (get-body (api-path "wall.get" (prepare-params params))))

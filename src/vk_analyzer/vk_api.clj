(ns vk-analyzer.vk-api
  (:require [clj-http.client :as client]))

(defn default-token
  [] "fedfc0f5b921a6c72d368a7182b07bf69a464f68e881184d7a2c6e25f4d42275421deba86b116d5b24760")

(defn api-path
  ([method params]
   (api-path method params (default-token)))
  ([method params access-token]
   (str "https://api.vk.com/method/" method "?v=5.37" params "&access_token=" access-token)))

(defn get-user[user-id]
  (client/get (api-path "users.get" (str "&user_ids=" user-id))))

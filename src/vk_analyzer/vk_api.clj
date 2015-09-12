(ns vk-analyzer.vk-api
  (:require [clj-http.client :as client]))

(defn get-user[user-id]
  (client/get (str "https://api.vk.com/method/users.get?user_ids=" user-id "&v=5.37&access_token=fedfc0f5b921a6c72d368a7182b07bf69a464f68e881184d7a2c6e25f4d42275421deba86b116d5b24760")))

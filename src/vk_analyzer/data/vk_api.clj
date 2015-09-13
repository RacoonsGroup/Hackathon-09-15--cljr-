(ns vk-analyzer.data.vk-api
  (:require [clj-http.client :as client]
    [cheshire.core :refer :all]))

(defn default-token
  [] "fedfc0f5b921a6c72d368a7182b07bf69a464f68e881184d7a2c6e25f4d42275421deba86b116d5b24760")

(defn prepare-params [params]
  (reduce str (map #(str "&" (name (%1 0)) "=" (%1 1)) params)))

(defn parse-response "converts string to json and trim useless info" [data]
  (((parse-string data) "response") "items"))

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
  (if (> (params :count) 100)
      (let [times (/ (params :count) 100)
        data (vec (flatten (map 
                          (fn [x]
                            (parse-response (get-body (api-path "wall.get" (prepare-params (merge params {:count 100}))))))
                          (range times))))]
        data
        )
      (parse-response (get-body (api-path "wall.get" (prepare-params params))))
    )
  )

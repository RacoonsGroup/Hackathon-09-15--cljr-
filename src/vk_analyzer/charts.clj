(ns vk-analyzer.charts
  (:require [cheshire.core :refer :all]
            [clj-http.client :as client]))

(defn get-data []
  (evaluate-likes-count)
  [28, 48, 40, 19, 86, 27, 50])

(defn take-group-info "temporarily function, will be removed in future" []
  (def response ((client/get (str "https://api.vk.com/method/wall.get?domain=mdk&count=3&v=5.37&access_token=fedfc0f5b921a6c72d368a7182b07bf69a464f68e881184d7a2c6e25f4d42275421deba86b116d5b24760")) :body))
  (((parse-string response) "response") "items"))

(defn evaluate-likes-count "should return array of results by hour" []
  (vec (map #(vector (% "date") ((% "likes") "count")) (take-group-info))))

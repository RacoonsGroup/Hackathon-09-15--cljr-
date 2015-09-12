(ns vk-analyzer.charts
  (:require [cheshire.core :refer :all]
            [clj-http.client :as client]))

(defn parse-response "converts string to json and trim useless info" [data]
  (((parse-string data) "response") "items"))

(defn evaluate-likes-count "returns vector of results by hour" [data]
  (vec (map #(vector (% "date") ((% "likes") "count")) (parse-response data))))

(defn analyze-data [data]
  (evaluate-likes-count data)
  [28, 48, 40, 19, 86, 27, 50])

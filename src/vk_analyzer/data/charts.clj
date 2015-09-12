(ns vk-analyzer.data.charts
  (:require [cheshire.core :refer :all]
            [clj-http.client :as client]
            [vk-analyzer.data.analyzer :as analyzer]))

(defn parse-response "converts string to json and trim useless info" [data]
  (((parse-string data) "response") "items"))

(defn evaluate-likes-count "returns vector of results by hour" [data]
  (vec (map #(vector (% "date") ((% "likes") "count")) (parse-response data))))

(defn analyze-data [data]
	(vec (analyzer/get-hours-array (evaluate-likes-count data))))

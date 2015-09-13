(ns vk-analyzer.data.charts
  (:require [cheshire.core :refer :all]
            [clj-http.client :as client]
            [vk-analyzer.data.time-formatter :as time-formatter]
            [vk-analyzer.data.analyzer :as analyzer]))

(defn evaluate-likes-count "returns vector of results by hour" [data]
  (vec (map #(vector (% "date") ((% "likes") "count")) data)))

(defn analyze-data [data]
	(vec (analyzer/get-hours-array (evaluate-likes-count data))))

(defn analyze-data-for-scatter "returns array of arrays for scatter chart" [data]
    (vec(map time-formatter/transform-time (evaluate-likes-count data))))

(ns vk-analyzer.posts-analyzer
	(:require [clj-time.coerce :as coerce]
			  [clj-time.format :as formatter]))

(def hour-formatter (formatter/formatter "HH"))

(defn get-hour [timestamp] 
	;  Учитывать временную зону
	(formatter/unparse hour-formatter 
		(coerce/from-long (* timestamp 1000))))

(defn transform-time [value]
	[(get-hour (value 0)) 
		(value 1)])

(defn average
  [numbers]
  (/ (apply + numbers) (count numbers)))

(defn get-likes [inpu]
	[(inpu 0)
	(vec (map second (inpu 1)))])

(defn grouped [params]
	(group-by first (map transform-time params)))

(defn genefucker [elem]
	[(elem 0) (average (map second (elem 1)))])

(defn analyze [params]
	(println (into (sorted-map) (vec (map genefucker (grouped params)))))
	(into (sorted-map) (vec (map genefucker (grouped params)))))

(defn get-hours-array [params]
	(let [hours (analyze params)]
		(map-indexed (fn [index, item] (if (hours (str index))
			(hours (str index))
			0
			) ) (vec (range 24)))))

; (defn evaluate-likes-count "should return array of results by hour" []

  ; )
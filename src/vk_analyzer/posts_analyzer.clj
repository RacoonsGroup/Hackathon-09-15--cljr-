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

(defn analyze [params]
	(println (grouped params))
	(grouped params))

; (defn evaluate-likes-count "should return array of results by hour" []

  ; )
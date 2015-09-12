(ns vk-analyzer.data.analyzer
	(:require [clj-time.coerce :as coerce]
			  [clj-time.format :as formatter]
			  [clj-time.core :as time]))

(def hour-formatter (formatter/formatter "HH"))

(defn get-hour [timestamp]
	;  Учитывать временную зону
	(formatter/unparse hour-formatter
		(time/from-time-zone
			(coerce/from-long (* timestamp 1000))
			(time/time-zone-for-offset -3))
		))

(defn transform-time [value]
	(println (get-hour (value 0)) )
	[(get-hour (value 0))
		(value 1)])

(defn average
  [numbers]
  (/ (apply + numbers) (count numbers)))

(defn group-by-hour [params]
	(group-by first (map transform-time params)))

(defn get-averaged-likes [elem]
	[(elem 0) (average (map second (elem 1)))])

(defn get-hours-likes [params]
	(into
		(sorted-map)
		(vec (map get-averaged-likes (group-by-hour params)))))

(defn get-hours-array [params]
	(let [hours (get-hours-likes params)] ; Получаем часы со средними лайками {"12" 245, "23" 542}
		(map-indexed  ; собираем новый массив с индексами
			(fn [index, item]
				(if (hours (str index)) ; Если в часах есть лайки
					(hours (str index)) ; добавляем их
					0)) ; иначе просто 0
			(vec (range 24)))))

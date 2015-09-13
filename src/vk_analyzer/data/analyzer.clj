(ns vk-analyzer.data.analyzer
	(:require [clj-time.coerce :as coerce]
			  [clj-time.format :as formatter]
			  [clj-time.core :as time]
			  [vk-analyzer.configs.global :as config]
			  [vk-analyzer.data.time-formatter :as time-formatter]))

(defn average
  [numbers]
  (/ (apply + numbers) (count numbers)))

(defn get-averaged-likes [elem]
	[(elem 0) (average (map second (elem 1)))])

(defn get-hours-likes [params]
	(into
		(sorted-map)
		(vec (map get-averaged-likes (time-formatter/group-by-hour params)))))

(defn get-hours-array [params]
	(let [hours (get-hours-likes params)] ; Получаем часы со средними лайками {"12" 245, "23" 542}
		(map-indexed  ; собираем новый массив с индексами
			(fn [index, item]
				(if (hours (str index)) ; Если в часах есть лайки
					(hours (str index)) ; добавляем их
					0)) ; иначе просто 0
			(vec (range 24)))))

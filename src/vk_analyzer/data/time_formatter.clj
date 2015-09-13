(ns vk-analyzer.data.time-formatter
  (:require [clj-time.coerce :as coerce]
        [clj-time.format :as formatter]
        [clj-time.core :as time]
        [vk-analyzer.configs.global :as config]))

(def hour-formatter (formatter/formatter "H"))

(defn get-hour [timestamp]
  ;  Учитывать временную зону
  (formatter/unparse hour-formatter
    (time/from-time-zone
      (coerce/from-long (* timestamp 1000))
      (time/time-zone-for-offset config/time-zone))
    ))

(defn transform-time [value]
  [(get-hour (value 0))
    (value 1)])

(defn group-by-hour [params]
  (group-by first (map transform-time params)))

(ns vk-analyzer.routes.home
  (:require [vk-analyzer.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]
            [vk-analyzer.data.charts :as charts]
            [vk-analyzer.data.vk-api :as vk-api]
            [clj-http.client :as client]))

(defn get-wall [domain keywords]
    (let [api-data (vk-api/get-wall {:domain domain :count 500})]
    (layout/render "analyze-likes.html" {:data (charts/analyze-data api-data) :scatter-data (charts/analyze-data-for-scatter api-data)})))

(defn search-on-wall [domain keywords]
    (let [api-data (vk-api/search-on-wall {:domain domain :count 500 :query keywords})]
    (layout/render "analyze-likes.html" {:data (charts/analyze-data api-data) :scatter-data (charts/analyze-data-for-scatter api-data)})))

(defn home-page []
  (layout/render "home.html"))

(defn about-page []
  (layout/render "about.html"))

(defn analyze-likes [{:keys [domain keywords]}]
  (if (= keywords "")
    (get-wall domain keywords)
    (search-on-wall domain keywords)))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (POST "/analyze-likes" {params :params} (analyze-likes params)))

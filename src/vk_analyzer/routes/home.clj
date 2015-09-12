(ns vk-analyzer.routes.home
  (:require [vk-analyzer.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]
            [vk-analyzer.charts :as charts]
            [vk-analyzer.vk-api :as vk-api]
            [clj-http.client :as client]))

(defn home-page []
  (layout/render "home.html"))

(defn about-page []
  (layout/render "about.html"))

(defn analyze-likes [{:keys [id domain keywords]}]
  	(layout/render "analyze-likes.html" {:data (charts/analyze-data (vk-api/get-wall {:domain domain :count 3}))}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (POST "/analyze-likes" {params :params} (analyze-likes params)))

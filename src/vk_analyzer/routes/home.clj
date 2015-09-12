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

(defn analyze-likes [{:keys [group-domain keywords]}]
  	(layout/render "analyze-likes.html" {:response (vk-api/get-group {:group_id group-domain :count 3})}))

(defn test-chart-page []
  (layout/render
    "test-chart-page.html" {:data (charts/get-data)}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (POST "/analyze-likes" {params :params} (analyze-likes params))
  (GET "/test-chart-page" [] (test-chart-page)))

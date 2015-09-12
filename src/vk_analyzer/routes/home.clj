(ns vk-analyzer.routes.home
  (:require [vk-analyzer.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]
            [vk-analyzer.charts :as charts]
            [vk-analyzer.vk-api :as vk-api]
            [clj-http.client :as client]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(defn about-post [{:keys [user-id keywords]}]
  	(layout/render "about-post.html" {:response ((vk-api/get-user user-id) :body)}))

(defn test-chart-page []
  (layout/render
    "test-chart-page.html" {:data (charts/get-data)}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (POST "/about" {params :params} (about-post params))
  (GET "/test-chart-page" [] (test-chart-page)))

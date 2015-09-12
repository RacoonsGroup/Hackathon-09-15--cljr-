(ns vk-analyzer.routes.home
  (:require [vk-analyzer.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]
            [vk-analyzer.charts :as charts]
            [clj-http.client :as client]
            [vk-analyzer.posts-analyzer :as analyzer]))

(defn home-page []
  (layout/render
    "home.html" {:array (vec (analyzer/add-hour [[1441923785 500] [1442068518 200] [1442068518 400]]))}))

(defn about-page []
  (layout/render "about.html"))

(defn about-post [{:keys [user-id keywords]}]
  	(layout/render "about-post.html" {:response ((client/get (str "https://api.vk.com/method/users.get?user_ids=" user-id "&v=5.37&access_token=fedfc0f5b921a6c72d368a7182b07bf69a464f68e881184d7a2c6e25f4d42275421deba86b116d5b24760")) :body)}))

(defn test-chart-page []
  (layout/render
    "test-chart-page.html" {:data (charts/get-data)}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (POST "/about" {params :params} (about-post params))
  (GET "/test-chart-page" [] (test-chart-page)))

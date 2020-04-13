(ns eamonnsullivan.github-search-cli
  (:require [clojure.string :as string]
            [clojure.tools.cli :refer [parse-opts]]
            [clojure.data.json :as json]
            [eamonnsullivan.github-search :as search])
  (:gen-class))

(def access-token (System/getenv "GITHUB_ACCESS_TOKEN"))

(defn usage [options-summary]
  (string/join \newline
               ["Get information about Github repositories in a given organisation,"
                "optionally tagged with the given topics."
                "You must have a valid GITHUB_ACCESS_TOKEN defined in your"
                "environment."
                ""
                "There are two required arguments: A login or organisation name"
                "and at least one topic. Multiple topics are separated by commas."
                ""
                "Usage: github-search-cli <org> --topics <topic>,<topic>"
                ""
                "Options:"
                options-summary]))

(def cli-options
  [["-h" "--help"]])

(defn -main
  "Get information about Github repositories that match the criteria."
  [& args]
  (let [{:keys [options arguments summary]} (parse-opts args cli-options)]
    (if (= 2 (count arguments))
      (let [org (first arguments)
            topics (map string/trim (string/split (second arguments) #","))]
        (cond
          (:help options) (println (usage summary))
          :else (search/get-repos access-token org topics)))
        (println (usage summary)))))

(ns aoc.1
  (:require [clojure.string :as str]))

(defn read-input [handle]
  (-> handle
      (slurp)
      (str/split #"\n")))

;; part 1

(->> "1.txt"
    (read-input)
    (map read-string)
    (apply +)) ;; -> 497

;; part 2

(defn find-duplicate [input]
  (loop [state #{}
         sum   0
         pos   0]
    (let [before-count (count state)
          new-sum      (+ sum (input pos))
          new-state    (conj state new-sum)
          after-count  (count new-state)]
      (if (= before-count after-count)
        new-sum
        (let [new-pos (if (= (inc pos) (count input))
                        0
                        (inc pos))]
          (recur new-state new-sum new-pos))))))

(find-duplicate (->> "1.txt"
                     (read-input)
                     (map read-string)
                     (vec))) ;; -> 558


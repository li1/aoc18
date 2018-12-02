(ns aoc.2
  (:require [clojure.string :as str]))

(defn read-input [handle]
  (-> handle
      (slurp)
      (str/split-lines)))

;; part 1

(defn n? [word n]
  (some #(= n %) (vals (frequencies word))))

(defn doubles? [word]
  (n? word 2))

(defn triples? [word]
  (n? word 3))

(let [input (->> "2.txt"
                 (read-input))]
  (* (count (filter doubles? input))
     (count (filter triples? input))))

;; part 2

(defn one-off? [[w1 w2]]
  (->> (map vector w1 w2)
       (filter (fn [[c1 c2]] (not= c1 c2)))
       (count)
       (= 1)))

(let [input (->> "2.txt"
                 (read-input))]
  (->> (for [w1 input w2 input] (vector w1 w2))
       (filter one-off?)))
;; => (["omlvgdokxfncvqyersasjwziup" "omlvgdokxfncvqyersasjlziup"] ["omlvgdokxfncvqyersasjlziup" "omlvgdokxfncvqyersasjwziup"])
;; => omlvgdokxfncvqyersasjziup

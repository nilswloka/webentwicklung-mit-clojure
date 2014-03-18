(ns bwertr.model.ratings)

(let [db (atom [])]
  (defn all []
    @db)
  (defn add! [rating]
    (swap! db conj rating))
  (defn average []
    (when-let [all-ratings (seq @db)]
      (int (Math/ceil (/ (reduce + all-ratings) (count all-ratings)))))))

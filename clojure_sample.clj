(defn make-sample-two-students-in-class []
  (let [{cid :_id} (d/get-class-by-name "2014-2015")]
    (db/activate-class cid)
    (let [s (d/make-student "jim2")
          {sid :_id} s
          result {:class_id cid :student_ids [sid]}]
      (d/add-student-to-class sid cid)
      (let [s (d/make-student "steve2")
            {sid :_id} s
            result (update-in result [:student_ids] (fn [sids] (conj sids sid)))]
        (d/add-student-to-class sid cid)
        result))))


(defun test(expect actual)
  (if (equal expect actual)
      (message "Passed")
    (message "Failed")))

(defun TwoSum1(nums target)
  (let ((i 0)
        (j 1)
        (len (length nums)))
    (catch 'break-outer
      (while (< i (- len 1))
        (catch 'break-inner
          (while (< j len)
            (message "Loop: %s:%s" i j)
            (when (= target (+ (aref nums i)
                               (aref nums j)))
              (message "Found: %s:%s" i j)
              (throw 'break-inner nil))
            (incf j 1)))
        (when (< j len)
          (throw 'break-outer nil))
        (incf i 1)
        (setq j (+ i 1))))
    (list i j)))

(test (TwoSum1 [1 3 6 1 0 8 8 10 8 7 5 9 10] 15) '(2 11))

(defun TwoSum2(nums target)
  (let ((i 0)
        (j 0)
        (index-map nil)
        (len (length nums)))
    ;; Compose association map
    (while (< i len)
      (setq index-map
            (append (list (cons (aref nums i) i)) index-map))
      (incf i 1))
    ;; Try to find from association map
    (setq i 0)
    (catch 'break
      (while (< i len)
        (let* ((x (aref nums i))
               (y (- target x)))
          (setq j (cdr (assoc y index-map)))
          (if (numberp j)
              (throw 'break nil)
            (incf i 1)))))
    (if (eq i len)
        nil
      (list i j))))

(test (TwoSum2 [1 3 6 1 0 8 8 10 8 7 5 9 10] 15) '(2 11))

;; Need to convert list to vector as list-ref has O(n) and will exceeded runtime limit in leetcode
(define (max-area-sc height)
  (let ([vec (list->vector height)]
        [len (length height)])
    (let loop ([i 0]
               [j (- len 1)]
               [max-area 0])
      (if (<= j i) max-area
          (let ([hi (vector-ref vec i)]
                [hj (vector-ref vec j)])
            (loop (if (<= hi hj) (+ i 1) i)
                  (if (<= hj hi) (- j 1) j)
                  (max max-area (* (min hi hj) (- j i)))))))))

(max-area-sc '(1 3 3 4 5))

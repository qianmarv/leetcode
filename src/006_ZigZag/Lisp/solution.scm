;; (define/contract (convert s numRows)
;;   (-> string? exact-integer? string?)
;;
;; Runtime: 1332 ms, faster than 100.00% of Racket online submissions for Zigzag Conversion.
;; Memory Usage: 125.6 MB, less than 100.00% of Racket online submissions for Zigzag Conversion.
;;
;;
(define (zigzag-conversion s numRows)
  (let* ([len (string-length s)]
         [v (make-vector numRows '())])
    (let loop ([char-index 0]
               [vector-index 0]
               [inc 1])
      (when (< char-index len)
        (vector-set! v vector-index (append (vector-ref v vector-index)
                                            (list (string-ref s char-index))))
        (let ([inc (cond
                    [(= numRows 1) 0]
                    [(= vector-index (- numRows 1)) -1]
                    [(= vector-index 0) 1]
                    [#t inc])])
          (loop (+ 1 char-index)
                (+ inc vector-index)
                inc)))
      (apply string-append
             (map (lambda (item) (list->string item))
                  (vector->list v))))))

(zigzag-conversion "abcdefg" 3)
(zigzag-conversion "AB" 1)

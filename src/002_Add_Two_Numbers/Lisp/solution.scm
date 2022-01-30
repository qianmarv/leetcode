(define (add-two-numbers l1 l2)
  (define (_add-two-numbers l1 l2 carrier result)
    (cond
     [(and (null? l1) (null? l2)) (if (= carrier 0) result
                                      (append result (list carrier)))]
     [(null? l1) (if (= carrier 0) (append result l2)
                     (_add-two-numbers (list carrier)
                                       l2
                                       0
                                       result))]
     [(null? l2) (if (= carrier 0) (append result l1)
                     (_add-two-numbers (list carrier)
                                       l1
                                       0
                                       result))]
     [#t (let ([sum (+ (car l1) (car l2) carrier)])
           (if (< sum 10)
               (_add-two-numbers (cdr l1)
                                 (cdr l2)
                                 0
                                 (append result (list sum)))
               (_add-two-numbers (cdr l1)
                                 (cdr l2)
                                 1
                                 (append result (list (- sum 10))))))]))
  (_add-two-numbers l1 l2 0 '()))

(add-two-numbers '(9 9 9 9 9) '(9 9 9 9))

(add-two-numbers '(9 9 9 9 9 9 9) '(9 9 9 9))

(add-two-numbers '(1 3 3) '(8 7 9))

(add-two-numbers '(1 3 3 3 3 3 3) '(1 1 1 2 2))

;;#lang racket
; Definition for singly-linked list:
;;#|

; val : integer?
; next : (or/c list-node? #f)
(struct list-node
  (val next) #:mutable #:transparent)

; constructor
(define (make-list-node [val 0])
  (list-node val #f))

;;|#
(define (add-two-numbers l1 l2)
  (let loop ([l1 l1]
             [l2 l2]
             [cr 0])
    (cond
      [(and (not l1) (not l2)) (if (= cr 0) #f (make-list-node cr))]
      [(not l1) (if (= cr 0)
                    (list-node (list-node-val l2) (loop #f (list-node-next l2) 0))
                    (loop (make-list-node cr) l2 0))]
      [(not l2) (if (= cr 0)
                    (list-node (list-node-val l1) (loop (list-node-next l1) #f 0))
                    (loop l1 (make-list-node cr) 0))]
      [#t (let ([sum (+ (list-node-val l1) (list-node-val l2) cr)])
            (if (< sum 10)
                (list-node sum (loop (list-node-next l1) (list-node-next l2) 0))
                (list-node (- sum 10) (loop (list-node-next l1) (list-node-next l2) 1))))])))

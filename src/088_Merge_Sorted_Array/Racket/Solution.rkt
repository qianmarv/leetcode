(require racket/contract)
(require racket/list)

(define/contract (merge nums1 m nums2 n)
  (-> (listof exact-integer?) exact-integer? (listof exact-integer?) exact-integer? void?)
  (define (back-fill nums i j k)
    (cond [(< j 0) nums]
          [(or (< i 0) (< (list-ref nums1 i)
                          (list-ref nums2 j)))
           (back-fill (list-set nums k (list-ref nums2 j)) i (- j 1) (- k 1))]
          [else (back-fill (list-set nums k (list-ref nums1 i)) (- i 1) j (- k 1))]))
  (set! nums1 (back-fill nums1 (- m 1) (- n 1) (- (+ m n) 1)))
  (setq nums1 '(3 3 3))
)

(define _nums1 '(1 2 0))

(let ((m 2)
      (nums2 '(3))
      (n 1))
  (merge _nums1 m nums2 n)
  _nums1)


(list-update _nums1 2 5 )

(list-ref _nums1 2)
(set! (list-ref _nums1 2) 88)

(set! _nums1 '(1 2) )

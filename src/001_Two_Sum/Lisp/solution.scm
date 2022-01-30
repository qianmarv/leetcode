(define (two-sum-1 nums target)
  (define find-index
    (lambda (num lst)
      (if (null? lst) -1
          (if (eq? (car lst) num) 0
              (if (= (find-index num (cdr lst)) -1) -1
                  (+ 1 (find-index num (cdr lst))))))))
  (define (find-xy start-index _nums)
    (let ([y-pos (find-index (- target (car _nums)) (cdr _nums))])
      (if (= -1 y-pos) (find-xy (+ 1 start-index) (cdr _nums))
          (list start-index (+ 1 (+ start-index y-pos))))))
  (find-xy 0 nums))


(define (two-sum-2 nums target)
  ;; (-> (listof exact-integer?) exact-integer? (listof exact-integer?))
  (define (index-of _nums num)
    (define (find-num _nums num)
      (if (or (null? _nums) (= num (car _nums))) 0
          (+ 1 (find-num (cdr _nums) num))))
    (let ([index (find-num _nums num)])
      (if (= (length _nums) index) -1
          index)))
  (define (find-xy _nums x-index)
    (let ([y-pos (index-of (cdr _nums) (- target (car _nums)))])
      (if (= -1 y-pos) (find-xy (cdr _nums) (+ 1 x-index))
          (list x-index (+ 1 (+ x-index y-pos))))))
  (find-xy nums 0))

;; Test cases
(two-sum '[1 2] 3)

(two-sum '[2 3 4] 6)

(two-sum '[1 2 6 10] 12)

(two-sum '[1 2 6 10 88 77 1 8 7] 87)

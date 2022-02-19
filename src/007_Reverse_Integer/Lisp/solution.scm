;; For Racket Run in Leetcode, change ~mod~ to ~modulo~
;; Runtime: 208 ms, faster than 100.00% of Racket online submissions for Reverse Integer.
;; Memory Usage: 98.4 MB, less than 100.00% of Racket online submissions for Reverse Integer.
(define reverse-positive
  (lambda (x)
    (let ([coeff (if (> x 0) 1 -1)]
          [bundary-up (- (expt 2 31) 1)]
          [bundary-bottom (* -1 (expt 2 31))])
      (let loop ([source x]
                 [target 0])
        (cond
         [(or (> target bundary-up) (< target bundary-bottom)) 0]
         [(= source 0) target ]
         [#t (loop (* coeff (floor (/ (* coeff source) 10)))
                   (+ (* 10 target) (* coeff (mod (* coeff source) 10))))])))))

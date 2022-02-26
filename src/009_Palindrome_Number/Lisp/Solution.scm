(define (is-palindrome-sc num)
  (if (< num 0) #f
      (let loop ([l '()]
                 [n num])
        (if (>= n 10) (loop (append l (list (modulo n 10))) (floor (/ n 10)))
            (is-palindrome-vector (list->vector (append l (list n))))))))

(define (is-palindrome-vector vec)
  (let loop ([i 0]
             [j (- (vector-length vec) 1)])
    (if (> i j) #t
        (and (= (vector-ref vec i) (vector-ref vec j))
             (loop (+ i 1) (- j 1))))))


(is-palindrome-vector (vector 1 0 0 1 0))
(is-palindrome-sc 1001)

(define (is-palindrome-sc2 num)
  (cond
   [(< num 0) #f]
   [(< num 10) #t]
   [#t (= num (reverse-num num))]))

(define (reverse-num num)
  (let loop ([origin num]
             [reversed 0])
    (if (= origin 0) reversed
        (loop (quotient origin 10)
              (+ (remainder origin 10) (* 10 reversed))))))

(reverse-num 199)

(is-palindrome-sc2 1001)

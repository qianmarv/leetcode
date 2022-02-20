(define (my-atoi-outer str)
  (let* ([const-2^31 (expt 2 31)]
         [int-max (- const-2^31 1)]
         [int-min (* -1 const-2^31)]
         [str-len (string-length str)])
    (define (my-atoi-inner pos is-positive?)
      (let innerloop ([pos pos]
                      [num 0])
        (cond
         [(and is-positive? (>= num int-max)) int-max]
         [(and (not is-positive?) (>= num const-2^31)) int-min]
         [(or (= pos str-len)
              (char<? (string-ref str pos) #\0)
              (char>? (string-ref str pos) #\9)) (if is-positive? num (* -1 num))]
         [#t (innerloop (+ 1 pos)
                        (+ (* 10 num) (- (char->integer (string-ref str pos)) 48)))])))
    (let outerloop ([pos 0])
      (if (= pos str-len) 0
          (let ([char (string-ref str pos)])
            (cond
             [(char=? char #\space) (outerloop (+ 1 pos))]
             [(char=? char #\+) (my-atoi-inner (+ 1 pos) #t)]
             [(char=? char #\-) (my-atoi-inner (+ 1 pos) #f)]
             [(or (char<? char #\0)
                  (char>? char #\9)) 0]
             [#t (my-atoi-inner pos #t)]))))))

(my-atoi-outer "-42f1")

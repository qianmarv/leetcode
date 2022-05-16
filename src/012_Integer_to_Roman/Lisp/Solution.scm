(define (calc-roman slist prev)
  (if (equal? slist '()) 0
      (let [(curr (get-int-from-char (car slist)))]
        (if (>= curr prev) (+ (calc-roman (cdr slist) curr) curr)
            (- (calc-roman (cdr slist) curr) curr )))))

  (define (get-int-from-char c)
    (cond
     [(equal? c #\I) 1]
     [(equal? c #\V) 5]
     [(equal? c #\X) 10]
     [(equal? c #\L) 50]
     [(equal? c #\C) 100]
     [(equal? c #\D) 500]
     [(equal? c #\M) 1000]))

(let [(slist (reverse (string->list "LVIII")))]
  (calc-roman slist 0))

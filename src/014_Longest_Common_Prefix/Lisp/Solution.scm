(define (longest-common-prefix strs)
  (get-lcp strs 0 (length strs)))

(define (get-lcp strs beg end)
  (let ([strlen (- end beg)]
        [mid (+ beg (floor (/ (- end beg) 2)))])
    (cond
     [(= strlen 1) (list-ref strs beg)]
     [(= strlen 2) (find-lcp-in-two (list-ref strs beg)
                                    (list-ref strs (+ 1 beg))
                                    0)]
     [#t (find-lcp-in-two (get-lcp strs beg mid)
                          (get-lcp strs mid end)
                          0)])))

(define (find-lcp-in-two str1 str2 idx)
  (let ([len (min (string-length str1)
                  (string-length str2))])
    (if (and (< idx len)
             (equal? (string-ref str1 idx)
                     (string-ref str2 idx)))
        (find-lcp-in-two str1 str2 (+ 1 idx ))
        (substring str1 0 idx))))

(longest-common-prefix '("flower" "flow" "flight"))

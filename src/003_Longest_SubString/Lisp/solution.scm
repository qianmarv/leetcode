;; Under Chez Scheme Version 9
(define (length-of-longest-substring s)
  (let ([len (string-length s)])
    (define (find-longest-substr head tail ret)
      (define (find-offset-in-sub curr char)
        (if (= curr head) 0
            (if (char=? char (string-ref s curr)) (+ 1 (- curr tail))
                (find-offset-in-sub (+ curr 1) char))))
      (if (= head len) (max ret (- head tail))
          (let* ([next-char (string-ref s head)]
                 [pos (find-offset-in-sub tail next-char)])
            (if (= pos 0) (find-longest-substr (+ head 1) tail ret)
                (find-longest-substr (+ head 1) (+ tail pos) (max ret (- head tail)))))))
    (if (< len 2) len
        (find-longest-substr 1 0 1))))

(length-of-longest-substring "")
(length-of-longest-substring "a")
(length-of-longest-substring "abb")
(length-of-longest-substring "abbe")
(length-of-longest-substring "pwwkew")
(length-of-longest-substring "abcabcbb")

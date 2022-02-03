(define(longest-palindrome s)
  (let ([len (string-length s)])
    (define (find-palindrome center result)
      (if (= center len) result
          (let* ([char (string-ref s center)]
                 [str (let find-palindrome ([left center] [right center])
                        (let ([left (let repeat-left ([left left])
                                      (if (or (< left 0) (not (char=? char (string-ref s left)))) left
                                          (repeat-left (- left 1))))]
                              [right (let repeat-right ([right right])
                                       (if (or (>= right len) (not (char=? char (string-ref s right)))) right
                                           (repeat-right (+ right 1))))])
                          (let loop ([left left]
                                     [right right])
                            (if (or (< left 0)
                                    (>= right len)
                                    (not (char=? (string-ref s left) (string-ref s right))))
                                (substring s (+ left 1) right)
                                (loop (- left 1) (+ right 1))))))]
                 [result (if (> (string-length str) (string-length result)) str result)])
            (find-palindrome (+ center 1) result))))
    (find-palindrome 0 "")))

(longest-palindrome "")
(longest-palindrome "a")
(longest-palindrome "aa")
(longest-palindrome "aab")
(longest-palindrome "aaabaacc")


(string-ref "abcd" 0)

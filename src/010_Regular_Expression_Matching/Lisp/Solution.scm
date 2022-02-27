(define (match-string s p)
  (let ([mem-ht (make-eq-hashtable)]
        [slist (reverse (string->list s))]
        [plist (reverse (string->list p))])
    (define ht-setter
      (lambda (index v)
        (eq-hashtable-set! mem-ht index v)
        ;;(pretty-print (format "index: ~s, value: ~s" index v))
        v))
    (define (match-list-rec sl pl)
      (let* ([len-sl (length sl)]
             [len-pl (length pl)]
             [index (+ len-pl (* len-sl (+ 1 (length plist))))])
        (if (eq-hashtable-contains? mem-ht index) (eq-hashtable-ref mem-ht index #f)
            (cond
             [(and (equal? pl '()) (equal? sl '())) #t]
             [(equal? pl '()) #f]
             [(equal? sl '()) (if (and (equal? (car pl) #\*) (= 0 (remainder len-pl 2)))
                                   (ht-setter index (match-list-rec sl (cdr (cdr pl))))
                                   #f)]
             [#t (or (and (equal? (car sl) (car pl))
                          (ht-setter index (match-list-rec (cdr sl) (cdr pl))))
                     (and (equal? (car pl) #\.)
                          (ht-setter index (match-list-rec (cdr sl) (cdr pl))))
                     (and (equal? (car pl) #\*)
                          (or (ht-setter index (match-list-rec sl (cdr (cdr pl))))
                              (ht-setter index (and (or (equal? #\. (car (cdr pl))) (equal? (car sl) (car (cdr pl))))
                                                    (match-list-rec sl (cdr pl))))
                              (ht-setter index (and (or (equal? #\. (car (cdr pl))) (equal? (car sl) (car (cdr pl))))
                                                    (match-list-rec (cdr sl) pl))))))]))))
    (match-list-rec slist plist)))

(match-string "acd" "ac.*")

;; To convert to racket version in order to be executed in leetcode
;; Replace below:
;; - make-eq-hashtable     => make-hash
;; - eq-hashtable-set!     => hash-set!
;; - eq-hashtable-ref      => hash-ref
;; - eq-hashtable-contains => hash-has-key?

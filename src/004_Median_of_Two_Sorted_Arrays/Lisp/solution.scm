(define (find-median-sorted-arrays nums1 nums2)
  (let* ([len (+ (length nums1) (length nums2))]
         [is-odd? (= (modulo len 2) 1)]
         [target (if is-odd? (/ (+ 1 len) 2)
                     (/ len 2))])
    (define (find-median _nums1 _nums2 count result)
      (cond
       [(null? _nums1) (find-median-one-array _nums2 count result)]
       [(null? _nums2) (find-median-one-array _nums1 count result)]
       [(and (= count target) is-odd?) (+ result 0.0)]
       [(<= (car _nums1) (car _nums2)) (if (= count target) (/ (+ result (car _nums1) 0.0) 2)
                                           (find-median (cdr _nums1) _nums2 (+ 1 count) (car _nums1)))]
       [(> (car _nums1) (car _nums2)) (if (= count target) (/ (+ result (car _nums2) 0.0) 2)
                                          (find-median (cdr _nums2) _nums1 (+ 1 count) (car _nums2)))]))
    (define (find-median-one-array nums count result)
      (cond
       [(= count target) (if is-odd? (+ result 0.0)
                             (/ (+ (car nums) result 0.0) 2))]
       [#t (find-median-one-array (cdr nums) (+ 1 count) (car nums))]))
    (find-median nums1 nums2 0 0)))

(find-median-sorted-arrays '(1 3) '(2 4 5 6))

(find-median-sorted-arrays '(1) '(2 3))

(find-median-sorted-arrays '(0 0) '(0))

(real->decimal-string 5)

(modulo 3 2)
    (define target 1)
    (define (find-median-odd _nums1 _nums2 is-first? count target)
      (cond
       [(and is-first? (null? _nums1)) (find-median-odd _nums1 _nums2 (not is-first?) count target)]
       [(and is-first? (= count target) (car _nums1))]
       [is-first? (find-median-odd (cdr _nums1) _nums2 ())]
       ))

    (member 'a '(a b c))

    ;; 从小到大开始遍历两个数组，到达中位数附近时停止并计算中位数
    ;; 如果数组一为空，则继续找数组二，如果数组二为空，则继续找数组一
    ;; 如果两者都不为空，比较当前指向的数组一和数组二的数字，先取小的那个
    ;; 如果总长度为奇数，则中位数 = (len+1)/2 个数
    ;; 如果总长度为偶数，则中位数 = (len/2,len/2+1)/2
    ;; 要达到O(log(m+n))，遍历需要改为二分搜索

;; 二分查找
(define (my-find nums target)
  (define binary-find
    (lambda (lo hi)
      (let ([mid (+ lo (floor (/ (- hi lo) 2)))])
        (cond
         [(> lo hi) -1]
         [(= target ())]))))
  (binary-find 0 (length nums)))

(floor (/ 7 2))
()
(define a '(1 2 3 4 5 6 7 8 9 10))
(list-ref a 5)
(vector-ref (list->vector a) 0)

(length a)
;; low = 0, high = 9 => mid = 5
;; if(a[5] == target) find
;; else if(a[5] < target) low = mid, recalculate mid

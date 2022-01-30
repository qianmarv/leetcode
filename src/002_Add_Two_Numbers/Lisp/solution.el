;;; solution.el --- description -*- lexical-binding: t; -*-
;;
;; Copyright (C) 2020 Marvin Qian
;;
;; Author: Marvin Qian <http://github/qianmarv>
;; Maintainer: Marvin Qian <qianmarv@gmail.com>
;; Created: April 29, 2020
;; Modified: April 29, 2020
;; Version: 0.0.1
;; Keywords:
;; Homepage: https://github.com/qianmarv/solution
;; Package-Requires: ((emacs 26.3) (cl-lib "0.5"))
;;
;; This file is not part of GNU Emacs.
;;
;;; Commentary:
;;
;;  description
;;
;;  Problem
;; Add Two Numbers
;; Link: https://leetcode.com/problems/add-two-numbers/description/

;; You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

;; You may assume the two numbers do not contain any leading zero, except the number 0 itself.

;; Example

;; Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
;; Output: 7 -> 0 -> 8
;; Explanation: 342 + 465 = 807.


;;
;;; Code:



(defun addTwoNumbers(l1 l2)
  "Addtwonumbers L1 L2."
  (defun _addTwoNumbers(l1 l2 c)
    (cond ((and (null l1)
                (null l2)) (if (> c 0)
                (cons c nil)
                nil))
          ((null l1) (cons (car l2)
                           (_addTwoNumbers l1 (cdr l2) c)))
          ((null l2) (cons (car l1)
                           (_addTwoNumbers (cdr l1) l2 c)))
          (t (let ((sum (+ (car l1) (car l2) c)))
               (if (< sum 10)
                   (cons sum
                         (_addTwoNumbers (cdr l1) (cdr l2) 0))
                 (cons (- sum 10)
                       (_addTwoNumbers (cdr l1) (cdr l2) 1)))))))
  (_addTwoNumbers l1 l2 0))

(addTwoNumbers '(2 4 3) '(5 6 4))

(provide 'solution)
;;; solution.el ends here

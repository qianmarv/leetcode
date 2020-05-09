;;; solution.el --- description -*- lexical-binding: t; -*-
;;
;; Copyright (C) 2020 Marvin Qian
;;
;; Author: Marvin Qian <http://github/qianmarv>
;; Maintainer: Marvin Qian <qianmarv@gmail.com>
;; Created: May 09, 2020
;; Modified: May 09, 2020
;; Version: 0.0.1
;; Keywords:
;; Homepage: https://github.com/qianmarv/leetcode
;; Package-Requires: ((emacs 26.3) (cl-lib "0.5"))
;;
;; This file is not part of GNU Emacs.
;;
;;; Commentary:
;;
;;  description
;;
;;
;;/* Problem
;;    Longest Substring Without Repeating Characters
;;    link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

;;    Given a string, find the length of the longest substring without repeating characters.

;;    Examples:

;;    Given "abcabcbb", the answer is "abc", which the length is 3.

;;    Given "bbbbb", the answer is "b", with the length of 1.

;;    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
;; */
;;; Code:


(defun stringFind (str char)
"Find index of CHAR from input STR."
  (let ((i 0)
        (len (length str)))
    (catch 'found
     (while (< i len)
      (if (string= char (substring str i (+ 1 i)))
          (throw 'found i)
        (incf i))))))


(defun LongestSubString1(str)
"Find Longest Substring Without Repeating Characters From input STR."
(let ((maxStr "")
      (j 0)
      (windowStr "")
      (len (length str)))
  (while (< j len)
    (let* ((currChar (substring str j (+ 1 j)))
           (idx (stringFind windowStr currChar)))
      (when (numberp idx) ;; Find duplicate
        (message "Find duplicate at: %d" idx)
        (when (> (length windowStr) (length maxStr))
          (setq maxStr windowStr))
        (setq windowStr (substring windowStr (+ 1 idx))))
      (setq windowStr (concat windowStr currChar))
      (message "windowStr: %s" windowStr)
      (incf j 1)))
  maxStr))

(equal (LongestSubString1 "abcabcbb") "abc")

(provide 'solution)
;;; solution.el ends here

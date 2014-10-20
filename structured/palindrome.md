# Palindrome

Let us consider the latin alphabet made of 26 characters (letters from 'a' to 'z'). 
We call word an ordered sequence of characters of arbitrary length. 
Given a word w, we call extracted word v from w a word obtained by deleting some characters in w. 
For example, "abcd" is an extracted word from "sbanrpsobtspcerudoo". 
A palindrome is a word that is symmetric: it can be read indifferently from left to right or right to left. For example, "abccdccba" is a palindrome.

## Task
Our goal is to find the length of one of the longest extracted palindrome from a given word w. Of course if w is a palindrome then the answer should be the length of w, and the answer is always greater or equal than 1.

## Input
The input given your program is a one line string containing only lowercase latin alphabet letters (no space), followed by a newline character. The length of this input string will never exceed 2000 characters.

## Output
The output your program should write is the length of one of the longest extracted palindrome from the input, followed by a newline character .

Sample Input 1
lukeiamyourfather

Sample Output 1
5

Sample Input 2
anynontrivialpropertyofrecursivelyenumerablelanguagesisundecidable

Sample Output 2
21
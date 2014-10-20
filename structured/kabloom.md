# Kabloom

The card game Kabloom is played with multiple decks of playing cards. Players are dealt 2 n cards, face up and arranged in two rows of n cards. The players must discard some of the cards, so that the cards that remain in the first row match the rank of the cards that remain in the second row. The cards match only in rank (e.g. an Ace of Hearts matches any other Ace regardless of suit), but they must appear in the same order in each row. The players are not able to rearrange the order in which the cards appear. Note also that a Joker can match any card including another Joker . 
The goal is to maximize the sum of the point value of the cards that remain. Aces are worth 20 points, face cards are worth 15 points, and the numbered cards are worth the number on the card (e.g. the Seven of Clubs is worth 7 points).The value of a Joker is equal to the card with which it is matched, e.g. a Joker matched with an Ace is worth 20 points, a Joker matched with a face card is worth 15 points, etc. If two Jokers are matched with each other, they are worth 50 points each.

Task
Write a program that determines the value of the best hand given the two rows of cards. For example, consider the hand that is dealt below.

IMAGE 1

The best possible hand has a value of 140, and is obtained by keeping the cards shown below:

IMAGE 2

Input
The input is made up of multiple test cases (#test cases<=30, if 1<=n<=10 or #test cases<=10 if 10<=n<=1000). Each test case contains three lines of input. 
The first line in each test case is an integer n , 1 <= n <= 1,000, indicating how many cards are in each row. 
The second line of the test case will contain n symbols representing the ranks of the cards in the first row. Each symbol will be chosen from the list {A, 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, R}. The symbols in the list represent the following ranks, respectively, {Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Joker}. Similarly, the third line of the test case will contain the n symbols of the cards in the second row. 
The input will end with a 0 on a line by itself.

Output
For each test case, output the value of the best Kabloom hand on a line by itself. Note that the cards that comprise the best Kabloom hand may not be unique for a test case. 
Note: Every line of output should end in a newline character .

Sample Input 1
9 
6 3 7 4 2 A K R T 
3 5 4 7 R A Q K T 
0

Sample Output 1
140

Sample Input 2
7 
R R 5 4 A T Q 
Q 3 T A 8 8 8 
13 
A 2 3 4 5 6 7 8 9 T J Q K 
K Q J T 9 8 7 6 5 4 3 2 A 
6 
A A A A A A 
K Q J T 9 8 
13 
A 2 3 4 5 6 7 8 9 T J Q K 
A 2 3 4 5 6 7 8 9 T J Q K 
0

Sample Output 2
90 
40 
0 
238
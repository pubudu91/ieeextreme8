# Grand Integer Lottery

The Integer lottery company is conducting a very special lottery event for the lottery enthusiasts. The scheme for this special lottery is little different from normal lotteries. In particular, there is a sequence of integers called “ lottery sequence ” ranging between S and E which will be generated according to the following rule:

At first the lottery company decides on a number N representing the total amount of positive integers that a player chooses [i.e. n1, n2, …. nN]. Then the player choose these N positive integers.
Based on the above user-picked integers, the lottery company generates the lottery sequence as follows: For any given integer M in the range [S, E] (inclusive of S and E), M will be in the lottery sequence if at least one user-picked integer when considered as string occurs as a contiguous block in M. In the lottery sequence those picked integer Ms are in the sorted order.
For an example: S=1, E=35, N=2, n1=3 and n2=11, then the generated lottery sequence would be as follows: 
[3, 11, 13, 23, 30, 31, 32, 33, 34, 35] Comprised of all the integers in the range [1, 35] that contain the strings 3 or 11 or both.

After the lottery sequence has been generated, the lottery picks the winning number using the given winning index of the sequence. First integer of the sequence has index 1. For the example above, if the lottery company picked the 5th index as the winning index , then winning number would be 30 (i.e. the 5th integer of the lottery sequence).

## Task
The task in this problem is to find and print the winning number of the lottery for the given set of inputs.

## Input
The format of the input is as follows: 
S E P N 
n1 
n2 
... 
nN

The first line of the input consists of 4 space separated positive integers which represent: 
S The minimum value from which the lottery sequence will be generated 
E The maximum value from which the lottery sequence will be generated (1 <= S <= E <= 10^6) 
P The winning index (1 <= P <= 10^6) 
N The amount of positive integers that a player picks (1 <= N <= 18)

Then, N lines follow, each one ending with a newline character, representing the N positive integers that were selected by the player. Each of the user-picked integers will consist up to 18 digits (i.e. 1 <= The number of digits in any user-picked integer <=18). Also, for each number it holds true that it begins with a nonzero digit.

## Output
Your program should print the winning number to the standard output. If no such number exists, then the output should be: 
DOES NOT EXIST 
Otherwise, the program should print the winning number e.g.: 
163 
Note: There is a newline character at the end of the last line of the output.

Sample Input 1
1 10000 4 2 
62 
63

Sample Output 1
163

Explanation of Sample 1
In this example the user selects 2 positive integers n1=62 and n2=63. Based on this selection, the lottery sequence would look like [62, 63, 162, 163, 262, 263, ...]. Since the lottery has picked the winning index P=4, the program should output 163 as the winning number .

Sample Input 2
1 10000 999999 2 
62 
63

Sample Output 2
DOES NOT EXIST
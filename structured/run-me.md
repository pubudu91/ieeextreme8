# Run me

This problem seems quite easy: it seems that we are giving you the answer… All you have to do is supply the output of our program on the given input.

## Input
A string of characters, ending with a dot ('.').

Output
Your program should print the output of an MS-DOS 8086 assembly program p.com on the given input. 
Our program (in hex dump) is:

BF 00 04 BE C0 00 56 31 C9 B4 00 CD 16 3C 2E AA 
E0 F7 F7 D1 29 D2 89 CD 5B 53 FE 07 75 03 43 EB 
F9 BF 00 02 89 F9 89 F8 F3 AA 89 FE AC 89 C3 FE 
07 80 FB 2E 75 F6 FE 0F 5E 56 89 E9 AC 89 C3 FE 
0F 7C D5 E2 F7 42 5E 56 89 E9 F3 A6 75 CA 5D 92 
D4 0A E8 00 00 86 C4 04 30 CD 29 C3

Note: There is a newline character at the end of the last line of the output.

Sample Input 1
5.

Sample Output 1
01

Sample Input 2
34.

Sample Output 2
02
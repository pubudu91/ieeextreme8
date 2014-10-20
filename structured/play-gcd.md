# Play with GCD
Task
Minka is very smart kid who recently started learning computer programming. 
He learned how to calculate the Greatest Common Divisor (GCD) of given numbers. The GCD http://en.wikipedia.org/wiki/Greatest_common_divisor of k numbers say [n1,n2,n3… nk] is the largest positive integer that divides all these numbers without any remainder. You may find out more about the GCD and the way it is calculated on the Wikipedia website. 
Minka has N (1 <= N <= 10^5) balls and there is a number V (1 <= V <= 10^4) written on every ball. Now Minka has to perform Q queries, and in each query he wants to know the number of possible ways he can choose balls out of the N balls, so that GCD of the numbers written on the chosen balls equals to the number X of each query. Although he already knows the answer for each query, he would still like you to check if you can also find answer to his queries. 
Since number of ways can be very large, your program should output the number of ways modulus 10^9+7. 
Notes: 
1) There can be at most 100 distinct numbers written on N balls. 
2) By definition, the GCD is only defined for 2 or more numbers. For this problem, however, we will consider that the GCD of a single number may also defined and in such case the GCD of a single number will be equal to the number itself (i.e. the GCD of 2 is 2. Please refer to the explanation of Sample Input 1 for more details).

Input
The first line of each test file contains an integer N (1 <= N <= 10^5) denoting the number of balls. 
The next line contains N space separated integer numbers, each one representing the number written on each of the N balls. The ith number (Vi) corresponds to the number written on the ith ball (1 <= Vi <= 10^4). 
The third line contains an integer Q (1 <= Q <= 10^4) representing the number of GCD queries that will have to be performed. 
Finally, Q lines follow, each one containing an integer X (1 <= X <= 10^4) corresponding to the GCD of each query.

Output
Your program should output the number of ways modulus 10^9+7 that balls can be drawn from the set, so that their GCD equals the number X corresponding to each query. 
Note: There is a newline character at the end of the last line of the output.

Sample Input 1
5 
2 3 5 6 6 
2 
2 
5

Sample Output 1
4 
1

Explanation of Sample Input 1
We have 5 balls in the set, labeled with numbers [2, 3, 5, 6, 6] respectively. For the first query (X=2), there are in total 4 (distinct) ways by which we may choose balls so that their GCD equals 2, meaning: 
a) {1, 4} (i.e. ball 1 labeled with number 2 and ball 4 labeled with number 6) 
b) {1, 5} (i.e. ball 1 labeled with number 2 and ball 5 labeled with number 6) 
c) {1, 4, 5} (i.e. ball 1 labeled with number 2, ball 4 labeled with number 6 and ball 5 labeled with number 6) 
d) {1} (i.e. ball 1 labeled with number 2 since according to our definition of GCD, the GCD of 2 would equal 2)

Regarding the second query (X=5), there is only one way to choose balls so that their GCD equals 5, which is to choose only ball 3 (labeled with number 5).
# Road Trip

Vangelis the bear is planning a long road trip during which he wants to visit all the landmarks along a path of length L. The tank of his car can take up to F units of fuel and for every unit of distance covered his car consumes a unit of fuel. 
Vangelis knows how far each of the N gas stations are from the beginning of the path and the price per fuel unit each station offers. 
At the starting point he has T units of fuel in his car.

Task
Write a program that will accept the above information and will calculate the minimum amount of money Vangelis needs to spend. If the journey is impossible to make, it should print -1.

Input
The first line will contain an integer M (1 <= M <= 10) denoting number of Test cases. 
The next line will contain four space separated integers: 
N (0 < N < 50001): The total number of gas stations 
F (0 < F < 1000001): The units of fuel Vangelis's car can take 
T (0 <= T <= F): The units of fuel Vangelis's car has at the beginning of the trip 
L (0 < L < 1000000001): The path length of the landmarks he plans to visit 
Each of the following N lines will contain two integers: the first one, D_i (0 <= D_i <= L) corresponds to the distance of the station from the starting point, and the second one, C_i (1 <= C_i <= 1,000,000) represents the cost per fuel unit for that station.

Note: You may assume that the trip will be on a straight line where all gas stations are spread on this line at the positions specified by their D_i values.

Output
There should be M lines with the minimum amount of money to be spent per test case or with -1 in case the trip is not feasible. 
Note: There is a newline character at the end of the last line of the output.

Sample Input 1
1 
4 20 6 34 
4 40 
18 15 
10 7 
20 12

Sample Output 1
348

Explanation of Sample Input 1
This sample contains only 1 test case (M=1.) The second line of the input is 4 20 6 34 which means that: 
a. There are in total N=4 gas stations on the route 
b. The (max) fuel capacity of Vangelis car is F=20 liters 
c. The tank currently has T=6 liters of gas 
d. Vangelis wants to travel L=34 kms in total

Then the details for the 4 gas stations are provided in the form Di Ci, where Di is the distance of this gas station from the starting point and Ci is the cost per liter of gas: 
4 40 
18 15 
10 7 
20 12

For simplicity assume that the whole trip is done in a straight line as depicted below:

IMAGE 1

Obviously Vangelis does not have enough fuel for all 34 kms, so he needs to refuel. The cheapest gas station is the one labeled (B) above, however Vangelis does not (initially) have enough fuel in his tank to reach (B), since B-S = 10 and he has T=6. So he needs to add an extra 4 liters from gas station A, so that he can the make it until gas station B to get as much (cheap) as he can in order to make his 34 km journey. Thus he pays (i) 4lt * 40€/lt = 160€ and now he can make it until (B). Since until this moment he has only traveled 10 kms, he needs gas for another 34-10=24kms. Normally he would want to refuel his car with 24 liters (since B is the cheapest gas station) but since his (max) fuel capacity is F=20 liters he will only take 20 liters and thus pay (ii) 20 lt * 7 €/lt = 140€. He knows however that up to point (B) he has only traveled 10kms and he needs to travel another 24kms to reach his goal, whereas he has gas for 20kms. So he would have to stop at a later gas station (after he has traveled at least 4kms) to refuel another 4 liters of gas so that he could complete the whole 34 kms journey. Since he now has quite some gas, he may decide whether he wants to refuel at (C) or at (D) and since (D) is cheaper, it is more than 4kms away from (B) and is within reach (based on his gas in the tank) he will choose to refuel another 4 liters at (D) and thus pay (iii) 4lt*12€/lt=48€). After that he can successfully reach the end point of his trip.

See also the revised illustration below: (1st line is the current fuel capacity, 2nd line represents how much gas he refueled, 3rd line is fuel capacity after refilling, 4th line the money spent for the refilling, 5th line the total amount of money spent so far and 5th line the total distance covered so far):

IMAGE 2

In total he has spent: (i) 160€ + (ii) 140€ + (iii) 48€ = 348€ as reported by the test case output.
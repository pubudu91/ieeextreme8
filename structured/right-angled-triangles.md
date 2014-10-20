# Right-Angled Triangle

Vangelis the bear wants to place a set of right-angled triangles on a Cartesian coordinate system in such way that the legs (catheti) a and b of the triangles are not parallel to the X and Y axes and all the triangle vertices are coordinate pairs of integers.

## Task
Write a program that will accept the lengths of the triangle legs and will print "TRUE" if the triangle can be placed following the above conditions and print "FALSE" if it fails the above conditions.

## Input
The first line will contain an integer N (0 < N < 11), the number of triangles to study. 
Each of the following N lines will contain two space separated integers a,b (0 < a,b < 1001), corresponding to the lengths of the triangle legs.

## Output
There should be N lines, on each line there should be the word "TRUE" or the word "FALSE" (without the quotes). 
Note: There is a newline character at the end of the last line of the output.

Sample Input 1
3 
1 1 
5 5 
5 10

Sample Output 1
FALSE 
TRUE 
TRUE

Explanation of Sample Input 1
Triangle 2: Can be placed on the following coordinates: 
(2,1),(5,5),(-2,4). 
Triangle 3: Can be placed on the following coordinates: 
(-10,4),(-2,-2),(1,2).
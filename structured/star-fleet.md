# Star Fleet Express

A research team at the Star Fleet Academy is close to perfecting the first warp drive. They are planning to create a commercial space flight company, Xtreme Space Lines (XSL).

Task
The research team would like you to write a trip planner program that finds the fastest trip on XSL, if one exists, given a passengers desired start and end location and their earliest departure time. If the shortest trip involves one or more transfers, each stopover must be at least 1 hour long.

## Input
The first line in the test case contains three integers: the number of space ports, p , 1 <= p <= 1,000; the number of planned flights, f, 1 <= f <= 500,000; and the number of passenger queries, q , 1 <= q <= 100. 
On the next p lines are names of space ports, one per line, which are comprised only of alphanumeric characters and the underscore. 
Next are f lines, each describing a flight, in the form:

[Start] [Start_Date] [Start_Time] [End] [End_Date] [End_Time]

Where

[Start] is the departure location for a flight 
[Start_Date] represents date in UTC when the flight leaves 
[Start_Time] represents time in UTC when the flight leaves 
[End] is the arrival location for a flight , which must be different than> + [Start] 
[End_Date] represents date in UTC when the flight arrives 
[End_Time] represents time in UTC when the flight arrives

Next are q lines, each describing a query, in the form:

[Start] [Start_Date] [Start_Time] [End] 
Where 
[Start] is the desired departure location for a passenger 
[Start_Date] represents earliest start date in UTC for a passenger 
[Start_Time] represents earliest start time in UTC for a passenger 
[End] is desired arrival location, which must be different than> + [Start]

The dates are non-negative integers,each less or equal to than 2 billion, equal to the number of days after October 18, 2014. The times are non-negative integers equal to the number of minutes after midnight, i.e. they are integers between 0 and 1439, inclusive. The locations provided in the flights and the queries are all drawn from the list of p space ports provided in the test case.

Output
Your program should output the date and the time, in the same form as the input, of the earliest possible arrival for each query. If there is no trip possible, your program should output "No trip on XSL". 
Note: Every line of output should end in a newline character .

Sample Input 1
3 5 4 
Earth 
Romulus 
Vulcan 
Earth 1 720 Romulus 49 120 
Earth 200 1080 Vulcan 786 0 
Earth 200 1000 Romulus 1544 1439 
Romulus 50 720 Earth 149 240 
Vulcan 786 60 Romulus 1543 1100 
Earth 0 680 Romulus 
Earth 2 800 Romulus 
Vulcan 800 800 Romulus 
Romulus 2 900 Vulcan

Sample Output 1
49 120 
1543 1100 
No trip on XSL 
786 0

Sample Input 2
5 4 3 
Earth 
Romulus 
Vulcan 
Kronos 
Ceti_Alpha_V 
Earth 1 720 Vulcan 49 120 
Vulcan 49 179 Romulus 824 0 
Romulus 825 720 Earth 1654 0 
Earth 700 600 Vulcan 749 1420 
Earth 0 680 Romulus 
Earth 830 800 Vulcan 
Kronos 800 800 Ceti_Alpha_V

Sample Output 2
No trip on XSL 
No trip on XSL 
No trip on XSL
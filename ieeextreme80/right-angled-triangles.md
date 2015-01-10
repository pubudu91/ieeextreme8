# Right-Angled Triangle

Vangelis the bear wants to place a set of right-angled triangles on a Cartesian coordinate system in such way that the legs (*catheti*) $a$ and $b$ of the triangles are not parallel to the $x$ and $y$ axes and all the triangle vertices are coordinate pairs of integers.

## Task

Write a program that will accept the lengths of the triangle legs and will print `TRUE` if the triangle can be placed following the above conditions and print `FALSE` if it fails the above conditions.

## Input

The first line will contain an integer $n$ (with $0<n<11$), the number of triangles to study.

Each of the following $n$ lines will contain two space separated integers $a,b$ ($0<a,b< 1001$), corresponding to the lengths of the triangle legs.

## Output
There should be $n$ lines, on each line there should be the word `TRUE` or the word `FALSE`.

*Note: There is a newline character at the end of the last line of the output.*

## Sample IO

### Sample Input 1
3 
1 1 
5 5 
5 10

### Sample Output 1

    FALSE
    TRUE
    TRUE

### Explanation of Sample Input 1

Triangle 2: Can be placed on the following coordinates: 

    (2,1),(5,5),(-2,4). 

Triangle 3: Can be placed on the following coordinates:

    (-10,4),(-2,-2),(1,2).

## Solution

A catheri $r$ is not parallel with the $x$ or $y$ axis and placed between two integral points, if there exists two integers $\Delta x$ and $\Delta y$ such that: $\Delta x,\Delta y>0$ and $\Delta x^2+\Delta y^2=r^2$. We can check if this property by for the first catheri $a$ by enumerating over possible values of $\Delta x$: $[1,2,\ldots,a/\sqrt{2}]$ and check if the corresponding difference $\Delta y^2=a^2-\Delta x^2$ is square.

If catheri $a$ can be represented by a pair $(\Delta x,\Delta y)$, catheri should be represented by a pair $(\frac{b\cdot\Delta y}{a},-\frac{b\cdot\Delta x}{a})$.

This implies there exists an integer $\Delta x$ as described in the first paragraph such that $\frac{b\cdot \Delta x}{a}$ is a valid $\Delta x$ value for $b$, or more formally:

$$ \exists \Delta x\in\left\{1,2,\ldots,\frac{a}{\sqrt{2}}\right\}:\sqrt{a^2-\Delta x^2}\in\NNN\wedge \sqrt{b^2-\left(\frac{b\cdot\Delta x}{a}\right)^2}\in\NNN$$

We can test this by enumerating over all possible values for $\Delta x$.

### Time complexity

The algorithm runs in $a/\sqrt{2}$.
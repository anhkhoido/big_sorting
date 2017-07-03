Big Sorting

by _mfv_


Consider an array of numeric strings, unsorted, where each string is a positive number with anywhere from 1 to 10^6 digits. Sort the array's elements in non-decreasing (i.e., ascending) order of their real-world integer values and print each element of the sorted array on a new line.


INPUT FORMAT


The first line contains an integer, n, denoting the number of strings in unsorted. Each of the  subsequent lines contains a string of integers describing an element of the array.




CONSTRAINTS


1. 1 <= n <= 2 * 10^5
2. Each string is guaranteed to represent a positive integer without leading zeroes.
3. The total number of digits across all strings in unsorted is between 1 and 10 to the power of 6 (inclusively).


OUTPUT FORMAT


Print each of element of the sorted array on a new line.


SAMPLE INPUT 0


6

31415926535897932384626433832795

1

3

10

3

5


SAMPLE OUTPUT 0


1

3

3

5

10

31415926535897932384626433832795



EXPLANATION 0


The initial array of strings in unsorted is 31415926535897932384626433832795, 1, 3, 10, 3, 5. When we order each string by the real-world integer value it represents, we get:


1 <= 3 <= 3 <= 5 <= 10 <= 31415926535897932384626433832795


We then print each value on a new line, from smallest to largest.

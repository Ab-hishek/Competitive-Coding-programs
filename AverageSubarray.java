/*Given an array A of integers and an integer X. Find the length of maximum size subarray having an average of integers greater than or equal to X. 

For Example:
Input : A[] = {-2, 1, 6, -3}, X = 3
Output : 2
Longest subarray is {1, 6} having average 3.5 greater than X = 3.

Input:
The first line of input contains T denoting the number of test cases. Then T test cases follow. Each test case contains two lines of input. The first line contains the number N and X. The second line contains the array A.

Output:
For each test case, in a new line, print the length of the maximum size subarray having an average greater than equal to X.

Your Task:
You don't have to take input. You need to complete the function LongestSub(), which takes array arr, N and X as a parameter and returns the answer. The printing is done by the driver code.

Constraints:
1 <= T <= 10
1 <= N, X <= 105
1 <= abs(A[i]) <= 105
abs represent the absolute value of A[i]
Sum of N over all test cases doesn't exceed 105

Example:
Input:
3
10 7
2 3 6 -5 -3 7 9 7 -9 7
4 3
-2 1 6 -3 
5 2
2 -3 3 2 1
Output:
3
2
3
*/


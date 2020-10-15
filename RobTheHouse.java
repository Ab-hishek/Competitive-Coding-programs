/*
In Byteland there is a circular colony of N houses . Each house in the colony has some money. 
The value of money can either be positive or negative. Find the maximum amount of money you can have 
after robbing any number of contiguous houses.
Note: Robbing a house having negative money will reduce your money by that amount.
Input:
First line of input contains a single integer T which denotes the number of test cases. First line 
of each test case contains a single integer N which denotes the total number of houses. Second line 
of each test case contains N space separated integers denoting money in the houses.
Output:
For each test case print the maximum money by robbing the consecutive houses.
User Task:
The task is to complete the function maxMoney() which returns the maximum money.
Constraints:
1 <= T <= 100
1 <= N <= 106
-106 <= Arr[i] <= 106
Example:
Input:
3
7
8 -8 9 -9 10 -11 12
8
10 -3 -4 7 6 5 -4 -1
8
-1 40 -14 7 6 5 -4 -1
Output:
22
23
52
Explanation:
Testcase 1: Starting from last house of the colony, robbed 12 units and moving in circular fashion, 
we can rob  8, -8, 9, -9, 10, which gives maximum robbed monney as 22.
*/

class Sol{
    
    // finding the subarray with max sum
    static int  maxMoney(int a[], int n) 
    { 
        //int n = a.length; 
         //boolean flag  = false;
        int count =0;
        int maxx = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(a[i] > maxx)
              maxx = a[i];
            if(a[i] < 0)
              count++;
        }
        if(count == n)
          return maxx;
  
        // Case 1: get the maximum sum using standard kadane' 
        // s algorithm 
        int max_kadane = kadane(a); 
  
        // Case 2: Now find the maximum sum that includes 
        // corner elements. 
        int max_wrap  =  0; 
        for (int i = 0; i < n; i++) 
        { 
            max_wrap += a[i]; // Calculate array-sum 
            a[i] = -a[i];  // invert the array (change sign) 
        } 
  
        // max sum with corner elements will be: 
        // array-sum - (-max subarray sum of inverted array) 
        max_wrap = max_wrap + kadane(a); 
  
        // The maximum circular sum will be maximum of two sums 
        return (max_wrap > max_kadane)? max_wrap: max_kadane; 
    } 
  
    // Standard Kadane's algorithm to find maximum subarray sum 
    // See https://www.geeksforgeeks.org/archives/576 for details 
    static int kadane (int a[]) 
    { 
        int n = a.length; 
        int max_so_far = 0, max_ending_here = 0; 
        for (int i = 0; i < n; i++) 
        { 
            max_ending_here = max_ending_here + a[i]; 
            if (max_ending_here < 0) 
                max_ending_here = 0; 
            if (max_so_far < max_ending_here) 
                max_so_far = max_ending_here; 
        } 
        return max_so_far; 
    }  
    
}


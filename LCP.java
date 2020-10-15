/*
Given an array of N strings, find the longest common prefix among all strings present in the array.

Input:
The first line of the input contains an integer T which denotes the number of test cases. Each
test case contains an integer N. Next line has space-separated N strings.

Output:
Print the longest common prefix of the strings in the given array. If no such prefix exists print
"-1"(without quotes).

Your Task:
Since it is a functional problem , you don't need to take input just complete the function LCP()
which accepts given array of strings and its size as parameter and returns longest common prefix
of the strings in the given array if present else returns -1.

Constraints:
1 <= T <= 100
1 <= N <= 103
1 <= String Length <= 100

Example:
Input:
2
4
geeksforgeeks geeks geek geezer
3
apple ape april
Output:
gee
ap
Explanation:
Testcase 1: Longest common prefix in all the given string is gee.
*/
import java.io.*;
import java.util.*;

class LCP
{
    public String lcp(String s[],int n)
    {
        if (n == 0) return ""; 
      
        if (n == 1) return s[0]; 
      
        Arrays.sort(s);
        /*for(int i=0;i<s.length;i++)
            System.out.println(s[i]);*/ 
      
        int l = Math.min(s[0].length(), s[n - 1].length()); 
      
        String first = s[0], last = s[n - 1]; 
        int lcp_len = 0; 
        while (lcp_len < l && first.charAt(lcp_len) == last.charAt(lcp_len)) 
            lcp_len++; 
      
        if(lcp_len == 0)    return "-1";
        
        return first.substring(0,lcp_len);
    }

    public static void main(String args[])throws IOException{
        InputStreamReader read= new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        int n;
        
        n=Integer.parseInt(in.readLine());
        String s[]= new String[n];

        for(int i=0;i<n;i++)
            s[i]=in.readLine();

        LCP obj = new LCP();
        String result = obj.lcp(s,n);

        System.out.println(result);
    }
}

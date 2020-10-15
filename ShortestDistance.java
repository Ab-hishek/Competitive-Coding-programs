/*
Given a string S of lowercase characters and a character X. Find the shortest distance from
the character X to every other character in the given string S.

Input: 
The first line of input contains the number of testcases T. For each testcase, there will be
two lines containing S and X respectively.

Output: 
Print the shortest distance from the character X to every other character in the given string S.

Your Task:
You only need to implement the given function shortestDistance() which takes S and X as inputs
and returns an array of integers representing the shortest distance from the character X to
every other character in the string S.

Constraints:
1<= T <= 100
1 <= S.length() <= 10000

Example:
Input:
2
geeksforgeeks
e
helloworld
o

Output:
1 0 0 1 2 3 3 2 1 0 0 1 2
4 3 2 1 0 1 0 1 2 3

Explanation:
Testcase 1 :
Distance of g at position 0 from e at position 1 is 1.
Distance of f at position 5 from e at position 2 is 3.
Distance of 0 at position 6 from e at position 9 is 3.
*/
import java.io.*;
import java.util.*;

class ShortestDistance{
    public static void main(String args[])throws IOException
    {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);

        ArrayList<Integer> al = new ArrayList<Integer>();

        System.out.println("Enter a word: ");
        String word=in.readLine();
        System.out.println("Enter a word to calculate shortest distance: ");
        char search=(char)in.read();// or in.readLine().charAt(0);
        
        char c; int min=Integer.MAX_VALUE;

        for(int i=0;i<word.length();i++){
            c=word.charAt(i);
            if(c==search)
                al.add(i);
        }

        //System.out.println(al);
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==search)
                System.out.print(0+" ");
            else{
                min=Integer.MAX_VALUE;
                for(int e:al){
                    if(Math.abs(e-i)<min)
                        min=Math.abs(e-i);
                }
                System.out.print(min+" ");
            }
        }
        System.out.println();
    }
}

/*Better solution

class Solution 
{ 
	static Vector<Integer> shortestDistance(String S, char X) 
	{ 

		int prev = -15000; 
		Vector<Integer> ans = new Vector<>(); 
		
		for (int i = 0; i < S.length(); i++) 
		{ 
			if (S.charAt(i) == X) 
				prev = i; 
			ans.add(i - prev); 
		} 

		prev = 15000; 
		for (int i = S.length() - 1; i >= 0; i--) 
		{ 
			if (S.charAt(i) == X) 
				prev = i; 
				
			ans.set(i, Math.min(ans.get(i), prev - i)); 
		} 
		return ans;
	} 
} 
*/
/*You are given a large number of strings which you have to compress. If the process of compressing 
them is correctly done, the original string can be retreived by decompressing the compressed string. 
The process of decompressing is shown below :
Lets say the compressed string is ab*c*x
Iterate over the string from left to right, if you find a '*', remove it, and simply add a duplicate 
of the string on the left. Do this process repeatedly till all stars are removed.
Decompressing : ab*c*d -> ababc*d -> ababcababcd

Your task is to compress string to its smallest possible form. In case there are multiple ways to 
compress a string, prefer the one which return smaller output. For example, if input is zzzzzzz, 
output should be z*z*z and not z**zzz

Input: First line of input contains number of test cases T. Then T test cases follow. Each test case 
contains the string to be shortened in a newline. Input string consists solely of small case letters. Input will be read by driver code.

Output: The shortened string is to be printed as output. Output will be printed by driver code.

Your task: Your task is to complete the function compress() which takes the input string as argument 
and returns the compressed string.

Constraints: T <= 500 ; 1 <= |s| <= 105

Example:
Input:
2
ababcababcd
zzzzzzz
Output:
ab*c*d
z*z*z
*/

class Solution {
	void fillArray(String s, int[] a) {
		a[0] = 0;
		for (int i = 1; i<s.length(); i++) {
			int series = a[i - 1];
			while (series > 0) {
				if (s.charAt(series) == s.charAt(i)) {
					a[i] = series + 1;
					break;
				}
				series = a[series - 1];
			}
			if (series == 0) {
				if (s.charAt(i) == s.charAt(0))
					a[i] = 1;
				else
					a[i] = 0;
			}
		}
	}
	public String compress(String s) {
		int[] a = new int[s.length()];
		
		// ith element of array a stores the length of longest
        // proper suffix which is also a proper prefix
        // for substr s[0] to s[i]
		fillArray(s, a);

		Stack<Character> shortened = new Stack<Character>();
		
        // for even index, string length is odd
        // hence it cannot be divided into two
        // so we simply push ith character in stack
		for (int i = s.length() - 1; i > 0; i--) {
			if (i % 2 == 0) {
				shortened.push(s.charAt(i));
				continue;
			}
            // star_here will be made TRUE if substring s[0] to s[i]
            // can be divided into identical halves
			boolean star_here = false;
			
			// suffix and substring length are also meant for
            // substring s[0] to s[i]
			int suffix = a[i];
			int substrlen = i + 1;
            
            // these conditions, if true, imply that, substring
            // can be divided into 2 identical halves
			if (suffix * 2 >= substrlen)
				if (substrlen % (substrlen - suffix) == 0)
					if ((substrlen / (substrlen - suffix)) % 2 == 0)
						star_here = true;
            
            // adding * to stack and moving index as required
			if (star_here == true) {
				shortened.push('*');
				i = i / 2 + 1;
			} 
			
            // else, simply adding character to stack
			else
				shortened.push(s.charAt(i));
		}

		StringBuilder ret = new StringBuilder();
		ret.append(s.charAt(0));

        // since we analysed input string from end to start
        // removing elements from stack and pushing back to
        // output string will reverse them back to required order
		while (!shortened.empty()) {
			ret.append(shortened.peek());
			shortened.pop();
		}

		return ret.toString();
	}
}

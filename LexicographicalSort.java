/*
Given a string of lower case letters alphabets representing alphabetical order in an alien language. 
Sort the given list of words lexicographically according to that order.
Words will contain only those letters which are the in the alphabets string.

Input:
First line of input consists of number of test cases t. Then t test cases follow. In each test case 
first line consists of the string alphabets. Second line of test case consists of an integer n, 
representing the number of words to be sorted. Third line holds the n space separated strings which 
are to be sorted.

Output:
Output contains the n sorted strings in a single line separated by spaces.

Constraints:
Your task is to complete the function sort_by_order(), which sorts the words as explained. Do not 
print anything.

Example:
Input:
1
qwerty
5
we qwer erer qw errr
Output:
qw qwer we erer errr
*/

/*class Solution
{
    public String[] sortByOrder(String[] words, String alphabets )
    {
        // Write your code here
        int max=alphabets.length();
        for(int i=0;i<words.length;i++){
            if(alphabets.indexOf(words[i].charAt(0))<max && words[i].length()<)
        }
    }
}*/
import java.util.*;
class LexicographicalSort
{
    public String[] sortByOrder(String[] words, String alphabets)
    {
        HashMap <Character,Integer> order = new HashMap<>();
        for(int i=0 ; i<alphabets.length() ; i++ )
            order.put(alphabets.charAt(i) , i);
        
        for(int i=0; i<words.length; i++)
            for(int j=0; j<words[i].length(); j++)
            {
                int x = order.get(words[i].charAt(j));
                words[i] = words[i].substring(0, j) + (char)('a' + x) 
                        + words[i].substring(j + 1); 
            }

        System.out.println("Arrays before sort:");
        for(int i=0;i<words.length;i++)
            System.out.print(words[i]+" ");
        System.out.println();
        
        Arrays.sort(words);

        System.out.println("Arrays after sort in function:");
        for(int i=0;i<words.length;i++)
            System.out.print(words[i]+" ");
        System.out.println();
        
        
        for(int i=0; i<words.length; i++)
            for(int j=0; j<words[i].length(); j++)
            {
                char ch = alphabets.charAt(words[i].charAt(j) - 'a');
                words[i] = words[i].substring(0, j) + ch 
                            + words[i].substring(j + 1); 
            }
                
        return words;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String alphabet;
        int n;
        
        alphabet=sc.nextLine();
        n=sc.nextInt();
        String words[] = new String[n];
        
        for(int i=0;i<n;i++)
            words[i]=sc.next();

        LexicographicalSort ls =new LexicographicalSort();
        words=ls.sortByOrder(words,alphabet);

        System.out.println("array after sort: ");
        for(int i=0;i<n;i++)
            System.out.print(words[i]+" ");

        System.out.println();
    }
}

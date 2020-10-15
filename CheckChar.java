import java.io.*;
class CheckChar
{
	boolean areSame(int count1[], int count2[], String needle, String haystack){
        for(int i=0;i<256;i++)
            if(count1[i]!=count2[i])
                return false;
        return true;
    }

    String isShuffledSubString(String needle, String haystack)
	{
	    // Your code goes here
	    int count1[]= new int[256];
	    int count2[]= new int[256];
	    
        if(needle.length()>haystack.length())
            return "no";

        else{
	        for(int i=0;i<needle.length();i++){
	            count1[needle.charAt(i)]++;
	            count2[haystack.charAt(i)]++;
	        }


	        for(int i=needle.length();i<haystack.length();i++){
	            if(areSame(count1,count2,needle,haystack))
	                return "yes";
	            count2[haystack.charAt(i-needle.length())]--;
	            count2[haystack.charAt(i)]++;
	        }
	        return "no";
	    }
    }

    public static void main(String args[])throws IOException
	{   
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        
        String needle=in.readLine();
        String haystack=in.readLine();
        CheckChar obj =new CheckChar();
        String state=obj.isShuffledSubString(needle,haystack);
        System.out.println(state);
    }
}        
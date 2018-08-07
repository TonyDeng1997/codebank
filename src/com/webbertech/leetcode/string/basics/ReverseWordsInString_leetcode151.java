package com.webbertech.leetcode.string.basics;

/* Leetcode 151. Reverse Words in a String
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

solution: this question is not hard, but it does not specify that, 
if there are more white spaces in between the words, it only wants one white space.
Use a string replace function to do this trick, otherwise write another small function is not a big deal.
 * */
public class ReverseWordsInString_leetcode151 {
    
	  public static String reverseWords(String s) {
	     if (s==null||s.isEmpty()||s.trim().isEmpty()) {
	    	 return "";
	     }      
	     if (s.length() ==1) {
	    	 return s;
	     }
	     
	     int i=0;
	     int j=0;
	     char[] words= s.trim().toCharArray();
	     reverse(words, 0, words.length-1);
	     while(i<words.length) {
	    	 j=i+1;
	    	 //go until hit the first whitespace
	    	 while(j<words.length && words[j]!=' ') {
	    		 j++;
	    	 }
	    	 //reverse the word from the start and end index
	    	 reverse(words,i,j-1);
	    	 //skip all the whitespaces
	    	 while( j<words.length && words[j]==' ') {
	    		 j++;
	    	 }
	    	 //reset i
	    	 i=j;
	     }   
	     
	     return new String(words).replaceAll("\\s+"," ");
	  }
	  
	  static void reverse(char[] words, int start, int end) {
		  char temp;
		  int i= start, j= end;
		  while (i<=j) {
			  temp = words[i];
			  words[i] = words[j];
			  words[j] = temp;
			  i++;
			  j--;
		  }
	  }
	  
	  public static void main(String[] args) {
		  System.out.println(reverseWords("the sky is blue"));
		  System.out.println(reverseWords(" 1") +"end");
		  System.out.println("".isEmpty());
		  System.out.println("   ".isEmpty());
		  System.out.println(" ab".trim());
		  System.out.println("b    a".replaceAll("\\s+", " "));
	  }
}

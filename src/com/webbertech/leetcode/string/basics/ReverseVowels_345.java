package com.webbertech.leetcode.string.basics;

/*leetcode 345
 * 
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".
 * */
public class ReverseVowels_345 {

	static boolean isVowel(char c) {
        if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ||
        		c=='A' || c=='E' || c=='I' || c=='O' || c=='U') {
            return true;
        }
        return false;
   }
   
   public static String reverseVowels(String s) {
       char[] chars = s.toCharArray();
       int i=0;
       int j= chars.length-1;
       while(i<j) {
           if (isVowel(chars[i]) && !isVowel(chars[j])) {
               j--;
           } else if (!isVowel(chars[i]) && isVowel(chars[j])) {
               i++;
           } else if (isVowel(chars[i]) && isVowel(chars[j])) {
               char temp = chars[i];
               chars[i] = chars[j];
               chars[j] = temp;
               i++;
               j--;
           } else {
        	   i++;
        	   j--;
           }
           
             
       }
       return String.valueOf(chars);
   }
   
	public static void main(String[] args) {
		
		//System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("Aa"));
	}

}

package com.webbertech.leetcode.string.basics;
//leetcode 344, as simple as that
public class ReverseString_leetcode344 {

	  public static String reverseString(String s) {
		  if (s.equals("")) {
			  return s;
		  }
	        char[] c= s.toCharArray();
	        int i=0,j=s.length()-1;
	        while(i<j) {
	            char temp= c[i];
	            c[i] = c[j];
	            c[j] = temp;
	            i++;
	            j--;
	        }
	        return new String(c);
	    }
	  
	  public static void main(String[] args) {
		  System.out.println(reverseString("abc"));
		  System.out.println(reverseString("dabc"));
		  System.out.println(reverseString("12"));
	  }
}

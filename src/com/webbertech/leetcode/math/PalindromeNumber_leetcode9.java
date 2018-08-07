package com.webbertech.leetcode.math;
//leetcode 9. 

//Determine whether an integer is a palindrome. Do this without extra space.
//let us say negative number can not be palindrome

public class PalindromeNumber_leetcode9 {

	public static boolean isPalindrome(int x) {
		int reversed = 0;
		int orig = x;
	    if (x<0)
	    	return false;
	    
		while(x>0) {
           reversed = reversed*10 + x%10;;
           x = x/10;
	    }   
		
		return reversed == orig;
	}
	
	
	public static void main(String[] args) {
		
          System.out.println(isPalindrome(12321));
	}

}

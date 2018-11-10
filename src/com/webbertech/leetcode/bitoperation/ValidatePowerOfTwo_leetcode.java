package com.webbertech.leetcode.bitoperation;

public class ValidatePowerOfTwo_leetcode {
	
	
	/*
	 * Take a look at when n is 6 or 8
	 * 
	 * for 6 & 5 it is: 0110 & 0101 == 0100
	 * for 8 & 7 it is: 1000 & 0111 == 0 
	 * 
	 * The rule is that for x that is 2 to the power of n, x = 2^n.
	 * 
	 *  x is always in the format of ...0..1000, and x-1 is always ...0..0111..
	 *  so that their & operation results in 0.
	 * */
	
	static boolean powerOfTwo(int n) {
		return (n & (n-1)) == 0;
	}
	
	public static void main(String[] args) {
	    System.out.println(powerOfTwo(4));	
	    System.out.println(powerOfTwo(6));	
	    System.out.println(powerOfTwo(8));
	    System.out.println(powerOfTwo(16));
	}
}

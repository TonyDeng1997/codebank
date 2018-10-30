package com.webbertech.leetcode.math;
/*leetcode 326
Given an integer, write a function to determine if it is a power of three.

can you do it without using any loop:
like get the largest number that is power of 3, like 3^19.
 The following solution is a one liner.
 
 return Math.power(3,19) % num == 0? true: false;

*/
public class PowerOfThree_leetcode326 {
	
	static boolean isPowerOfThree(int num) {
	    int n=0;

	    while((num-Math.pow(3,n)) >0) {
	        n++;
	    }
	    if ((num-Math.pow(3,n))== 0) {
	    	return true;
	    }
	    return false;
	}

	public static void main(String[] args) {
         System.out.println(isPowerOfThree(9));
         System.out.println(isPowerOfThree(12));
	}
}
package com.webbertech.leetcode.bitoperation;

/*
 * leetcode 461 Hamming Distance
 * 
 * The Hamming distance between two integers is the number of positions at 
 * which the corresponding bits are different. Given two integers x and y, 
 * calculate the Hamming distance.
   Note:
	0 ¡Ü x, y < 231. 
	
	Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ¡ü   ¡ü

The above arrows point to positions where the corresponding bits are different.

It returns how many digits are different.
 * */

public class HammingDistance_leetcode461 {

	/*
	 * solution1: first xor two numbers and cover to binary string.
	  Then count with x and y separately and add them up.
	   xor is to preserve different bits.
	  */
	 public static int hammingDistance(int x, int y) {
		 //All different bits becomes 1 in x^y, and all the same ones are 0.
		 return Integer.bitCount(x^y);
	 }
	  /*
	  Solution2: I am trying to think to use the Integer.toBinaryString(x) and ...(y), 
	  then compare bit 
	  by bit. Then it is not possible. Then let us count x^y.
	*/
	  
	  public static int hammingDistanceII(int x, int y) {
	      String xOrY = Integer.toBinaryString(x ^ y);	      
	      int count = 0;
	      for (int i=0;i< xOrY.length();i++) {
	    	  if(xOrY.charAt(i) == '1') {
	    		  count++;
	    	  }
	      }
	      return count;
	  }

	  public static void main(String[] args) {
         System.out.println(hammingDistanceII(1,4));
	  }
}
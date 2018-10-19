package com.webbertech.leetcode.array;
/*
 * Leetcode 191 Number of 1 Bits
 * 
 * Write a function that takes an unsigned integer and returns the number of 1' 
 * bits it has (also known as the Hamming weight).

For example, the 32-bit integer 11 has binary representation 
00000000000000000000000000001011, so the function should return 3.
 
 Accepted.
 
 * */

public class NumberOfOneBits_leetcode191 {
    // you need to treat n as an unsigned value
	  public int hammingWeight(int n) {
	       if (n<0) return -1;
	       String str = Integer.toBinaryString(n);
	       int count=0;
	       for(char c: str.toCharArray()) {
	           if (c=='1') {
	               count++;
	           }
	       }
	       return count;
	    }
}

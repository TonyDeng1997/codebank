package com.webbertech.leetcode.math;
/*
 * leetcode, no loop
 * 
 * 4^x = num
 * 
 * x = log[4, num] = log[num]/log[4]
 * 
 * then Math.pow(4, log(num)/log4) == num
 * */
public class PowerOfFourII {

	static boolean isPowerOfFour(int num) {
		if (num<=0) return false;
		return Math.pow(4, (int)(Math.log(num)/Math.log(4))) == num;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOfFour(16));
		System.out.println(isPowerOfFour(8));
		System.out.println(isPowerOfFour(7));
	}
}

package com.webbertech.leetcode.bitoperation;

/*
 * Swap two number using ^ operation.
 * 
 * 
 * */
public class SwapTwoNumbers_leetcode {
     static void swap(int a, int b) {
    	  a = a^b;  //10 ^ 11 == 01
 		  b = a^b;   // 10 ^ 11 == 01 
 		  System.out.println(b); //2
 		  a = a^b;
 		System.out.println(a);
		System.out.println(b);
     }
     
	public static void main(String[] args) {
		int a=2;
		int b=3;
		
	    swap(a,b);
	}
}

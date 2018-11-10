package com.webbertech.leetcode.bitoperation;

public class CheckOddOrEvent {
  
	/*
	 * Check out an number is even or odd, just check its last bit
	 * 
	 * so n & 1  == 0 then it is even number
	 * 
	 * */
	
	static  boolean  evenQ(int n) {
	return (n & 1) == 0;	
  }
	
  public static void main(String[] args) {
	  System.out.println(evenQ(2));
	  System.out.println(evenQ(3));
	  System.out.println(evenQ(4));
  }
}

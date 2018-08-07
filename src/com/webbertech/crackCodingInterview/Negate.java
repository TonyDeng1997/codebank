package com.webbertech.crackCodingInterview;

//This is a trial, and it seems to me working, any corner case to make it not working
//negate an integer with pure bit operation
public class Negate {

	static int negate(int n) {
		int a = ~n + 1;
		System.out.println(n+ "'s negation is:"+ a);
		return a;
	}
	

	public static void main(String[] args) {
	   negate(1);
	   negate(2);
	   
	   negate(Integer.MAX_VALUE);
	   negate(Integer.MIN_VALUE);
	}
}
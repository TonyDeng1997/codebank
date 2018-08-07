package com.webbertech.leetcode.language;

public class Operator {

	static void test(Integer a, Integer b) {
		if (a == null || b == null) {
			System.out.println("I check a and then I stop");
			if (a == b) {
				System.out.println("this is true even they are all null");
			} else {
				
             System.out.println(a.intValue() == b.intValue());				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**********");
		test(null, null);
		System.out.println("**********");
		test(1,1);
		System.out.println("**********");
		test(1,3);
		System.out.println("**********");
		test(null,1);
	}

}

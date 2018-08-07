package com.webbertech.algorithm.bitoperation;

public class AddTwoNumberWithBitOperation {
  
	static int addTwo(int a, int b) {
		if (a == 0)
			return b;
		else if (b==0) {
			return a;
		}
		
		int sum = 0;
		int carry =0;
		while(b!=0) {
			sum = a^b; //sum without carry
			carry = (a&b) << 1;
			
			 a = sum;
			b = carry;
		}
		
		System.out.println(a);
		return a;
	}
	
	public static void main(String[] args) {
		addTwo(1,2);
		addTwo(1,-2);
		addTwo(-1,2);
		addTwo(0,0);
	}
}

package com.webbertech.algorithm.bitoperation;

public class ShiftOps {
   
	int repeatedArithmeticShift(int x, int count) {
		for(int i =0;i< count; i++) {
			x >>=1; //arithmetic shift by 1
		}
		return x;
	}
	
	int repeatedLogicalShift(int x, int count) {
		for (int i=0;i< count; i++) {
			x >>>= 1; //logical shift by 1
		}
		return x;
	}
	
	public static void main(String[] args) {                                                                    
		
	}
}

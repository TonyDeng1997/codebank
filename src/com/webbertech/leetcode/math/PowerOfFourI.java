package com.webbertech.leetcode.math;

public class PowerOfFourI {

	public static boolean isPowerOfFour(int num) {
	    while(num>0){
	        if(num==1){
	            return true;
	        }
	 
	        if(num%4!=0){
	            return false;
	        }else{
	            num=num/4;
	        }
	    }
	 
	    return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOfFour(16));
		System.out.println(isPowerOfFour(8));
		System.out.println(isPowerOfFour(7));
	}
}

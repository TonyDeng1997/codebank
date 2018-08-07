package com.webbertech.algorithm.bitoperation;

//decimal non-integer to binary format, if not with 32 characters then print error. 

public class PrintDecimalToBinary {

	//solution 1: times 2, and get the integer part in-order like .10101
	static String printBinary(double num) {
		if (num>1 || num < 0) {
			return "ERROR";
		}
		
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while(num>0) {
			  
			  //set limit to 32 chars
			if(binary.length()>=32) {
				return "Error";
			}
			
			double r = num *2;
			if (r>=1) {
				binary.append(1);
				num = r-1;
			} else {
				binary.append(0);
				num =r;
			}
			
			
		}
		return binary.toString();	
	}
	
	public static void main(String[] args) {
		System.out.println(printBinary(0.25));
	}
}

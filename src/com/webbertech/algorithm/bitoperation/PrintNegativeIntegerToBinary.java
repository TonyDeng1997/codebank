package com.webbertech.algorithm.bitoperation;

public class PrintNegativeIntegerToBinary {

	static void printNegativeToBinary(int K, int numOfBits) {
		if (K>=0 || numOfBits< 4)
			throw new IllegalArgumentException();
	
		int pos = Math.abs(K);
		
		double res= Math.pow(2,numOfBits-1)-pos;
		
		//store res in numOfbits-1 digits binary
		
		String partial= getBinaryStringWithoutSign(res, numOfBits-1);
		
		//give the sign bit
		partial= new StringBuilder(partial).append("1").toString();
		
		System.out.println(partial);
		  
	}
	
	static String getBinaryStringWithoutSign(double res, int length) {
		StringBuilder sb = new StringBuilder();
		int pos = (int)res;
        if(pos == 1) {
        	sb.append(1);
        	
        	while(sb.length()<length) {
        		sb.append(0);
        
        	}
    		return sb.toString();
        }
		while(pos/2!=1) {
			sb.append((int)pos%2);
			pos = pos/2;
		}
		sb.append("1");
		sb.append("1");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		//printNegativeToBinary(-7,4);
		printNegativeToBinary(-1,4);
	}
}

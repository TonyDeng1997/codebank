package com.webbertech.algorithm.bitoperation;

public class SwapOddEventBits {
    
	//test with 0110 and 1001
	 static int swapOddEvenBits(int x) {
		//>>> is to not to keep the sign bit, so new bit filled on the left is 0
		//0xaaaaaaaa is 10101010
		//0x55555555 is 01010101
		//test num is 6: 0110, use a shorter mask, 1010 and 0101 
		 // the following is to mask odd first and shift right 1 bit, mask even first and shift left 1 bit
		 return (
				   (x & 0xaaaaaaaa ) >>> 1 | ((x & 0x55555555) << 1)
				 );
	 }
	 
	 public static void main(String[] args) {
		 System.out.println(swapOddEvenBits(6));
	 }
}

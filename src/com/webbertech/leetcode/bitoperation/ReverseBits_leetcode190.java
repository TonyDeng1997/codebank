package com.webbertech.leetcode.bitoperation;
import java.util.HashMap;
import java.util.Map;

/*
 * Leetcode 190, Reverse bits
 * 
 * Reverse bits of a given 32 bits unsigned integer.

   For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

   Follow up:
   If this function is called many times, how would you optimize it?
   
   Solution: first convert to binary bit using existing API, and then reverse it.
   
   Question or assumption? is the return number also unsigned integer? 2^32 is ok.
   
   This question is not easy for Java. Because there is no concept of unsigned integer.
   Even you use bit operation, it will not be possible to enter Integer.MAX_VALUE+1
   
 * */

public class ReverseBits_leetcode190 {

	static public int reverseBits(int n) {
		if (n<0) return -1;
		if (n==0) return 0;
		if (n> Integer.MAX_VALUE)
			return 1;
        String bits = Integer.toBinaryString(n);
        
        String reversedStr = new StringBuilder().append(bits).reverse().toString();
        StringBuilder sb = new StringBuilder();
        sb.append(reversedStr);
        for (int i=0;i<(32-reversedStr.length());i++) {
            sb.append('0');                 
        }
        reversedStr = sb.toString();
        //think about n = 1, after reversed it is 1 0 0 0 0 (1 + 31's 0)
        int num=0;
        for(int i=reversedStr.length()-1;i>=0;i--) {
        	int bit = Integer.valueOf(String.valueOf(reversedStr.charAt(i)));
        	if (i==0 && num==0) {
        		return Integer.MIN_VALUE;
        	}
        	num+= bit * Math.pow(2, reversedStr.length()-1-i);
        }
        return num;
	}
	
	
	//solution2
	// you need treat n as an unsigned value
	//The Java solution is straightforward, just bitwise operation:

		public static int reverseBits2(int n) {
		    int result = 0;
		    for (int i = 0; i < 32; i++) {
		        result += n & 1;
		        n >>>= 1;   // CATCH: must do unsigned shift
		        if (i < 31) // CATCH: for last digit, don't shift!
		            result <<= 1;
		    }
		    return result;
		}

		
        //solution 3: Revisit this algorithm		
		//How to optimize if this function is called multiple times? We can divide an int into 4 bytes, and reverse each byte then combine into an int. For each byte, we can use cache to improve performance.
		// cache
		private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
		public int reverseBits3(int n) {
		    byte[] bytes = new byte[4];
		    for (int i = 0; i < 4; i++) // convert int into 4 bytes
		        bytes[i] = (byte)((n >>> 8*i) & 0xFF);
		    int result = 0;
		    for (int i = 0; i < 4; i++) {
		        result += reverseByte(bytes[i]); // reverse per byte
		        if (i < 3)
		            result <<= 8;
		    }
		    return result;
		}

		private int reverseByte(byte b) {
		    Integer value = cache.get(b); // first look up from cache
		    if (value != null)
		        return value;
		    value = 0;
		    // reverse by bit
		    for (int i = 0; i < 8; i++) {
		        value += ((b >>> i) & 1);
		        if (i < 7)
		            value <<= 1;
		    }
		    cache.put(b, value);
		    return value;
		}

	
	public static void main(String[] args) {
       System.out.println(reverseBits(43261596));
       System.out.println(reverseBits2(1));
   //    System.out.println(reverseBits2(2147483648));
       System.out.println( (int)Math.pow(2,32));
       
	}

}

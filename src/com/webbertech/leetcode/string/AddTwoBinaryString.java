package com.webbertech.leetcode.string;

/*
 * 
 * Leet code 67 
 * 
 * Given two binary strings, return their sum (also a binary string).
For example,
a = "11"
b = "1"
Return "100".


 *
 * 
 * For this example,   
 * System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", 
        		 "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));		
        		 
  it will overflow.
  
  This will not work, even with BigInteger it is not a good solution.
 * */
public class AddTwoBinaryString {
	 static double StringBinaryToInteger (String num) {
		 if (num.equals("0")) return 0;
		 char[] c = new StringBuffer(num).reverse().toString().toCharArray();
		 double sum = 0;
		 
		 
		 for(int i=0;i<c.length;i++) {
			 if (c[i] == '1')
			 sum+= Math.pow(2, i);
		 }
		 return sum;
	 }
	
	public static String addBinary(String a, String b) {
		int sum = (int)(StringBinaryToInteger(a) + StringBinaryToInteger(b));
	    if (sum ==0) return "0";
	    StringBuilder sb = new StringBuilder();
	    
		while(sum!=0) {
			sb.append(sum%2);
			sum = sum /2;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(StringBinaryToInteger("110"));
		System.out.println(StringBinaryToInteger("10"));
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("10", "0"));
		System.out.println(addBinary("10", "1"));
		System.out.println(addBinary("0", "0"));
         System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", 
        		 "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));		
	}
}

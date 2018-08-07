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

 * For this example, if you convert them to integer first and then convert the sum to binary.
 * it will overflow for the following case.
 *  
 * System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", 
        		 "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));		
        		 
  This will not work, even with BigInteger it is not a good solution.
  
  The following solution is accepted, the key point here is to notice to reset the carry bit
 * */


public class AddTwoBinaryString_leetcode67 {
	public static String addBinary(String a, String b) {
		if (a.equals("0") && b.equals("0")) {
			return "0";
		} else if (a.equals("0")|| b.equals("0")) {
			return a.equals("0") ? b: a;	
		}
		
		String shorter = a.length()> b.length()? b: a;
	        String longer = shorter.equals(a)? b: a;
	        
	         shorter= new StringBuffer(shorter).reverse().toString();
	         longer = new StringBuffer(longer).reverse().toString();
	        char[] shorter_char = shorter.toCharArray();
	        char[] longer_char = longer.toCharArray();
	        StringBuffer sb = new StringBuffer();
	        char carry = ' ';
	        for(int i=0;i<shorter.length();i++) {
	        	if (shorter_char[i] == '1'  && longer_char[i] == '1' && carry== ' ')  {
	            	 sb.append("0");
	            	 carry = '1';
	             } else if (shorter_char[i] == '0'  || longer_char[i] == '0') {
	            	 char c = shorter_char[i] == '0' ? longer_char[i] : shorter_char[i];
	            	 
	            	 if(c=='1' && carry=='1') {
	            		 sb.append("0");
		            	 carry = '1';
	            	 } else if (c=='0' && carry == '1') {
	            	    sb.append("1");	
	            	    carry=' ';
	            	 } else {
	            		 sb.append(String.valueOf(c));
	            	 }
	             } else if (shorter_char[i] == '1'  && longer_char[i] == '1' && carry== '1') {
	            	 sb.append("1");
	            	 carry='1';
	             }
	             
	        }
	        for (int i= shorter.length();i<longer.length();i++) {
	        	if (longer_char[i] == '1' && carry == '1')  {
	            	 sb.append("0");
	            	 carry = '1';
	             } else if (longer_char[i] == '1' && carry == ' ') {
	            	 sb.append("1");
	            	 carry = ' ';
	             } else if (longer_char[i] == '0' && carry == ' ') {
	            	 sb.append("0");
	             } else if (longer_char[i] == '0' && carry == '1') {
	            	 sb.append("1");
	            	 carry = ' ';
	             }
	        }
	        if (carry=='1')
	        	sb.append("1");
	        return sb.reverse().toString();
   }

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("10", "0"));
		System.out.println(addBinary("10", "1"));
		System.out.println(addBinary("0", "0"));
         System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", 
        		 "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));	
         
         //"10101"
         System.out.println(addBinary("1010", "1011"));
         
         /*
         "1111"
         "1111"
         */
         
         System.out.println(addBinary("1111", "1111"));
         
         /*
         "1010"
         "1011"
         */
         System.out.println(addBinary("1010", "1011"));
         
         /*
          * "100"
			"110010"
			Expected: "110110"
          * */
         System.out.println(addBinary("110010", "100"));
         
         /*
          * "101111"
			"10"
			Expected: "110001"
          * */
         System.out.println(addBinary("101111", "10"));
	}
}

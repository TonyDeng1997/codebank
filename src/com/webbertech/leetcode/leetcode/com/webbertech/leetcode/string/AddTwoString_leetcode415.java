package com.webbertech.leetcode.string;

/*
 * Leetcode 415
 * 
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * 
 * testing input: 0 0
 * testing input: 1 9
 * testing input: 9 99
 * 
 * pay attention to the character to integer conversion.
 * 
 * not accepted yet
 * */
public class AddTwoString_leetcode415 {

	public static String addStringsI(String num1, String num2) {
        if (num1 == null || num1.isEmpty()) {
            return num2;
        }
        if (num2==null|| num2.isEmpty()) {
            return num1;
        }
        String longer = num1.length()>=num2.length()? num1: num2;
        String shorter = longer.equals(num1)?num2:num1;
        int added = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=shorter.length()-1;i>=0;i--) {
            int op1= Character.getNumericValue(shorter.charAt(i));
            int op2 = Character.getNumericValue(longer.charAt(i));
            int sum = op1+ op2 + added;
            if (sum>=10) {
                added = 1;
                sum = sum%10;
            } 
            sb.append((new Integer(sum)).toString());   
        }
      
        int index=0;
        
        // there is bug in here
        if (added ==1) {
        	if (longer.length()>shorter.length()) {
        		index = (longer.length() - shorter.length())-1;
        		int value = Character.getNumericValue((longer.charAt(index)))+added;
        		sb.append((new Integer(value)).toString());
        		sb.append(longer.substring(0,index));
        	} else {
        		sb.append(new Integer(added).toString());
        		
        	}
        }
        sb.reverse();
        return sb.toString();
    }
	
	 public static String addStringsII(String num1, String num2) {
	       if (num1 == null|| num2 == null) return "";
	        return String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2));
	    }
	
	public static void main(String[] args) {
		System.out.println(addStringsII("1","9"));
		System.out.println(addStringsII("99","9"));
		// Not working
		//System.out.println(addStringsII("6913259244","71103343"));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.valueOf("6913259244"));
	}
}
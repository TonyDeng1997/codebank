package com.webbertech.leetcode.string;

import java.math.BigInteger;

/*
 * Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
 * 
 * */

public class StringToInteger_ATOI_leetcode8 {
    
	static int processIntegerString(String num) {
		String posNum = null ;
		Integer intNum=null;
		if (num.startsWith("-")) {
			posNum = num.substring(1,num.length());
			BigInteger min = new BigInteger(String.valueOf(Integer.MIN_VALUE).substring(1));
			if ((new BigInteger(posNum)).compareTo(min) >= 0 ) {
				intNum = Integer.MIN_VALUE;
				return intNum;
			}
		 
			posNum = num.substring(1,num.length());
			intNum = Integer.valueOf(posNum) * (-1);
			
		} else {
		 if (new BigInteger(num).compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>= 0 ) {
			 intNum = Integer.MAX_VALUE;
			 return intNum;
		 }
		 
		 intNum = Integer.valueOf(num) ;
	
		}
		
		return intNum;
	}
	
	static double processDecimalString(String num) {
		String posNum = null ;
		Double intNum=null;
		if (num.startsWith("-")) {
			posNum = num.substring(1,num.length());
			BigInteger min = new BigInteger(String.valueOf(Double.MIN_VALUE).substring(1));
			if ((new BigInteger(posNum)).compareTo(min) >= 0 ) {
				intNum = Double.MIN_VALUE;
				return intNum;
			}
		 
			posNum = num.substring(1,num.length());
			intNum = Double.valueOf(posNum) * (-1);
			
		} else {
		 if (new BigInteger(num).compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>= 0 ) {
			 intNum = Double.MAX_VALUE;
			 return intNum;
		 }
		 
		 intNum = Double.valueOf(num) ;
	
		}
		
		return intNum;
	}
	
	public static int myAtoi(String str) {
		if (str == null || str.trim().isEmpty() ) {
			return 0;
		}
		String num = str.trim();
		
		if (!num.matches("-?\\d+.*$")) {
			return 0;
		}
		
		int intNum =0;
		if (num.matches("-?\\d+")) {
			intNum = processIntegerString(num);
		} else if (num.matches("-?\\d+.*$")) {
			String[] arry = num.split("\\s+");
			intNum = processIntegerString(arry[0]);
		} else if (num.matches("-?\\d+\\.\\d+")) {
			intNum = (int)processDecimalString(num);
		}
		
		 //System.out.println(intNum);
		 return intNum;
	}
    
    public static void main(String[] args) {
    	System.out.println(myAtoi("-1"));
    	System.out.println(myAtoi("1"));
    	System.out.println(myAtoi("-91283472332"));
    	System.out.println(myAtoi("-2147483648"));
    	
    	System.out.println(myAtoi("4193 with words"));
    	System.out.println(myAtoi("3.15"));
    	//System.out.println(myAtoi("abc"));
    	//System.out.println(myAtoi("-adfasdfasdf"));
    }
}

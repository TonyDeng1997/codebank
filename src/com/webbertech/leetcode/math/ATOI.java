package com.webbertech.leetcode.math;
import java.math.BigInteger;
import java.util.ArrayList;

public class ATOI {
	static boolean validNumber(char letter) {
		if (letter>=48 && letter<=57 || letter == '-' || letter== '+') {
			return true;
		} else 
			return false;
	}

	static int getValueFromASCIICode(char letter) {
	   return letter-48;
	}


	// these are requirements from the interviewer
	//"    010", is a valid string
	//"a010", is not a valid string
	//"010   ", is a valid string
	//"+2", "-2", valid string
	//"  -0012a42" is -12, and it is valid
	//"   +0 123" is invalid

	static boolean validInput(String str) {
		int signCount = 0;
		if (str.equals("")) return false;
		//b00100
		if (!validNumber(str.charAt(0)) && !Character.isWhitespace(str.charAt(0))) return false;
		int numCount =0;
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			 
		   if (c>=48 && c<=57) {
			   numCount++;
		   }
			if(c=='-' || c=='+') {
				signCount++;
			}
		}
		if (signCount>1) return false;
		if (numCount==0) return false;
		return true;
	}
	
	//step1
	static String removeLeadingWhitespace(String str) {
		String newStr = null;
		for (int i=0;i<str.length();i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				newStr =str.substring(i,str.length());
				break;
			}
		}
		return newStr;
	}
	
	//step2 discard non-numeric digits
	static String removeNonNumber(String str) {
		String newStr = null;
		for (int i=0;i<str.length();i++) {
			if (!validNumber(str.charAt(i))) {
				newStr =str.substring(0,i);
				break;
			}
		}
		return newStr == null ? str: newStr;
	}
	
	//step3 remove leading 0
	static String removeLeadingZero(String str) {
		String newStr = null;
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i) != '0') {
				newStr =str.substring(i,str.length());
				break;
			}
		}
		return newStr;
	}
	
	//"   +0 123"
	//shall we handle "  11 0"?, replace all the trailing space and trailing zero
	private static String preprocess(String str) {
		String newStr= removeLeadingWhitespace(str);
		newStr = removeNonNumber(newStr);
		
		return newStr;
	}



	
	static int atoi(String str) {
		float num = 0;
		
		boolean positive = true;
		if(!validInput(str)) {
				return 0;
		}
		str= preprocess(str);
		
		
		
		if(!validInput(str)) {
			return 0;
		}
		
		
	    int index=0; //nonsign digit index 
	    boolean sign= false;
	    
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {
			for (int i =0;i< str.length();i++) {
				if (str.charAt(i) == '-' || str.charAt(i) == '+') {
					sign = true;
					if (str.charAt(i) == '-') {
					positive = false;
					}
					//- or + will be noted down
					index = i;
				} else if (index != 0){
					break;
				}
			}
		}

		if (sign) {
			if (index>=1) return 0;
			str= str.substring(index+1,str.length());
		}

		
		//remove leading zero
		if (str.length() ==1 && str.equals("0")) {
          return getValueFromASCIICode(str.charAt(0));
		}
		
		
		str=removeLeadingZero(str);

		
	    if (str.length() ==1) {
		   num = getValueFromASCIICode(str.charAt(0));
		   if (positive)
			return (int)num;
			else 
			return (int)-num;
		  }

     
	 
	    /*
		for(int i=0;i< str.length();i++) {
			num += Math.pow(10,str.length()-i-1)*getValueFromASCIICode(str.charAt(i));
		}*/
		
		if (positive){
			   BigInteger bigNumber= new BigInteger(str);
			   BigInteger maxInt = new BigInteger(new String().valueOf((Integer.MAX_VALUE))); 
			   BigInteger larger= bigNumber.max(maxInt);
			   //the actual string's number is larger than the int max
			   if (larger.equals(bigNumber)) {
				   return maxInt.intValue();
			   } else 
			   return bigNumber.intValue();
		}
		else { 
			 BigInteger bigNumber= new BigInteger("-"+str);
			 BigInteger minInt = new BigInteger(new String().valueOf((Integer.MIN_VALUE))); 
			 BigInteger smaller= bigNumber.min(minInt);
			 if (smaller.equals(bigNumber)) {
				 return minInt.intValue();
			 } else
				 return bigNumber.intValue();
		}
	}



	public static void main(String[] args) {
	  
		String num = "123";
		System.out.println(num + " "+ atoi(num));

		num = "+2";
   		System.out.println(num + " "+ atoi(num));
	
		num = "+-2";
   		System.out.println(num + " "+ atoi(num));
	
		num = "+-21";
   		System.out.println(num + " "+ atoi(num));
	
	    num = "-2";
   		System.out.println(num + " "+ atoi(num));
	
		 num = "    010";
   		System.out.println(num + " "+ atoi(num));
    	
    	num = "";
   		System.out.println(num + " "+ atoi(num));
   
        num = "  -0012a42";
   		System.out.println(num + " "+ atoi(num));
   		
   		num = "   +0 123";
   		System.out.println(num + " "+ atoi(num));
   	
   		num = "abc";
   		System.out.println(num + " "+ atoi(num));
   	
	    num = " b11228552307";
	    System.out.println(num + " "+ atoi(num));
	    
	    num = "b11228552307";
	    System.out.println(num + " "+ atoi(num));
	    
	    num = "+";
	    System.out.println(num + " "+ atoi(num));
	    
	    num = "-123";
			System.out.println(num + " "+ atoi(num));
	  
		num ="-2147483647";
	    System.out.println(num + " "+ atoi(num));
	    
	    num ="-2147483648";
	    System.out.println(num + " "+ atoi(num));
	    
	
		
		num ="2147483648";
		    System.out.println(num + " "+ atoi(num));
		    
		    num ="-2147483649";
		    System.out.println(num + " "+ atoi(num));
	}
}

package com.webbertech.realinterview;
/*
 * ICIMS interview questions
 * A phone number that is not in the right format, you need to reformat it.
 * 
 * If it is evenly multiple of 3, then every 3 digits is a block followed by a dash.
 * If it is not the multiple of 3, the last two groups has to be 2 digits and 2 digits.
 * 
 * */
public class PhoneNumber {
	 public static String formatPhoneNumber(String S) {
	        // write your code in Java SE 8
		   String formatted = S.replaceAll("\\s+","").replaceAll("-","");
		   StringBuilder sb = new StringBuilder();
		   int count=0;
		   for(int i=0;i<formatted.length();i++) {
			  if (count<3) {
				   sb.append(formatted.charAt(i));
				   count++;
			  } else{
				  count=0;
				
				  if (formatted.length()-1-i<1) {
					  sb.insert(sb.length()-1, "-");
					  sb.append(formatted.charAt(i));
					  continue;
				  }
				  sb.append('-');
				  sb.append(formatted.charAt(i));
				  count++;
			  }
			 
		   }
		   return sb.toString();
	    }
	
	 public static String formatPhoneNumber2(String S) {
		 return "";
	 }
	 
    public static void main(String[] args) {
    	System.out.println(formatPhoneNumber("00-44  48 5555 8361"));
    	System.out.println(formatPhoneNumber("0 - 22 1985--324"));
    	StringBuilder s = new StringBuilder();
    	s.append("1");
    	s.append("2");
    	s.append("3");
    	s.insert(1, "4");
    	System.out.println(s.toString());
    	
    }
}

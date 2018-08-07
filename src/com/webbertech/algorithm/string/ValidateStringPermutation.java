package com.webbertech.algorithm.string;

import java.util.Arrays;

public class ValidateStringPermutation {
      
	//solution 1: compare sorted string
 	public static boolean validatePermuation(String str1, String str2) {
       	  if (str1.length()!= str2.length()) {
       		  return false;
       	  }
       	  
       	  char[] charArray1 = str1.toCharArray();
       	  char[] charArray2 = str2.toCharArray();
       	  Arrays.sort(charArray1);
       	  Arrays.sort(charArray2);
       	  
       	  
       	  return String.valueOf(charArray1).equals(String.valueOf(charArray2));
    }
	
	//using frequency array, this is more neat, 
	//first of all you need to know only 128 bit boolean array is needed, 128 ASCII characters
	//do it in one pass
	
	public static boolean validPermutation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		int[] fArray = new int[128];
		char[] cArray1 = str1.toCharArray();
		char[] cArray2 = str2.toCharArray();
		
		for(int i=0;i< cArray1.length;i++) {
		      //System.out.println(cArray1[i]);
			fArray[cArray1[i]]++;
		}
		
		for(int i=0;i<cArray2.length; i++) {
	         fArray[cArray2[i]]--;
			
			if (fArray[i] < 0) 
			{
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		//System.out.println(validatePermuation("abc","acb"));
		System.out.println(validPermutation("abc", "adb"));
	}
}

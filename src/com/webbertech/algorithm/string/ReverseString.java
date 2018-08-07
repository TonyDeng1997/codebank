package com.webbertech.algorithm.string;

public class ReverseString {

	
	//reverse string
	public static String reverse(String s) {
	   char[] c= s.toCharArray();
	   for(int i=0,j=c.length-1; i< c.length/2; i++,j--) {
		   char temp;
		   temp = c[j];
		   c[j] = c[i];
		   c[i] = temp;
	   }
		
	   return String.valueOf(c);
	} 
	
	public static String reverse1(String s) {
		   char[] c= s.toCharArray();
		   for(int i=0,j=c.length-1; i<=j; i++,j--) {
			   char temp;
			   temp = c[j];
			   c[j] = c[i];
			   c[i] = temp;
		   }
			
		   return String.valueOf(c);
		} 
	
	//in unsorted array, find the largest two even number

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          String s = "abcdefgh";
          System.out.println(reverse1(s));
          
	}

}

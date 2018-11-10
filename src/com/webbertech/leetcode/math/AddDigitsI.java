package com.webbertech.leetcode.math;

public class AddDigitsI {

	
	//solution 1
	 public static int checkDigits(int num) {
		 int count=0;
		 while(num!=0) {
			 count++;
			 num /=10;
		 }
	 
		 return count;
	 }
	 
	 public static int addDigits(int num) {
	     int n = num;
		 int sum=0;
		
		 do{
			 if (sum!=0) {
				 n = sum;
				 sum=0;
			 }
			 while(n!=0) {
				 sum+=n%10;
				 n/=10;
			 }
		 } while(sum!=0 && checkDigits(sum)>1);
		 
		 return sum;
	 }
	 
	 
	 //solution2:
	 
	 static int addDigitsII(int num) {
	        while (num / 10 > 0) {
	            int sum = 0;
	            while (num > 0) {
	                sum += num % 10;
	                num /= 10;
	            }
	            num = sum;
	        }
	        return num;
	    }
	 
	 public static void main(String[] args) {
		 System.out.println(addDigitsII(38));
	 }
}

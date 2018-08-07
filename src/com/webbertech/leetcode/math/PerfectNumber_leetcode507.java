package com.webbertech.leetcode.math;

/*
 * Leetcode 507 Perfect Number
 *  We define the Perfect Number is a positive integer 
 *  that is equal to the sum of all its positive divisors 
 *  except itself.

Now, given an integer n, write a function that 
returns true when it is a perfect number and false when it is not.

Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)

Solution: Pay attention this is the solution to find positive divisors, also pay attention to the upper bound
 Accepted.
 * */

public class PerfectNumber_leetcode507 {

	  public static boolean checkPerfectNumber(int num) {
		  if (num<=0 || num==1) return false;
	        int sum=1;
	        for(int i=2;i<(int)Math.sqrt(num)+1;i++) {
	            if (num%i==0) {
	                if (num/i == i) {
	                    sum+=i;
	                } else {
	                    sum=sum+num/i+i;
	                }
	            }
	        }
	        return num == sum;
	  }
	  
	  public static void main(String[] args) {
		  System.out.println(checkPerfectNumber(3));
	  }
}

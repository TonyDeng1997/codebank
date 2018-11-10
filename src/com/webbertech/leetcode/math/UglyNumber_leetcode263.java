package com.webbertech.leetcode.math;

/*
 *leetcode 263
 *
 * Write a program to check whether a given number is an ugly number.
   Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
   For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
   Note that 1 is typically treated as an ugly number. 
 * */

/* solution: recursion , it is very simple that, an ugly number must be 
 * either the multiple of 2 or 3 or 5.
 * 
 *  Take : 2 * 7, 3*7, 5*7
 *  Take : 2*2*7
 *   
 *  as counter example, if it is not the multiple of 2,3 and 5, then it is not ugly number
 *  for instance, 7 is not ugly number. 
 */


public class UglyNumber_leetcode263 {

	 public static boolean isUgly(int num) {
	        if (num <=0) return false;
	        if (num==1) return true;
	        // if a number that can not be divided by all of 2,3,5, it is not an ugly number
	        // for instance 31
	        if (num%2!=0 && num%3!=0 && num%5!=0) {
	            return false;
	        }
	        if (num%2==0) {
	            return isUgly(num/2);
	        }
	        if (num%3==0) {
	            return isUgly(num/3);
	        }
	        if (num%5==0) {
	            return isUgly(num/5);
	        }
	        return true;
	    }
	    
	    public static void main(String[] args) {
	    	System.out.println(isUgly(1369479539));
	    	System.out.println(isUgly(6));
	    	System.out.println(isUgly(8));
	    	System.out.println(isUgly(14));
	    	System.out.println(isUgly(31));
	    }
}

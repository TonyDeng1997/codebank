package com.webbertech.leetcode.math;

/*
 * 
Leetcode 367. Valid Perfect Square

Given a positive integer num, write a function which returns True if num is a perfect square else False.
Note: Do not use any built-in library function such as sqrt. 

*/

public class ValidatePerfectSquareNumber_leetcode367 {

	   //solution1, too slow, uses newton iteration
	    public boolean isPerfectSquare(int num) {
	        int res = sqrt(num);
	        return res*res == num;
	    }
	    
	    int sqrt(int num) {
	        int g = num;
	        while (Math.abs(g*g-num)> 0.000001f) {
	            g = (g+num/g)/2;
	        }
	        return (int)g;
	    }
	    
	    
	    //solution2, generic way passed leetcode
	    public static boolean isPerfectSquareII(int num) {
	    	if (num == 1) return true;
	        for(int i=2;i<=num/2;i++) {
	            if (i*i< num) 
	            	continue;
	            if (i*i == num) 
	            	return true;
	        }
	        return false;
	    }
	    
	    /* solution3, improved newton iteration
	     * Use long for x, because x*x will overflow.
	     * */
	    public boolean isPerfectSquareIII(int num) {
	        long x = num;
	        while (x * x > num) {
	            x = (x + num / x) >> 1;
	        }
	        return x * x == num;
	    }
	    
	    
	    /* solution4, O(sqrt(n))
	     * This is more like generic but it is more mathematical
	     * */
	    
	    public boolean isPerfectSquareIV(int num) {
	        int i = 1;
	        while (num > 0) {
	            num -= i;
	            i += 2;
	        }
	        return num == 0;
	    }
	    
	    /* solution 5 O(log(n))
	     *  This is using binary search.
	     * 
	     * */
	    
	    public static boolean isPerfectSquareV(int num) {
	        int low = 1, high = num;
	        // less equal is to handle when num is 1
	        while (low <= high) {
	        	// what is the this?
	            long mid = (low + high) >> 1;
	            if (mid * mid == num) {
	                return true;
	            } else if (mid * mid < num) {
	                low = (int) mid + 1;
	            } else {
	                high = (int) mid - 1;
	            }
	        }
	        return false;
	    }
	    
	    public static void main(String[] args) {
	      System.out.println(isPerfectSquareV(1));	
	      System.out.println(isPerfectSquareV(16));
	      System.out.println(isPerfectSquareV(25));	
	    }
}
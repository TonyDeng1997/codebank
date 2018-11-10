package com.webbertech.leetcode.math;
/*
 * leetcode 69
 * int sqrt(int x)
 * 
 * newton iteration can do this but this is not the purpose of this question
 * 
 * solution 1: see the complexity of this
 * 
 * 	We are using x itself as initial approximation
		   This can definitely be improved 
		  float g = x;
		  float y = 1;
		  float e = 0.000001f;  //accuracy levelsr
		  while(g - y > e)
		  {
		    g = (g + y)/2;
		    y = x/g;
		  }
		  return (int)x;
	
  	solution 2: i*i == n, but it is going to be O(m)  (m < n)
  	
  	solution 3: O(logn)
  	
  	question: 
  	
  	  float g=x;
      while(Math.abs(g*g-x)>0.000001f)
        g=(g+x/g)/2;
      return (int)g;

     why float type above takes more time?

*/
public class Sqrt_leetcode69 {

	public static int mySqrtFloat(int x) {
		long start = System.currentTimeMillis();
		 float g=x;
         while(Math.abs(g*g-x)>0.000001f)
        g=(g+x/g)/2;
         System.out.println(System.currentTimeMillis() - start);
      return (int)g;
    }

	public static int mySqrtDouble(int x) {
		//long start = System.currentTimeMillis();
		 float g=x;
         while(Math.abs(g*g-x)>0.001) {
        	 g=(g+x/g)/2;
        	 System.out.println("hello");
         }
        // System.out.println(System.currentTimeMillis() - start);
      return (int)g;
    }
	
	public static void main(String[] args) {
		/*
		System.out.println(mySqrt(2));
		System.out.println(mySqrt(4));
		System.out.println(mySqrt(8));
		System.out.println(mySqrt(16));
		System.out.println(mySqrt(225));
		*/
		
		//System.out.println(mySqrtDouble(2147483647));
		System.out.println(mySqrtDouble(29792276));
		//System.out.println(mySqrtDouble(8192));
	}
}

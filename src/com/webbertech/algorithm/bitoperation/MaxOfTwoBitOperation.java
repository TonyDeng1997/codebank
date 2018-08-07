package com.webbertech.algorithm.bitoperation;

//find the larger number from two numbers, you can not use comparison operator or if else

/*	
 * 	we can check its sign bit is 1 or 0.
 *  and use mutiplication to to replace comparison
 *  simply: a*k + b* q  (k=1, q=0 or k=0, q = 1)
 *  
 *  now, q is simply flip(k), flip is to flip from 1 to 0 or 1 to 0.
 */

public class MaxOfTwoBitOperation {
	
	//input is 0 or 1
	static public int flip(int bit) {
		return bit^1;
	}
	
	//get the sign, shift 31 to the right
	/* This will be a good one 
	*/
	static public int sign(int a) {
		return flip((a>>31)&1);
	}
	
	
	//solution 1
	//this method does not work for overflow case
	static int getMaxNative(int a , int b) {
		int k = sign(a-b);
		int q = flip(k);
		System.out.println(a * k + b * q);
		return a * k + b * q;
	}
	
	
	
	
	//solution 2 optimal
	/*
	 * If a,b have different sign, 
	   //if a > 0, b < 0, then k =1
	   //if a<0, b>0, then k=0
	   //so k is always sign(a)
			Let k = sign(a)
		Else
 			Let k = sign(a-b)  //overflow is impossible
	 * 
	 * */
	
	 static int getMax(int a, int b) {
		 int c = a-b;
		 
		 //1 is positive, 0 is negative
		 int sa = sign(a);
		 int sb = sign(b);  
		 int sc = sign(c);
		 
		 int use_sign_of_a = sa ^ sb; //same is positive, different is negative
		 int use_sign_of_c = flip(use_sign_of_a);
		 
		 /*if a > b, a and b are same sign both positive
		  * use_sign_of_a is 0, sa is 1, then use_sign_of_c is 1, sc is 1
		  * so k is 1, q is 0
		  * 
		  *if a > b, a,b are negative
		  * sa = 0, sc = 1, use_sign_of_a = 0, use_sign_of_c = 1, sc = 1
		  * so k =1
		  * 
		  * 
		  *if a > b, a >0, b < 0 
		  *  use_sign_of_a is 1 , sa is 1, use_sign_of_c 0, sc does not matter
		  *  k = 1, q is 0
		  *  
		  *if a > b, a < 0, b>0
		  *sa=0, use_sign_of_a=0, sc = 1, use_sign_of_c = 1
		  *k =1, q =0
		  *
		  *in the example of INT_MAX - (-15), because it is already overflow, so 
		  *we can't use the sign of that overflowed number for k, however,in the third case
		  *above, we use a. The tricky is that as long as a,b are with different sign,
		  *k = sign(a)
		  *   
		  */
		 int k = use_sign_of_a * sa + use_sign_of_c * sc;
		 int q = flip(k); //opposite of k
		 
		 System.out.println(a * k + b * q);
		 return a * k + b * q;
	 }
	
	 
	 
	public static void main(String[] args) {
		//this is wrong
		getMaxNative(Integer.MAX_VALUE-1,-12);
		
		
		//this is right
		//getMaxNative(2,1);
		
		//testing the right one
		System.out.println(Integer.MAX_VALUE-1);
		getMax(Integer.MAX_VALUE-1,-12);
	}
}

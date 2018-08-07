package com.webbertech.leetcode.math;

/* Leetcode 70
 * You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways 
can you climb to the top?

Note: Given n will be a positive integer.

Solution: fabonacci problem

The Fibonacci Sequence is the series of numbers: 
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ... 
or someone says 1,1,2,3,....

The next number is,
you can use recursion but it is slower.

Non-recursion way is faster.
say n=5, how many ways you can climb?
it is combinations problem.

1,1,1,1,1
1,1,1,2
1,1,2,1
1,2,1,1
2,1,1,1
1,2,2
2,1,2
2,2,1
totally 8 ways.
* */


/* This is better, no extra space 
 * When it is compared with the recursion, it is 
 * 
 * */

public class ClimbingStairs_leetcode70 {
	
	public static int climbStairsI(int n) {
		 if(n==0||n==1) return  1;
		    int stepOne=1,stepTwo=1;
		    int result=0;
		    for(int i=2;i<=n;i++){
		        result=stepOne+stepTwo;
		        stepTwo=stepOne;
		        stepOne=result;
		    }
		    return result;
    }
	
	
    //solution2: using extra space
	/*
	 * The good thing is that the data sequence is preserved, but it costs
	 * more memory.
	 * */
	public static int climbStairsII(int n) {
	    if(n == 0 || n == 1 || n == 2){return n;}
	    int[] mem = new int[n];
	    mem[0] = 1;
	    mem[1] = 2;
	    for(int i = 2; i < n; i++){
	        mem[i] = mem[i-1] + mem[i-2];
	    }
	    return mem[n-1];
	}
	

	//solution3: use recursion
	/*
	 * Why using recursion is not good?
	 * Because the recursion will create a lot of variables of res.
	 * */
	public static int climbStairsIII(int n) {
		int res =0;
	    if(n == 1 ) res =1;
	    if(n == 2) res=2;
	    if (n>2) {
	    	return climbStairsII(n-1)+ climbStairsII(n-2);
	    }
	    return res;
	}
	
	
	public static void main(String[] args) {
		//testing
		System.out.println(climbStairsI(0));
		System.out.println(climbStairsI(1));
		System.out.println(climbStairsI(2));
		System.out.println(climbStairsI(3));
		System.out.println(climbStairsI(4));
		System.out.println("testing in the climb stairs");
		
		//testing
		System.out.println(climbStairsIII(0));
		System.out.println(climbStairsIII(1));
		System.out.println(climbStairsIII(2));
		System.out.println(climbStairsIII(3));
		System.out.println(climbStairsIII(4));
	}
}
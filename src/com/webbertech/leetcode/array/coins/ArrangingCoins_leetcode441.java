package com.webbertech.leetcode.array.coins;
/*
Leetcode 441

You have a total of n coins that you want to form in a staircase shape, 
where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:

x
xx
xx

Because the 3rd row is incomplete, we return 2.

Example 2:

n = 8

The coins can form the following rows:

x
xx
xxx
xx

Because the 4th row is incomplete, we return 3.
*/

class Solution {
    public static int arrangeCoins(int n) {
        if (n==1 || n ==0) {
            return n;
        }
            
        int sum = 0;
        int i=1;
        
        // n =3, 3> 1, sum = 1; 3-1>= 2, sum = 3
    	for (; n-sum >= i;i++) {
    		sum += i;
        }
    	return i-1;
    }
    
    public static void main(String[] args) {
    	System.out.println(arrangeCoins(5));
    }
}
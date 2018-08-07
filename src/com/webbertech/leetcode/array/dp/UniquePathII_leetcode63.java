package com.webbertech.leetcode.array.backtracking;

/*
 * Leetcode 63 Unique Path II (dp question -- a little hard)
 *  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	The robot can only move either down or right at any point in time. The robot is trying to reach 
	the bottom-right corner of the grid (marked 'Finish' in the diagram below).
   
    Now consider if some obstacles are added to the grids. How many unique paths would there be?
    
    An obstacle and empty space is marked as 1 and 0 respectively in the grid.

	Note: m and n will be at most 100.

	Example 1:

	Input:
	[
  		[0,0,0],
  		[0,1,0],
  		[0,0,0]
	]

	Output: 2
	Explanation:

	There is one obstacle in the middle of the 3x3 grid above.
	There are two ways to reach the bottom-right corner:
	
	1. Right -> Right -> Down -> Down
	2. Down -> Down -> Right -> Right
	
	Solution:
	
	The solution is that if there is already a 1 there, you either have to 
	replace its value with 0, and the rest of the solution is the same as 
	leetcode62 and leetcode64. Because it just means that that place has a 
	obstacle, and no way to go through it, that is why it is 0. The number
	next to the obstacle in the same row should inherit value from above it,
	or the value under the obstacle to inherit the value on the left of it.
	
	
	for example,
	[0,0,0],
  	[0,1,0],
  	[0,0,0]
  	
  	After process, it is gonna be,
  	
  	[1,1,1]
  	[1,0,1]
  	[1,1,2]
  	
  	Note that, the last 1 on the second row is from the 1 above it.
  	The second 1 in the third row is from the first 1 in the third row.
  	The last number in the third row is a sum of its left and above.
  	
  	Note that there are many corner cases:
  	
  	[[1]]
  	[[0,1]]
  	[[1,0]]
  	[[1][1][1]]
  	
  	solution: 
  	
  	It uses a one dimensional array to record the counts.
	
 * */

public class UniquePathII_leetcode63 {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
			int width = obstacleGrid[0].length;
		    int[] dp = new int[width];
		    dp[0] = 1;
		    for (int[] row : obstacleGrid) {
		        for (int j = 0; j < width; j++) {
		            if (row[j] == 1)
		                dp[j] = 0;
		            else if (j > 0)
		                dp[j] += dp[j - 1];
		        }
		    }
		    return dp[width - 1];
    }

	public static void main(String[] args) {
		int[][] a = {{0,0,0},{0,1,0},{0,0,0}}; //2
		int[][] b = {{0,0},{1,0}}; //1
		int[][] c = {{0}};  //1
		int[][] d = {{1,0},{0,0}};  //0
		int[][] e = {{0},{1}}; //0
		System.out.println(uniquePathsWithObstacles(a));
		System.out.println(uniquePathsWithObstacles(b));
		System.out.println(uniquePathsWithObstacles(c));
		System.out.println(uniquePathsWithObstacles(d));
		System.out.println(uniquePathsWithObstacles(e));
	}
}

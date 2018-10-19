package com.webbertech.leetcode.array.dp;

/*
 * Leetcode 62 (DP question)
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
   The robot can only move either down or right at any point in time. 
   The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
   How many possible unique paths are there?
   
   Note: m and n will be at most 100.
   
   Example 1:

   Input: m = 3, n = 2
   Output: 3

   Explanation:

   From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:

   1. Right -> Right -> Down
   2. Right -> Down -> Right
   3. Down -> Right -> Right

   Example 2:
   Input: m = 7, n = 3
   Output: 28
   
   Solution: 
   This solution is exactly the same as the leetcode 64 mininum path sum questions.
   In that question, the solution is to add them up, and in this question it is to mark 
   the must-pass cell with 1.
   
   Assumption:
   
   When (n==0||m==0) the function always returns 1 since the robot can't go left or up.
	
	For all other cells. The result = uniquePaths(m-1,n)+uniquePaths(m,n-1)

   1/ Use masking tech 1 and 0 to mark the matrix
   2/ Think for a sec, like solution to leetcode64, mark the first row and first column as 1.
       because result = uniquePaths(m-1,n)+uniquePaths(m,n-1)
   3/ Starting from [1,1] and the value of the m[1,1] = m[0,1] + m[1,0],
      so for 7 by 3 matrix it looks like,
      
      1 1 1  1  1  1  1
      1 2 3  4  5  6  7
      1 3 6 10 15 21 28
 * */

public class UniquePath_leetcode62 {

	 public int uniquePaths(int m, int n) {
	        Integer[][] map = new Integer[m][n];
	        for(int i = 0; i<m;i++) {
	            map[i][0] = 1;
	        }
	        for(int j= 0;j<n;j++) {
	            map[0][j]=1;
	        }
	        // Use the map[i][j] to store the value of the element on map[i-1][j] and map[i][j-1];
	        for(int i = 1;i<m;i++) {
	            for(int j = 1;j<n;j++) {
	                map[i][j] = map[i-1][j]+map[i][j-1];
	            }
	        }
	        // Finally the one in the right corner is the final result
	        return map[m-1][n-1];
	    }
}

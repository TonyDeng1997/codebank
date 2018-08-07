package com.webbertech.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Leetcode 64
 * 
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes 
 * the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]

Output: 7
Explanation: Because the path 1¡ú3¡ú1¡ú1¡ú1 minimizes the sum.

 *
 * the idea is very very simple, it is trying to accumulate
 * the numbers in first row and colon, and start from [1,1]
 * and go through the submatrix and try to accumulate the number
 * row by row and column by column, the the last element in the right
 * bottom of the whole matrix is the smallest one.
 */

public class MininumPathSum_leetcode64 {
	
 	public static int minPathSum(int[][] grid) {
 			// simply adds up the first row, note that it iterate from 1, so it is i-1
	        for (int i = 1; i < grid[0].length; i++) {
	            grid[0][i] += grid[0][i - 1];
	        }
	        // simple adds up the first column, note that it iterate from 1, so it is i-1
	        for (int i = 1; i < grid.length; i++) {
	            grid[i][0] += grid[i-1][0];
	        }
	        for (int row = 1; row < grid.length; row++) {
	            for (int col = 1; col < grid[0].length; col++) {
	            	/*
	            	 * The core algorithm is here, to understand it, 
	            	 * read the 1,1 element,
	            	 * in the following example, it adds up the current
	            	 * number with the smaller one of its up and left.
	            	 * 
	            	 * 1 4 5
	            	 * 2 5 1 
	            	 * 6 2 1
	            	 * 
	            	 * the idea is very very simple, it is trying to accumulate
	            	 * the numbers in first row and colon, and start from [1,1]
	            	 * and go through the submatrix and try to accumulate the number
	            	 * row by row and column by column, the the last element in the right
	            	 * bottom of the whole matrix is the smallest one.
	            	 * 
	            	 * */
	                grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
	            }
	        }
	        return grid[grid.length - 1][grid[0].length - 1];
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,3,1}, {1,5,1}, {4,2,1}};
		System.out.println(minPathSum(a));
	}
}

package com.webbertech.leetcode.matrix;

/*
 *  74. Leetcode Search a 2D Matrix
 *  Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

For example, Consider the following matrix:
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true. 
 * 
 * 
 * Solution: 
 * 1/ first binary search in the first column
 * 2/ binary search in the row
 * */

public class Search2DMatrix_leetcode74 {

	 public static boolean searchMatrix(int[][] matrix, int target) {
	        if (matrix.length ==0 || matrix[0].length==0) return false;
	        if (matrix.length == 1 && matrix[0].length == 1) {
	        	return target ==matrix[0][0];
	        }
	        int row_low = 0;
	        int row_high = matrix.length-1;
	        int mid =0;
	        
	        while(row_low<=row_high) {              //it must be less or equal
	              mid = (row_low+row_high)/2;
	            if (target == matrix[mid][0]) {
	                return true;
	            }
	            if (target>matrix[mid][0]) {
	                row_low= mid+1;
	            } else {
	                row_high=mid-1;
	            }
	        }
	        
	        /* for the last iteration,if the target is not the 
	         * first element of the target row, then mid was 
	         * incremented 1, so here we decrement 1, but we do not want 
	           it below 0
	         */
	        if (matrix[mid][0]>target && mid!=0) 
	        	mid--;
	        
	        //mid now is the row that contains the number
	        int col_low = 0;
	        int col_high = matrix[0].length-1;
	        int row_number= mid;
	        int mid1=0;
	        while(col_low<=col_high) {
	              mid1 = (col_low+col_high)/2;
	             if (target == matrix[row_number][mid1]) {
	                return true;
	             } 
	             if (target > matrix[row_number][mid1]) {
	                 col_low = mid1+1;
	             } else {
	                 col_high = mid1-1;
	             }
	        }
	        return false;
	 }
	 
	 public static void main(String[] args) {
		 //int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		 //int[][] matrix = {{1}};
		 int[][] matrix = {{1,1}};
		 System.out.println(searchMatrix(matrix,0));
	 }
}
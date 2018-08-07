package com.webbertech.crackCodingInterview;

/* P407
 * Given an M by N matrix, which each row and each column is sorted in ascending order,
 * write a method to find an element. 
 * 
 * Solution 1:  O(mlogn) 
 *  
 * Solution 2: 
 *    15 20 40 85
 *    20 35 80 95
 *    30 55 95 105
 *    40 80 100 120
 *      
 *    For example: look for 55, two rules here:
 *    
 *    1/ if the first element of a column is larger than the x,
 *       then column = column -1,
 *    2/ if the last element of a row is less than x, then row = row+1
 * 
 * 
 *  P410
 *  Solution 3: partition the matrix into four quadrants,
 *  in the diagonal, it is sorted, and we can use binary search.
 *  Once you find element is between two diagonal elements, then 
 *  you can see which partition it is in. //TODO revisit
 *   
 *     
 * */
public class SortedMatrixSearch {

	 //solution 2
	static boolean findElement(int[][] matrix, int elem) {
		int row = 0; 
		int col = matrix[0].length -1;
		
		while (row<matrix.length && col>=0) {
			if (matrix[row][col] == elem) {
				return true;
			} else if (matrix[row][col] > elem) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] data = {
				      {15, 20, 40, 85},
				      {20, 35, 80, 95},
				      {30, 55, 95, 105},
				      {40, 80, 100, 120}
				      };
		System.out.println(findElement(data, 55));
	}
}

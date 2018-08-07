package com.webbertech.leetcode.matrix;

/*
 * Leetcode 73 Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 *
 *
 *solution: 
 *
 *1/ O(mn) is bad
 *2/ O(m+n) is better still bad

The idea of setting row and cols to all zero when detect the index of i,j is wrong.
Because this will ends up filling the whole matrix all 0.

The following solution works like this,

    1.
     fr = first row
     fc = first col
     Use first row and first column as markers. 
    
    2. if matrix[i][j] = 0, mark respected row and col marker = 0; indicating
       that later this respective row and col must be marked 0;
       And because you are altering first row and column, 
       you need to  have two variables to track their own status. 
       So, for ex, if any one of the first row is 0, fr = 0, 
       and at the end set all first row to 0 and first column.
    
    3. set first row and first col to 0
        
       The algorithm is N(n^2)
 * */

public class SetMatrixZeros_leetcode73 {
	public void setZeroes(int[][] matrix) {
	    boolean fr = false,fc = false;
	    
	    for(int i = 0; i < matrix.length; i++) {
	        for(int j = 0; j < matrix[0].length; j++) {
	            if(matrix[i][j] == 0) {
	                if(i == 0) fr = true;
	                if(j == 0) fc = true;
	        	    //mark the first row and first column element to 0
	                //reset first row and first column in the final step
	                matrix[0][j] = 0;
	                matrix[i][0] = 0;
	            }
	        }
	    }
	    
	    
	    // For the submatrix, besides the first row and first col.
	    //if the first row or first col element is zero, set it to zero
	    for(int i = 1; i < matrix.length; i++) {
	        for(int j = 1; j < matrix[0].length; j++) {
	            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
	                matrix[i][j] = 0;
	            }
	        }
	    }
	    
	    //set first row to all zero
	    if(fr) {
	        for(int j = 0; j < matrix[0].length; j++) {
	            matrix[0][j] = 0;
	        }
	    }
	    
	    //set first col to all zero
	    if(fc) {
	        for(int i = 0; i < matrix.length; i++) {
	            matrix[i][0] = 0;
	        }
	    }
	}
	    
	    public static void main(String[] args) {
	    	
	    }
}
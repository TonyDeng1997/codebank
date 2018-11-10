package com.webbertech.leetcode.matrix;

/*
 * Leetcode 566. Reshape matrix. 
 * 
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a 
 * matrix into a new one with different size but keep its original data.
You're given a matrix represented by a two-dimensional array, and two positive 
integers r and c representing the row number and column number of the wanted reshaped 
matrix, respectively. The reshaped matrix need to be filled with all the elements of 
the original matrix in the same row-traversing order as they were.
If the 'reshape' operation with given parameters is possible and legal, 
output the new reshaped matrix; Otherwise, output the original matrix. 
 
Input: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4

Output: 
[[1,2,3,4]]

Explanation:
The row-traversing of nums is [1,2,3,4]. 
The new reshaped matrix is a 1 * 4 matrix, fill it row by row by 
using the previous list.

Input: 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
Output: 
[[1,2],
 [3,4]]

Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. 
So output the original matrix.

Note:
The height and width of the given matrix is in range [1, 100].
The given r and c are all positive.

Solution: try to understand the two lines of code.

Use a good example in solving this problem, for example,

[[1,2,3], [4,5,6]] is a 2*3 matrix, change it to,

[[1,2], [3,4], [5,6]]
*/

public class ReshapeMatrix_leetcode566 {

	 // O(nm)
	public int[][] matrixReshape(int[][] nums, int r, int c) {
	    int n = nums.length, m = nums[0].length;
	    if (r*c != n*m) return nums;
	    int[][] res = new int[r][c];
	    // core logic in two lines
	    /*
	     *  using the above example, what matter is the c and m, which are column number.
	     *  
	     *  (0/2, 0%2) <- (0/3, 0%3)
	     *  (1/2, 1%2) <- (1/3, 1%3)
	     *  (2/2, 2%2) <- (2/3, 2%3)
	     *  
	     *  consider r*c as one dimensional array, then 
	     *  the new array's row index is decided by i/c.
	     *  
	     * */
	    for (int i=0;i<r*c;i++) { 
	        res[i/c][i%c] = nums[i/m][i%m];
	    }
	    return res;
	}
	
}

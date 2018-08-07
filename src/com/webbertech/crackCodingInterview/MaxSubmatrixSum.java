package com.webbertech.crackCodingInterview;

/*P611 
 * Max submatrix. Given an n by n matrix of positive and negative integers,
   write code to find the submatrix with the largest possible sum.
*/
public class MaxSubmatrixSum {

/*solution: O(n^3)
 * 
 * The submatrix can be non-square matrix.
 * This solution is similar to find the largest sum of an array. For largest sum in an array we can do it in O(N)
 * 
 * There is a O(n^4) solution using a dynamic programming solution. This needs to be revisited 
 * */
	public class SubMatrix {
	    //think about row1, col1 is the coordinate of the top left corner
		//row2, col2 is the coordinate of the bottom right corner
		private int row1, row2, col1, col2, sum;
		public SubMatrix(int r1, int c1, int r2, int c2, int sum) {
			this.row1 = r1;
			this.row2 = r2;
			this.col1 = c1;
			this.col2 = c2;
			this.sum = sum;
		}
		
		public int getSum() {
			return sum;
		}
	}
	
    class Range {
    	public int start, end, sum;
    	public Range(int start, int end, int sum) {
    		this.start = start;
    		this.end = end;
    		this.sum = sum;
    	}
    }
    
    SubMatrix getMaxMatrix(int[][] matrix) {
    	int rowCount = matrix.length;
    	int colCount = matrix[0].length;
    	SubMatrix best = null;
    	
    	//
    	for (int rowStart = 0; rowStart < rowCount ; rowStart++) {
    		int[] partialSum = new int[colCount];
    		
    		//get each row's sum, and update the max for best, and add up other rows below it, and keep updating best
    		for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
    			 //add all values at row rowEnd
    			 for (int i =0;i<colCount;i++) {
    				 partialSum[i] += matrix[rowEnd][i];
    			 }
    			 
    			 Range bestRange = maxSubArray(partialSum, colCount);
    			 if (best == null|| best.getSum() < bestRange.sum) {
    				 best = new SubMatrix(rowStart, bestRange.start, rowEnd, bestRange.end, bestRange.sum);
    			 }
    		 }
    	}
    	return best;
    }
    
    
    //get the max sum plus the start and end of the "sum array of all the N columns"
    // this is similar to max sum of an array problem
    Range maxSubArray(int[] array, int N) {
    	Range best = null;
    	int start =0;
    	int sum=0;
    	
    	for (int i=0;i< N;i++) {
    		sum += array[i];
    		if (best == null || sum > best.sum) {
    			best = new Range(start, i, sum);
    		}
    		
    		/*If running_sum is < 0 no point in trying to continue the series. reset */
    		
    		if (sum < 0) {
    			start = i+1;
    			sum = 0;
    		}
    	}
    	
    	return best;
    }
    
	
	
	public static void main(String[] args) {
		MaxSubmatrixSum maxSum = new MaxSubmatrixSum();
		int[][] matrix = {{9,-8,1,3,-2}, 
				          {-3,7, 6, -2, 4},
				          {6,-4, -4, 8, -7}
				          };
		
		int[][] matrix2 = {{9,-8,1}, 
		          {-3,7, 6},
		          {6,-4, -4, }
		          };
		SubMatrix obj = maxSum.getMaxMatrix(matrix);
	}
}

package com.webbertech.crackCodingInterview;

/*P611 Max submatrix. Given an n by n matrix of positive and negative integers,
write code to find the submatrix with the largest possible sum.
*/
public class MaxSubmatrixSum2 {

/*solution1: O(n^6)
 * The submatrix can be non-square matrix
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
	
	//very simple O(n^2), and think about row1,col1 is the left top corner,
	// row2, col2 is the bottom right corner
	int sum(int[][] matrix, int row1, int col1, int row2, int col2) {
		int sum =0;
		for (int r = row1; r<=row2; r++) {
			for (int c = col1; c<=col2;c++) {
				sum += matrix[r][c];
			}
		}
		return sum;
	}
	
	//obvious 4 nested for loops, and inside there are 2 nested for loop, so O(n^6)
	SubMatrix getMaxMatrix(int[][] matrix) {
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;
		SubMatrix best = null;
		
		//submatrix is not necessarily square
		//row2 = row1, and col2 = col1 is to make sure that the end point of the 
		//bottom right corner does not go to the left of the top left corner
		for (int row1 =0; row1< rowCount;row1++) {
			for (int row2=row1;row2<rowCount;row2++) {
				for (int col1=0; col1< columnCount; col1++) {
					for (int col2= col1; col2< columnCount; col2++) {
						int sum = sum(matrix, row1, col1, row2, col2);
						if (best== null || best.getSum() < sum) {
							best = new SubMatrix(row1, col1, row2, col2, sum);
						}
					}
				}
			}
		}
		return best;
	} 
	
	
	public static void main(String[] args) {
		MaxSubmatrixSum2 maxSum = new MaxSubmatrixSum2();
		int[][] matrix = {{1,2}, {4,5}};
		SubMatrix obj = maxSum.getMaxMatrix(matrix);
	}
}

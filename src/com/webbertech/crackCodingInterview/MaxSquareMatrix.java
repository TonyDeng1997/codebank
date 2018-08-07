package com.webbertech.crackCodingInterview;

/*
 * P608
 * 
 * Imagine you have a square matrix, where each cell(pixels) is either black or white.
 * Design an algorithm to find the maximum subsquare such that all four border
 * are filled with black pixels.
 * 
 * solution 1: O(n^4)
 * 
 *  go from the left top corner, and increase the subsquare matrix length by 1, 2, ..matrix.length
 *  
 * */

public class MaxSquareMatrix {

	class Subsquare {
		int row;
		int col;
		int squareSize;
		
		Subsquare(int row, int col, int squareSize) {
			this.row = row;
			this.col = col;
			this.squareSize = squareSize;
		}
	}
	
	Subsquare findSquare(int[][] matrix) {
		for (int i= matrix.length ; i >= 1;i-- ) {
			Subsquare square = findSquareWithSize(matrix, i);
			if (square != null) return square;
		}
		return null;
	}
	
	
	//let us say 1 is white
	boolean isSquare(int[][] matrix, int row, int col, int size) {
		//test first row and last row are all black
		for (int i=0;i< size;i++) {
			 if (matrix[row][col+i] == 1) {
				 return false;
			 }
		}
		
		//test last row
		for (int i=0;i<size;i++) {
			 if (matrix[row+size][col+i] == 1) {
				 return false;
			 }
		}
		
		//test first column and last column are all black
		for (int i=0;i<size;i++) {
			if (matrix[row+i][col] == 1)
				return false;
		}
		
		for (int i=0;i<size;i++) {
			if (matrix[row+i][col+size] == 1)
				return false;
		}
		
		return true;
	}
	
	
	//size is increased from 1 to matrix.length
	//the two for loop row, col coordinate defines the left top corner
	//of the submatrix, the size is the submatrix's size
	Subsquare findSquareWithSize(int[][] matrix, int size) {
		int count = matrix.length - size + 1;
		for (int row=0; row< count;row++) {
			for (int col =0;col< count;col++) {
				if (isSquare(matrix, row, col, size)) {
	                return new Subsquare(row, col, size);				
				}
			}
		}
		
		return null;
	}
	
	/*solution 2:
	 * Almost the same as above but preprocess the matrix to make 
	 * isSquare to O(1). The whole time will be O(n^3).
	 * 
	 *   Make a new class called SquareCell {}
	 */
	
	  class SquareCell {
		  public int zerosRight = 0;
		  public int zerosBelow = 0;
		  
		  public SquareCell(int zerosRight, int zerosBelow) {
			  this.zerosRight = zerosRight;
			  this.zerosBelow = zerosBelow;
		  }
	  }

    /*
     * The processSquare process the original array from right to left,
     * from row  matrix.length-1 to row 0. Each cell object will retain 
     * the information of right and below fields, which will tell you
     * important information about the matrix, submatrix..etc.
     * 
     *  For any matrix/submatrix, you only need to check 
     *  top left, top right, and bottom left, these three cells objects.
     *  
     *  Why not bottom right? because it does not have right info and it 
     *  does not have below info.
     *  
     *  The core idea is here: iterate from right to left, bottom to top.
     *  
     *  example: original matrix is:
     *  
     *  W B W
     *  B B W
     *  B B W
     *  
     *  the processed matrix is:
     *  
     *  0,0  1,3  0,0
     *  2,2  1,2  0,0
     *  2,1  1,1  0,0
     * */	  
	  SquareCell[][] processSquare(int[][] matrix) {
		  SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];
		  
		  for (int r = matrix.length -1;r>=0;r--) {
			  for (int c = matrix.length -1;c>=0;c--) {
				  int rightZeros =0;
				  int belowZeros =0;
				  /*only need to process if it is a black cell,
				   * in the original matrix, the white is 1 and the black is 0
				  */
				  if (matrix[r][c] == 0) {
					  rightZeros++;
					  belowZeros++;
					  //next column over is on the same row
					  if (c+1 < matrix.length) {
						  SquareCell previous = processed[r][c+1];
						  rightZeros += previous.zerosRight;
					  }
					  if (r+1<matrix.length) {
						  SquareCell previous = processed[r+1][c];
						  belowZeros += previous.zerosBelow;
					  }
				  }
				  processed[r][c] = new SquareCell(rightZeros, belowZeros);
			  }
		  }
		  return processed;
	  }
	
	  Subsquare findSquare1(int[][] matrix) {
		  SquareCell[][] processed = processSquare(matrix); //O(n^2)
		  //the following are the O(n^3) and it is the same as the previous findSquare(..)
		  for(int i=matrix.length; i>=1;i--) {
			  Subsquare square = findSquareWithSize1(processed, i);
			  if (square!=null)
				  return square;
		  }
		  return null;
	  }
	
	  //the following are almost the same
	  public Subsquare findSquareWithSize1(SquareCell[][] processed,int i) {
		  return null;
	  }
}

package com.webbertech.leetcode.matrix;

//first assume you have a square matrix, n by n
/*
1 2
3 4

will become 3 1
            4 2 


solution: 1/transpose the matrix, this is good for n by n and n by m
          2/ reverse the order of each row
          
*/

public class RotateMatrixNinetyDegree {
        public static int[][] rotateMatrixNinetyDegree (int[][] matrix) {
         	int rows = matrix.length;
         	
         	int[][] newMatrix = transposeMatrix(matrix);
        	//reverse all the rows
        	for(int i=0;i<newMatrix.length;i++) {
        		newMatrix[i]= reverseRow(newMatrix[i]);
        	}
        	return newMatrix;
        }	
        
        
        //j starts from 0 not 1, because it is a new matrix
        //new matrix is used because its dimension is different
        public static int[][] transposeMatrix(int[][] matrix) {
        	int cols = matrix[0].length;
        	int rows = matrix.length;
           
        	int[][] newMatrix = new int[cols][rows];
        	
        	//use a in-place replacement, don't use extra spaces
    
        		for(int i=0;i<rows;i++)
              	  for (int j=0;j<cols;j++) {
                     newMatrix[j][i] = matrix[i][j];
              	  }   
        		
        	 return newMatrix;
        
        }
        
        public static int[] reverseRow(int[] row) {
           for(int i=0,j=row.length-1;i<row.length/2;i++,j--) {
        	   int temp = row[i];
        	   row[i] = row[j];
        	   row[j] = temp;
           }   	
           return row;
        }
        
        public static void main(String[] args) {
        	int[][] matrix = {{1,2},{3,4},{5,6}};
        	
        	int[][] newMatrix = RotateMatrixNinetyDegree.rotateMatrixNinetyDegree(matrix);
        	
            for(int i=0;i<newMatrix.length;i++) {
          	  for (int j=0;j<newMatrix[0].length;j++) {
          	     System.out.print(newMatrix[i][j]);
          	  }
          	  
          	  System.out.println();
          	}
          
        	
        	
        	/*
        	 * unit testing
        	 * 
           int[][] newMatrix = RotateMatrixNinetyDegree.transposeMatrix(matrix);
        	
            for(int i=0;i<matrix.length;i++) {
            	  for (int j=0;j<matrix[0].length;j++) {
            	     System.out.print(newMatrix[i][j] + " ");
            	  }
            	  System.out.println();
            	}
            */
        	
            /*
        	int[] row={1,2,3,4};
        	int[] newRow = RotateMatrixNinetyDegree.reverseRow(row);
        	for(int i=0;i<row.length;i++) {
        		System.out.println(newRow[i]);
        	}
        	*/
           }

}
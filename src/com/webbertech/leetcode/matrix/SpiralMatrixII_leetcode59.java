package com.webbertech.leetcode.matrix;

/*
Leetcode 59. Spiral Matrix II

Given an integer n, generate a square matrix filled with 
elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
* 
* 
* Accepted
* */

public class SpiralMatrixII_leetcode59 {
	 public static int[][] generateMatrix(int n) {
	    int rowStart =0, colStart =0, rowEnd=n-1, colEnd=n-1;
	    int[][] matrix = new int[n][n];
	
	    while(rowStart<=rowEnd && colStart<=colEnd) {  //this logic is import
	    	//travel right
	    	for(int i=colStart;i<=colEnd;i++) {
	    		if (i == 0)
	    		    matrix[rowStart][i] = 1; 
	    		else {
	    			matrix[rowStart][i]=matrix[rowStart][i-1]+1; //this logic is incremented by one, is important
	    		}
	    	}
	    	rowStart++;
	    	//travel down
	    	int j =1;
	    	for(int i=rowStart;i<=rowEnd;i++) {
	    		matrix[i][colEnd]=matrix[rowStart-1][colEnd]+j;
	    		j++;
	    	}
	    	colEnd--;
	    	//travel left
	    	j =1;
	    	for(int i=colEnd;i>=colStart;i--) {
	    		matrix[rowEnd][i]=matrix[rowEnd][colEnd+1]+j;
	    		j++;
	    	}
	    	rowEnd--;
	        //travel up
	    	j=1;
	    	for(int i=rowEnd;i>=rowStart;i--) {
	    		matrix[i][colStart] = matrix[rowEnd+1][colStart]+j;
	    		j++;
	    	}
	    	colStart++;
	    }
	    return matrix;
	 }
	 
	 public static void main(String[] args) {
		 int[][] matrix = generateMatrix(3);
	 }
}

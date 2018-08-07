package com.webbertech.crackCodingInterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {

	//https://en.wikipedia.org/wiki/Sudoku
	//9 by 9, 9 submatrix
	//the same single integer may not appear twice in the same row,
	//column or in any of the nine 3¡Á3 subregions of the 

	
	//can be used for checking row or cols
	static boolean isDuplicated(Integer[] array) {
	   Set<Integer> set = new HashSet<>();	
	   for(int i=0; i<array.length;i++) {
		   set.add(array[i]);
	   }
	   if(set.size()<9) { 
		   return true;
	   } else {
		   return false;
	   }
	}
	
	
	static Integer[][] transposeMatrix(Integer[][] sodoku, int rows, int cols) {
		Integer[][] newArray = new Integer[rows][cols];
		for(int i=0;i<rows ;i++) {
			for (int j=0;j<cols;j++) {
				newArray[i][j] = sodoku[j][i];
			}
		}
		return newArray;
	}

	
	static boolean isRowDuplicate(Integer[][] sodoku) {
		//check row by row
				for (int i=0;i<9;i++) {
					if (isDuplicated(sodoku[i])) {
						return true;
					}
				}
		return false;
	}
	
	
	//x, y is the left corner index
	static boolean isSubmatrixValid(Integer[][] sodoku, int x, int y) {
		ArrayList<Integer> submatrixArray = new ArrayList<>();
		for(int i=x;i<x+3;i++) {
			for(int j=y;j<y+3;j++) {
				submatrixArray.add(sodoku[i][j]);
			}
		}
		Integer data[] = (Integer[])submatrixArray.toArray(new Integer[submatrixArray.size()] );
		return !isDuplicated(data);
	} 
	
	
	public static boolean isValidSudoku(Integer[][] sodoku) {
		if (isRowDuplicate(sodoku)) {
			return false;
		}
		
		transposeMatrix(sodoku, 9,9);
		
		if (isRowDuplicate(sodoku)) {
			return false;
		}
		
		//check this logic
		for(int i=0;i<9;i+=3) {
			for (int j=0;j<9;j+=3) {
				if (!isSubmatrixValid(sodoku,i,j)) {
					return false;
				}
			}
		}
		
		return true;
    }
	
	public static void main(String[] args) {
		Integer validSudoku[][] = {
				{5,3,4,6,7,8,9,1,2},
				{6,7,2,1,9,5,3,4,8},
				{1,9,8,3,4,2,5,6,7},
				{8,5,9,7,6,1,4,2,3},
				{4,2,6,8,5,3,7,9,1},
				{7,1,3,9,2,4,8,5,6},
				{9,6,1,5,3,7,2,8,4},
				{2,8,7,4,1,9,6,3,5},
				{3,4,5,2,8,6,1,7,9} 
		};
		
		Integer invalidSudoku[][] = {
				{5,3,4,6,7,8,9,1,1},
				{6,7,2,1,9,5,3,4,8},
				{1,9,8,3,4,2,5,6,7},
				{8,5,9,7,6,1,4,2,3},
				{4,2,6,8,5,3,7,9,1},
				{7,1,3,9,2,4,8,5,6},
				{9,6,1,5,3,7,2,8,4},
				{2,8,7,4,1,9,6,3,5},
				{3,4,5,2,8,6,1,7,9} 
		};
		
		System.out.println(isValidSudoku(validSudoku));
		System.out.println(isValidSudoku(invalidSudoku));
		
		System.out.println("The followings are random testing");
		
		Integer[][] small = {{1,2,3},{4,5,6},{7,8,9}};
		Integer[][] transposed = transposeMatrix(small, 3,3);
		   
		   for(int i=0;i<3;i++) {
			   for(int j=0;j<3;j++) {
				   System.out.print(transposed[i][j] + " ");
			   }
			   System.out.println();
		   }
		   
		System.out.println(isSubmatrixValid(small,0,0));
	}
}

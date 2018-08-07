package com.webbertech.leetcode.matrix;
import java.util.HashSet;

/*leetcode36 variation
 * validate sudoku.
 * */
public class ValidSudoku_leetcode36 {
   
	static boolean validRowAndColumn(char[] row) {
		HashSet<Character> set= new HashSet<>();
		for(int i=0;i<row.length;i++) {
			set.add(row[i]);
		}
		return set.size()== row.length;
	}
	

	static void transpose(char[][] board) {
		if (board.length!=board[0].length)
			return;
		for(int i=0; i<board.length;i++) {
		 	for(int j=0;j<board.length;j++) {
		 		board[i][j] = board[j][i];		
			}
		}
	}
	
	static boolean validSubMatrix(char[][] board, int x, int y) {
		HashSet<Character> set = new HashSet<>();
	       //check submatrix
	       for(int i=x;i<x+3;i++) {
	    	   for (int j=y;j<y+3;j++) {
	    		   set.add(board[i][j]);
	    	   }
	       }	
	       return set.size() == 9;
	}
	
	public static boolean isValidSudoku(char[][] board) {
       int rows =board.length;    
       int cols =board[0].length;
       //check columns
       for(int i=0;i< rows;i++) {
    	   if (!validRowAndColumn(board[i])) {
    		   return false;
    	   }
       }
       
       transpose(board);
       
       //check columns
       for(int i=0;i< rows;i++) {
    	   if (!validRowAndColumn(board[i])) {
    		   return false;
    	   }
       }
       
       for(int i=0;i<rows;i=i+3) {
    	  for (int j=0;j<cols;j=j+3) {
    		  if (!validSubMatrix(board, i, j)) {
    	    	   return false;
    	       }	  
    	  } 
       }
       
       return true;
    }
}

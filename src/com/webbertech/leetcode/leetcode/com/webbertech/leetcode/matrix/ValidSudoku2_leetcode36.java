package com.webbertech.leetcode.matrix;
import java.util.HashSet;

/* leetcode 36. Sudoku is a game with 9 by 9 board, every row, column and 
 * submatrix can not have dups. Determine if a Sudoku is valid, according to: 
 * Sudoku Puzzles - The Rules.
   The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * */
public class ValidSudoku2_leetcode36 {
	static boolean dupInRow(char[] row) {
		HashSet<Character> set = new HashSet<>();
		for (char c: row) {
			if (set.contains(c) && c != '.') {
				return true;
			}
			set.add(c);
		}
		return false;
	}
	
	static boolean dupInSubMaxtrix(char[][] board, int x, int y) {
		HashSet<Character> set = new HashSet<>();
		for (int i=x;i<x+3;i++) {
			for (int j=y;j<y+3;j++) {
				if (set.contains(board[i][j]) && board[i][j]!='.') {
					return true;
				}
				set.add(board[i][j]);
			}
		}
		return false;
	}
	
	public static boolean isValidSudoku(char[][] board) {
		//check rows
       for (int i=0;i< board.length;i++) {
    	   if (dupInRow(board[i])) {
    		  System.out.println("debugging1");
    		   return false;
    	   }
       }
       
       char[][] transposed = new char[board.length][board[0].length];
       //transpose matrix and check col
       for (int i=0;i<board.length;i++) {
    	   for(int j=0;j<board[0].length;j++) {
    		   transposed[i][j] = board[j][i];
    	   }
       }
       
     
       //check cols
       for (int i=0;i< transposed.length;i++) {
    	   if (dupInRow(transposed[i])) {
    		   System.out.println("debugging2");
    		   System.out.println(i);
    		   return false;
    	   }
       }
       
       //check submatrix
       for (int i=0;i<board.length;i+=3) {
    	   for (int j=0;j<board[0].length;j+=3) {
    		   if (dupInSubMaxtrix(board,i,j)) {
    			   System.out.println("debugging3");
    			   return false;
    		   }
    	   }
       }
       return true;
	}       
	
	public static void main(String[] args) {
		char[][] board = {
				{'.','.','5','.','.','.','.','.','6'},
				{'.','.','.','.','1','4','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','9','2','.','.'},
				{'5','.','.','.','.','2','.','.','.'},
				{'.','.','.','.','.','.','.','3','.'},
				{'.','.','.','5','4','.','.','.','.'},
				{'3','.','.','.','.','.','4','2','.'},
				{'.','.','.','2','7','.','6','.','.'}
		};
		
		char[][] board1 = { 
				  {'.','.','.','.','5','.','.','1','.'},
				  {'.','4','.','3','.','.','.','.','.'},
				  {'.','.','.','.','.','3','.','.','1'},
				  {'8','.','.','.','.','.','.','2','.'},
				  {'.','.','2','.','7','.','.','.','.'},
				  {'.','1','5','.','.','.','.','.','.'},
				  {'.','.','.','.','.','2','.','.','.'},
				  {'.','2','.','9','.','.','.','.','.'},
				  {'.','.','4','.','.','.','.','.','.'}
				 };
		
		
		  /*
	        * Debugging
	        * 
	        * */
	       for (int i =0;i<board1.length;i++) {
	    	   for (int j=0;j<board1[0].length;j++) {
	    		   System.out.print(board1[i][j]+" ");
	    	   }
	    	   System.out.println();
	       }
	       
		System.out.println(isValidSudoku(board));
		
		System.out.println("testing submatrix");
		
		System.out.println(dupInSubMaxtrix(board1, 0,6));
	}
}
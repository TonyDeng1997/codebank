package com.webbertech.algorithm.game;

public class TicTacToe {

	       //3 by 3 board
	       //need to check row
	       //this is my version for the interview
	
	       private char[][] board;
	
	       public TicTacToe(char[][] board) {
	    	   //this.board = new char[3][3];
	    	   this.board = board;
	       }
	       
	       // Returns true if there is a win, false otherwise.
	       // This calls our other win check functions to check the entire board.
		    public boolean checkForWin() {
		        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
		    }

		    // Loop through rows and see if any are winners.
		    private boolean checkRowsForWin() {
		        for (int i = 0; i < 3; i++) {
		            if (checkRowCol(board[i][0], board[i][1], board[i][2]) ) {
		                return true;
		            }
		        }
		        return false;
		    }
		    
		    private boolean checkRowCol(char c1, char c2, char c3) {
		           return ((c1 == 'x') && (c1 == c2) && (c2 == c3));
		    }
		
		    // Loop through columns and see if any are winners.
		    private boolean checkColumnsForWin() {
		        for (int i = 0; i < 3; i++) {
		            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
		                return true;
		            }
		        }
		        return false;
		    }
	
		    // Check the two diagonals to see if either is a win. Return true if either wins.
		    private boolean checkDiagonalsForWin() {
		        return ((checkRowCol(board[0][0], board[1][1], board[2][2])) || 
		        		(checkRowCol(board[0][2], board[1][1], board[2][0])));
		    }
		    
		    public static void main(String[] args) {
		    	char[][] board = {{'x','x','x'},{'o','o','x'},{'x','o','x'}};
		    	TicTacToe game = new TicTacToe(board);
		    	
		    	System.out.println(game.checkForWin());
		    }
}

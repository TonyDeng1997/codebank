package com.webbertech.crackCodingInterview;

/*
 * P466, this is a tictactoe validator, not a solver
 * */

public class TicTacToeValidator1 {

	
 /*solution1: convert a board of winning state into a integer
  empty is 0, red is 1, and blue is 2. This implementation is incomplete
  */
	
	enum Piece {
		Empty, Red, Blue
	}
	
	Piece hasWon(int board) {
		return winnerHashTable(board);
	}
	
	//todo
	Piece winnerHashTable(int board) {
		return null;
	}
	
	int convertBoardToInt(Piece[][] board){
		int sum =0;
		for(int i=0;i< board.length;i++) {
			for (int j=0;j<board.length;j++) {
				int value = board[i][j].ordinal(); 
				
				//This 3 is a factor to amplify the sum to avoid collision 
				sum = sum * 3 + value;
			}
		}
		return sum;
	}

}

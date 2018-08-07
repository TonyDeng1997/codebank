package com.webbertech.crackCodingInterview;

public class TicTacToeValidator2 {

//P468
	
	enum Piece {
		Empty, Red, Blue
	}
	
	/*
	 * In this solution, we know the last move, try to revisit this
	 * */
	Piece hasWon(Piece[][] board, int row, int column) {
		if (board.length != board[0].length)
			return Piece.Empty;
		
		Piece piece = board[row][column];
		
		//the last move can not be empty
		if (piece == Piece.Empty) {
			return Piece.Empty;
		}
		
		if (hasWonRow(board, row) || hasWonColumn(board,column)) {
			return piece;
		}
		
		//in the middle of n by n
		if (row==column && hasWonDiagonal(board,1)) {
		   return piece;	
		}
		
		if (row == (board.length - column -1) && hasWonDiagonal(board, -1)) {
			return piece;
		}
		
		return piece;
		
	}
	
	boolean hasWonRow(Piece[][] board, int row) {
        return true;		
	}
	
	boolean hasWonColumn(Piece[][] board, int column) {
		return true;
	}
	
	boolean hasWonDiagonal(Piece[][] board, int direction) {
		return true;
	}
	
	
}


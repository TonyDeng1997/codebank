package com.webbertech.crackCodingInterview;

public class TicTacToeValidator3 {

//P468
//validate a 3 by 3 board to see if it is a winning tictactoe
//This is a much cleaner way to validate
	
	enum Piece {
		Empty, Red, Blue
	}
	
	boolean hasWinner(Piece p1, Piece p2, Piece p3) {
	  if (p1 == Piece.Empty)
		  return false;
	  else {
		  return p1 == p2 && p2 == p3;
	  }
	}
	
	Piece hasWon(Piece[][] board) {
		
		//check diaganal
		//return any one in this diagonal is fine
		if (hasWinner(board[0][0], board[1][1], board[2][2])) {
			return board[0][0];
		} 
		
		//return any one in this diagonal is fine
		if (hasWinner(board[0][2], board[1][1], board[2][0])) {
			return board[0][2];
		}
		
		//check rows
		for (int i=0;i<board.length;i++) {
			if (hasWinner(board[i][0], board[i][1], board[i][2])) {
				return board[i][0];
			}
		}
		
		//check columns
		for (int j=0;j<board.length;j++) {
			if (hasWinner(board[0][j], board[1][j], board[2][j])) {
				return board[0][j];
			}
		}
		
		return Piece.Empty;
	}
	
	public static void main(String[] args) {
		Piece[][] board = { {Piece.Red,Piece.Blue, Piece.Red},
							  {Piece.Red,Piece.Blue, Piece.Red},
							  {Piece.Blue,Piece.Blue, Piece.Empty}};
		
		System.out.println(new TicTacToeValidator3().hasWon(board).toString());
	}
}

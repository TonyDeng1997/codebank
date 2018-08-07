package com.webbertech.crackCodingInterview;

//P468
// This is a N by N tictactoe validator implementation, the drawback is that 
// there are many duplicate code
public class TicTacToeValidatorNN {
  
	enum Piece {
		Empty, Red, Blue
	}
	
	Piece hasWon(Piece[][] board) {
		int size = board.length;
		if (board[0].length != size) {
			return Piece.Empty;
		}
		
		//check rows
        for(int i=0;i<size;i++) {
        	Piece first = board[i][0];
        	if ( first == Piece.Empty) {
        		continue;
        	}
        	for (int j=0; j<board[0].length; j++) {
               		//other grid in the same row is empty
        		    if (board[i][j]!= first) {
               			break;
               		} else if (j == board[0].length - 1){
               			return first;
               		}
        	}
        }		
        
		//check cols
		for (int i=0; i<board[0].length;i++) {
			Piece first = board[0][i];
			if ( first == Piece.Empty) {
        		continue;
        	}
			
			for (int j=0; j<size; j++) {
           		//other grid in the same row is empty
    		   if (board[i][j]!= first) {
           			break;
           		} else if (j == size - 1){
           			return first;
           		}
    	    }
		}
		
		//check diagonal
		
		Piece first = board[0][0];
		if ( first != Piece.Empty ) {
    		for (int i=1;i<size;i++) {
					if (board[i][i] == first) {
						continue;
					} else {
						return Piece.Empty;
					}
			}
		}
		
		Piece firstA = board[0][size-1];
		if ( firstA != Piece.Empty ) {
    	
			for (int i=0;i<size;i++) {
					if (board[i][size-1-i] == first) {
						continue;
					} else {
						return Piece.Empty;
					}
			}
		
		}
		
		
		
        return Piece.Empty;
	}
}

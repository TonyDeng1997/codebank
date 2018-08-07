package com.webbertech.algorithm.game;


//recursion too, might have some problems
//http://smahesh.com/blog/2013/03/29/eight-queens-puzzle/

public class EightQueen1 {
	  public static void main(String args[]) {
	    int N = 8;
	    int[][] board = new int[N][N];
	    solve(0, board, N);
	    for(int i = 0; i < N; i++) {
	      for(int j = 0; j < N; j++) {
	        if(board[i][j]==1) System.out.print("Q ");
	        else System.out.print("* ");
	      }
	      System.out.println();
	    }
	  }

	  static boolean solve(int row, int[][] board, int N) {
	    if(row>=N) return true;
	    for(int position = 0; position < N; position++) {
	      if(isValid(board, row, position, N)) {
	        board[row][position] = 1;
	        if(!solve(row+1, board, N)) {
	          board[row][position] = 0;
	        } else
	          return true;
	      }
	    }
	    return false;
	  }

	  static boolean isValid(int[][] board, int x, int y, int N) {
	    int i, j;
	    for(i = 0; i < x; i++)
	      if(board[i][y]==1)
	        return false;
	    i = x - 1;
	    j = y - 1;
	    while((i>=0)&&(j>=0))
	      if(board[i--][j--]==1) return false;
	    i = x - 1;
	    j = y + 1;
	    while((i>=0)&&(j<N))
	      if(board[i--][j++]==1) return false;
	    return true;
	  }
	}

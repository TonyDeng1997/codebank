package com.webbertech.leetcode.design;

import java.util.ArrayList;

/*
 * Blackjack is the gambling 21 points game, who gets larger and not busted will win.
 * */

public class BlackJackCard extends Card {
   
	public BlackJackCard(int v, Suit s) {
		super(v,s);
	}
	
	// definition of the game
	public boolean isAce() {
		if (value == 1) {
			return true;
		}
		return false;
	}
	
	public int getValue() {
		if (isAce()) {
			return 1;
		} else if (value >=11 && value <= 13) {
			return 10;
		} else {
			return value;
		}
	}
	
	public int minValue() {
		if (isAce()) {
			return 1;
		}
		return value;
	}
	
	public int maxValue() {
		if (isAce()) {
			return 11;
		}
		return value;
	}
	
	public boolean isFaceCard() {
		if (value > 10 && value <= 13) {
			return true;
		}
		return false;
	}
}

// A hand is a object that holds a certain sequence of cards, 
// and this object should tell you that if you win or not

class BlackJackHand extends Hand<BlackJackCard> {
	
	 //get the possible scores due to ace is 1 or 11
	 public int scores() {
		 ArrayList<Integer> scores = possibleScores();
         int maxUnder = Integer.MIN_VALUE;
         int minOver = Integer.MAX_VALUE;
         
         for (int score: scores) {
        	 if (score > 21 && score < minOver) {
        		 minOver = score;
        	 }
        	 else if (score <=21 && score > maxUnder) {
        		 maxUnder = score;
        	 }
         }
         return maxUnder == Integer.MIN_VALUE ? minOver: maxUnder;
	 }
	 
	 // get the possible scores this hand could have, since ace will be 1 or 11
	 ArrayList<Integer> possibleScores() {
		 return null;
	 }
	 public boolean busted() { return false;}
	 public boolean isBlackJack() { return false;}
	 public boolean is21() { return false;}
}

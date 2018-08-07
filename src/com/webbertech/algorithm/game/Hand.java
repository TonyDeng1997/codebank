package com.webbertech.algorithm.game;

import java.util.ArrayList;

public abstract  class Hand <T extends Card> {

	protected ArrayList<T> cards = new ArrayList<T>();
	
	 public Hand() {}
	 
	 public void clear() {}
	 
	 public void addCard(Card c) {}
	 
	 public void removeCard() {}
	 
	 public void removeCard(int pos) {}
	 
	 public int getCardCount() {return 0;}
	 
	 public Card getCard(int pos) {return null;}
	 
	 public void sortBySuit() {}
	 
	 public void sortByValue() {}
	

		public int getScore() {
			int sum =0;
			for(T card : cards) {
				sum+=card.getValue();
			}
			return sum;
		}
}

package com.webbertech.algorithm.game;

public class BlackJackHand extends Hand<BlackJackCard> {

	public BlackJackHand() {}
	
	@Override
	public void addCard(Card c) {
	}
	
	public int getFaceUpValue() {
		if (cards.size() <=0) 
			return -1;
		else
			return cards.get(0).getValue();
	}
	
	public int getPossibleScore() {
		
		return 0;
	}
	
	public boolean isTwentyOne () {
	        return this.getScore() == 21;	
	}
	
	public boolean isBlackJack () {
				return isTwentyOne() && cards.contains(Card.ACE);
		}
	
	public boolean isBusted() {return getPossibleScore() > 21;}
}

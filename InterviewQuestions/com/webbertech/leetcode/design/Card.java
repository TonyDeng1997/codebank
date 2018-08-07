package com.webbertech.leetcode.design;

import java.util.ArrayList;
import java.util.List;

//21 points black jack

enum Suit {
DIAMOND(0), CLUB(1), SPADE(2), HEART(3);

private int value;

private Suit(int v){
	this.value = v;
}

int getValue() {
		return value;
}

public Suit getSuitFromValue(int value) {
	switch(value) {
	case 0: return DIAMOND;
	case 1: return CLUB;
	case 2: return SPADE;
	case 3: return HEART;
	}
	return null;
}

}

//Single card entity class
abstract class Card {
	Suit suit;      //diamond, heart, spade, club
	Integer value;
	boolean available;
	
	Card(int v, Suit s) {
		suit = s;
		value = v;
	}
	
	boolean isAce(){ return suit.getSuitFromValue(value).toString().equals("Ace");};
	// did not implement it
	boolean isJoker(){return false;};
	
	abstract int getValue();
	
	Suit getSuit(){ return suit;};
	
	
	void markAvailable() {
		available = true;
	}
	
	void markUnAvailable() {
		available = false;
	}
}

//A deck of card, like a master class
class Deck  <T extends Card>{
	private ArrayList<T> cards;
  private int dealtIndex =0;
	void shuffle(){};
	int remainingCards() { return cards.size() - dealtIndex;}
	T dealACard() { return null;};
	T[] dealHand(int num) {return null;};	
}

//flush, ...etc
class Hand <T extends Card>{
	/*
	royal flush 同花大顺
	straight flush 同花顺
	straight 顺子
	four of a kind 四张相同的牌
	full house 三张相同和二张相同的牌
	three of a kind 三张相同的牌
	two pairs 双对子
	*/
	
	ArrayList<T> cards = new ArrayList<>();
	boolean isRoyalFlush() { return false;};
	boolean isStraightFlush() { return false;};
	boolean fourOfAKind() { return false;};
	boolean threeOfAKind() { return false;};
	boolean twoPairs() {return false;};
	
	public int score() {
		int score =0;
		for(T t: cards) {
			score+= t.value;
		}
		return score;
	}
	public void addCard(T c) {
		cards.add(c);
	}
}
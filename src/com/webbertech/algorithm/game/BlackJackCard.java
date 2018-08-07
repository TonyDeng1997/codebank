package com.webbertech.algorithm.game;

public class BlackJackCard extends Card {
    
	 public boolean isAce() { 
		 return this.getSuit() == Card.ACE;
	 }
	 
	 public boolean underTenValue() {
		 return this.getValue() < 10 ;
	 }
	 
	 public boolean tenValue() {
		 return this.getValue() >= 10;
	 }
}

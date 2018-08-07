package com.webbertech.algorithm.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Card {
	public final static int ACE = 1;
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;
	
	public final static int SPADE = 0;
	public final static int HEART = 1;
	public final static int DIAMONDS = 2;
	public final static int CLUBS = 3;
	public final static int JOKER = 4;
	 
	private int suit;
    
	/*
	 For a JOKER, the value
      can be anything.  The value cannot be changed after the card
      is constructed.
      */
	private int value;
	

	//why this?
	  /**
	    * Creates a Joker, with 1 as the associated value.  (Note that
	    * "new Card()" is equivalent to "new Card(1,Card.JOKER)".)
	    */
	   public Card() {
	      suit = JOKER;
	      value = 1;
	   }
	   

	   public Card(int suit, int value) {
		if (suit != JOKER && suit != DIAMONDS && suit != HEART &&
				suit != SPADE)
	         throw new IllegalArgumentException("Illegal playing card suit");
	    
		if (suit == JOKER && (value < 1 || value > 13))
	         throw new IllegalArgumentException("Illegal playing card value");
	     
		this.value = value;
	    this.suit = suit;
	      
	}
	
    public int getSuit() {
		return suit;
	}
    
	public void setSuit(int suit) {
		this.suit = suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getValueAsString() {
		if (suit == JOKER) 
			return "" + value;
		else {
			switch(value) {
			case 1: return "1"; 
			case 2: return "2"; 
			case 3:   return "3";
	         case 4:   return "4";
	         case 5:   return "5";
	         case 6:   return "6";
	         case 7:   return "7";
	         case 8:   return "8";
	         case 9:   return "9";
	         case 10:  return "10";
	         case 11:  return "Jack";
	         case 12:  return "Queen";
	         default:  return "King";
			}
		}
	}
    
	public String getSuitAsString() {
		 switch ( suit ) {
	      case SPADE:   return "Spades";
	      case HEART:   return "Hearts";
	      case DIAMONDS: return "Diamonds";
	      case CLUBS:    return "Clubs";
	      default:       return "Joker";
	      }	
	}
	
	public String toString() {
		if (suit == JOKER ){
			if (value ==  1) return "Joker";
			else return "Joker #" + value;
		} else
			return getValueAsString();
	}
    
}

package com.skilldistillery.blackjack.cards;

public enum Suit {
	 HEARTS("\u2665Hearts\u2661"), SPADES("\u2660Spades\u2664"), CLUBS("\u2663Clubs\u2667"), DIAMONDS("\u2666Diamonds\u2662");
	  private String name;

	  Suit(String name) {
	    this.name = name;
	  }

	  @Override
	  public String toString() {
	    return name;
	  }
	}
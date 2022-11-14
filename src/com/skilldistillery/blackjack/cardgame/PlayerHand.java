package com.skilldistillery.blackjack.cardgame;

import com.skilldistillery.blackjack.cards.Card;

public class PlayerHand extends Hand {
public PlayerHand() {
		
	}

	public void addCard(Card card) {
		cards.add(card);
		return;
	}

	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}


	public boolean isBust() {
		int target = 21;
		if (getHandValue() > target) {
			return true;
		}
		return false;
	}
	
	

	public boolean isBlackJack() {
		int target = 21;
		if (getHandValue() == target) {
			return true;
		}
		return false;
	}


}



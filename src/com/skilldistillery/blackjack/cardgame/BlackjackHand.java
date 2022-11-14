package com.skilldistillery.blackjack.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.cards.Card;

public class BlackjackHand extends Hand{
	public BlackjackHand() {
	
super();
List<Card> cards = new ArrayList<>();

}

public void addCard(Card card) {
	cards.add(card);
	
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

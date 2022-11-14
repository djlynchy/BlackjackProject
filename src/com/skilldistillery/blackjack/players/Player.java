package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cardgame.BlackjackHand;
import com.skilldistillery.blackjack.cardgame.Hand;
import com.skilldistillery.blackjack.cards.Card;

public class Player {

	protected Hand hand;

	public Player() {
		hand = new BlackjackHand();
	}

	public Player(Hand hand) {
		super();
		this.hand = hand;
	}

	public void addCardPlayer(Card card) {
		hand.addCard(card);
	}

	public int askHandValue() {
		return hand.getHandValue();
	}

	public boolean isBust() {
		return hand.isBust();
	}

	public boolean isBlackJack() {
		return hand.isBlackJack();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("hand: ").append(hand).append("");
		return builder.toString();
	}

}

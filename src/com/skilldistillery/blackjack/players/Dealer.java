package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;

public class Dealer extends Player {
	private Deck deck;
	public Dealer() {
		deck =new Deck();
	}
	
	
	public Card dealCard() {
		Card card = deck.dealCard();

		return card;
	}

	public void shuffle() {
		deck.shuffle();

	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
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

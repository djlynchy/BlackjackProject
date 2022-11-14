package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	
		  private List<Card> deck = new ArrayList<>();


			public Deck() {
				deck = createDeck();
			}

			private List<Card> createDeck() {
				deck = new ArrayList<>(52);
				
				for (Suit suit : Suit.values()) {
					for (Rank rank : Rank.values()) {
						deck.add(new Card(rank, suit));
					}
				}
				return deck;
			}

			public int checkDeckSize() {
				return deck.size();
			}

			public void shuffle() {
				Collections.shuffle(deck);
			}

			public Card dealCard() {
				return deck.remove(0);
			}

			public void newDeck() {
				createDeck();
				shuffle();
			}

			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append("Deck [cards=").append(deck).append("]");
				return builder.toString();
			}
}


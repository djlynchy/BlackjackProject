package com.skilldistillery.blackjack.blackjackapp;

import java.util.Scanner;

import com.skilldistillery.blackjack.cardgame.BlackjackHand;
import com.skilldistillery.blackjack.cardgame.Hand;
import com.skilldistillery.blackjack.cardgame.PlayerHand;
import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.players.Dealer;
import com.skilldistillery.blackjack.players.Player;

public class BlackjackApp {
	static Scanner scan = new Scanner(System.in);
	Dealer dealer = new Dealer();
	Player player = new Player();

	/*
	 * the dealer deals one card to the player the dealer deals the next card to
	 * them self the dealer deals the next card to the player the dealer deals the
	 * fourth card to them self
	 * 
	 * now the game starts the player adds up their two cards the game asks the
	 * player do hit or stand depending on how close to 21 they are if the player
	 * hits than dealer gives player another card loop till done(close to 21 when
	 * player stands, than dealer adds up dealer hands(display) if dealer has less
	 * than 17 dealer will get another card and add to total if dealer has 17 or
	 * more, no new cards and count compare. who is closer to 21 wins
	 * 
	 */
	public static void main(String[] args) {

		// public void play {

		System.out.println("*****************\u2661************");
		System.out.println("~\u2660~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("******************************");
		System.out.println("~~~~ Welcome To Blackjack ~\u2662~~");
		System.out.println("******************************");
		System.out.println("~~~\u2663~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("******************************");

		boolean play = true;
		{
			do {
				String input = null;
				Deck deck = new Deck();
				deck.shuffle();
				System.out.println();

				PlayerHand player = new PlayerHand();
				for (int i = 0; i < 2; i++) {
					Card newCard = deck.dealCard();

					player.cards.add(newCard);

				}

				System.out.println("Your hand:");
				for (Card cards : player.cards) {
					System.out.println("- " + cards.toString() + " (" + cards.getValue() + ")");
				}
				System.out.println("Your Total: " + player.getHandValue());

				BlackjackHand house = new BlackjackHand();
				for (int i = 0; i < 2; i++) {
					Card newCard = deck.dealCard();

					house.cards.add(newCard);
				}

				System.out.println("Dealer hand:");
				for (Card bcard : house.cards) {
					System.out.println("- " + bcard.toString() + " (" + bcard.getValue() + ")");

				}
				System.out.println("Dealer Total: " + house.getHandValue());
				System.out.println();

				BlackjackHand hand = new BlackjackHand();
				for (int i = 0; i < 2; i++) {
					Card card = deck.dealCard();

				}

				if (player.isBlackJack()) {
					System.out.println("You Win!!");
					play = false;
					break;
				} else if (player.isBust()) {
					System.out.println("You Busted!");
					play = false;
					break;
				}

				if (house.isBlackJack()) {
					System.out.println("House Wins!");
					play = false;
					break;
				} else if (house.isBust()) {
					System.out.println("House Busted!");
					play = false;
					break;
				}

				try {
					System.out.println();
					System.out.println("Hit or Stay?");
					input = scan.next();
					if (input.equalsIgnoreCase("hit")) {
						Card newCard = deck.dealCard();

						player.cards.add(newCard);
						System.out.println("Draw:\n- " + newCard.toString() + " (" + newCard.getValue() + ")");
						System.out.println("Your Total: " + player.getHandValue());
					} else if (input.equalsIgnoreCase("stay")) {
						System.out.println("Staying.");
					}
				} catch (Exception e) {
					continue;

				}

				if (house.getHandValue() <= 17) {
					System.out.println("Dealer hits.");
					Card houseCard = deck.dealCard();
					house.cards.add(houseCard);
					System.out.println("- " + houseCard.toString() + " (" + houseCard.getValue() + ")");
					System.out.println("Dealer Total: " + house.getHandValue());

					if (player.isBust() && house.isBust()) {
						System.out.println("no winners here.");
						play = false;
						break;
					}

					if (player.isBlackJack()) {
						System.out.println("You Win!!");
						play = false;
						break;
					} else if (player.isBust()) {
						System.out.println("You Busted!");
						play = false;
						break;
					}

					if (house.isBlackJack()) {
						System.out.println("House Wins!");
						play = false;
						break;
					} else if (house.isBust()) {
						System.out.println("You Win!!");
						play = false;
						break;
					}
				} else {
					System.out.println("\nDealer stays (" + house.getHandValue() + ")");

					if (player.isBust() && house.isBust()) {
						System.out.println("no winners");
						play = false;
						break;
					}

					if (player.isBlackJack()) {
						System.out.println("You Win!!");
						play = false;
						break;
					} else if (player.isBust()) {
						System.out.println("You busted!");

						play = false;
						break;
					}
				}

				if (input.equalsIgnoreCase("stay")) {

					if (player.isBust() && house.isBust()) {
						System.out.println("no winners");
						play = false;
						break;
					}

					if (player.getHandValue() >= house.getHandValue()) {
						System.out.println("You win!!");
						play = false;
						break;
					} else {

						play = false;
						break;
					}
				}

			} while (play);
		}

	}
}

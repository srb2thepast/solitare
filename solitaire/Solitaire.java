// Creator: Alex Hazoume
// Description: The class that evaluates the logical componenets of solitare, including the legality of  actions to be done.
// Date: 10/19/2023

package solitaire;

import java.util.*;

import solitaire.Card.Suit;

public class Solitaire {

	ArrayList<Stack<Card>> centerPiles;
	Stack<Card> faceUpDeckCards;

	Stack<Card> diamondsFinal;
	Stack<Card> heartsFinal;
	Stack<Card> spadesFinal;
	Stack<Card> clubsFinal;
	Queue<Card> deck;

	public Solitaire() {
		initiate();

		diamondsFinal.add(new Card(100, Suit.Spades));

		heartsFinal.add(new Card(100, Suit.Spades));

		spadesFinal.add(new Card(100, Suit.Spades));
		clubsFinal.add(new Card(100, Suit.Spades));
	}

	public String toString() {
		String finalString = " {=-=} CENTER: ";

		int i = 0;
		for (Stack<Card> cardList : centerPiles) {
			finalString += "\nCOLOUMN [" + i + "]: ";
			finalString += cardList;
			i += 1;
		}

		finalString += "\n {=-=} DECK: ";
		finalString += "\n" + deck;
		finalString += "\n face up: " + faceUpDeckCards + ")";
		finalString += "\n secondDeck:" + secondDeck;

		finalString += "\n {=-=} FINAL PILES: ";

		finalString += "\n - Diamonds: ";
		finalString += "\n" + diamondsFinal;
		finalString += "\n - Hearts: ";
		finalString += "\n" + heartsFinal;
		finalString += "\n - Spades: ";
		finalString += "\n" + spadesFinal;
		finalString += "\n - Clubs: ";
		finalString += "\n" + clubsFinal;
		return finalString;
	}


	// Precondition: none
	// Postcondition: Sets up the game.
	private void initiate() {
		diamondsFinal = new Stack<Card>();
		heartsFinal = new Stack<Card>();
		spadesFinal = new Stack<Card>();
		clubsFinal = new Stack<Card>();
		centerPiles = new ArrayList<Stack<Card>>();
		faceUpDeckCards = new Stack<Card>();
		deck = new LinkedList<Card>();

		ArrayList<Card> temp = new ArrayList<Card>();

		for (Suit suit : Suit.values()) {
			for (int value = 1; value <= 13; ++value) {
				Card c = new Card(value, suit);
				c.hide();
				temp.add(c);
			}
		}

		//Collections.shuffle(temp);
		
		deck.addAll(temp);
		deck.add(new Card(0,Suit.Spades));
		
		
		for (int i = 1; i <= 7; i++) {
			System.out.println(i);
			centerPiles.add(new Stack<Card>());

			centerPiles.get(centerPiles.size() - 1).add(new Card(0, Suit.Spades));
			for (int j = 0; j < i; j++) {
				Card card = deck.remove();
				card.show();
				if (j != i-1) {
					card.hide();
				}
				centerPiles.get(centerPiles.size() - 1).add(card);
			}
		}
		

		//Object[] deckS = deck.toArray();
		//deckS[deckS.length-1] = 

	}


	// Precondition: The card moving and the card to be moved to.
	// Postcondition: Returns whether or not it's allowed.
	public boolean legalMove(Card toMove, Card location) {

		// display cards for debugging

		// make sure you check to see if the card is actually visible to us! You can do
		// so by doing.

		// If the moving card is face down, the move is illegal
		if (toMove.isReversed == true) {
			return false;

		}
		// if the moving card is the empty card (100 of spades), the move is illegal.
		if (toMove.value == 100)
			return false;
		
		// if the card is from the deck and it's not at the bottom of the deck, then invalid
		Stack<Card> cardParent =findCardParent(toMove);
		if (cardParent == faceUpDeckCards && cardParent.indexOf(toMove) != cardParent.size()-1) return false;
		
		// MOVING TO FINAL
		
		// make sure the toMove card is at the bottom of whatever container it's located in
		

		// If the target card is in the one of the final decks:
		if (diamondsFinal.contains(location) || spadesFinal.contains(location) || heartsFinal.contains(location)
				|| clubsFinal.contains(location)) {
			// if the card being moved is in the center and is at the bottom of it's stack
			// (thus meaning it's moving alone)
			for (Stack<Card> pile : centerPiles) {
				if (pile.indexOf(toMove) == pile.size() - 1) {
					// if toMove is 1 more than the target card, and the cards are the same suit,
					// then valid
					if (location.suit == toMove.suit && location.value == toMove.value - 1) {
						return true;
					}
					// if toMove is A and the target card is the empty card in the winning pile,
					// then valid
					if (location.value == 100 && toMove.value == 1) {
						return true;
					}
				}
			}

			// if the card being moved is simply one of the face-up deck cards
			if (faceUpDeckCards.contains(toMove)) {
				// if toMove is 1 more than the target card, and the cards are the same suit,
				// then valid
				if (location.suit == toMove.suit && location.value == toMove.value - 1) {
					return true;
				}
				// if toMove is A and the target card is the empty card in the winning pile,
				// then valid
				if (location.value == 100 && toMove.value == 1) {
					return true;
				}
			}
		}

		// MOVING TO CENTER

		// If the target card is in one of the center piles & it's at the bottom
		for (Stack<Card> i : centerPiles) {
			if (i.indexOf(location) == i.size() - 1 && i.contains(location)) {
				System.out.println("bottom = ");
				// if the current toMove card is 1 less than the target Card and they are
				// opposite suits, then valid
				if (toMove.value + 1 == location.value && toMove.suit != location.suit) {
					return true;
				}

				// if toMove is K and the target card is the empty card in the center, then
				// valid
				if (toMove.value == 13 && location.value == 100) {
					System.out.println("Move to center empty");
					return true;
				}

			}
		}
		System.out.println(toMove.value  + "<- TM VAL | LOC ->" + location.value);
		return false;
	}

	Queue<Card> secondDeck = new LinkedList<Card>();

	// Precondition: None
	// Postcondition: Updates the deck with the next 3 available cards.
	public Stack<Card> getNextDeckCards() {
		Stack<Card> revealedCards = new Stack<Card>();
		System.out.println("next card value = " + deck.peek().value);
		if (deck.peek().value == 100) {
			System.out.println("Last reached");
			Card spade100 = deck.poll();
			for (Card c : secondDeck) {
				c.hide();
				deck.add(c);
			}
			deck.add(spade100);	
			secondDeck.clear();
		} else {
			for (int i = 0; i < 3; i++) {
				if (!deck.isEmpty()) {
					Card nextCard = deck.peek();
					if (nextCard.value == 100) {
						continue;
					}
					deck.poll();
					revealedCards.push(nextCard);
					secondDeck.add(nextCard);
				}
			}
		}
		for (Card card: revealedCards) {
			card.show();
		}

		faceUpDeckCards = revealedCards;
		return revealedCards;

	}

	// Precondition: The card you wish to find  the parent of.
	// Postcondition: Returns the stack that this card is contained in.
	public Stack<Card> findCardParent(Card card) {
		
		for (Stack<Card> centerStack : centerPiles) {
			if (centerStack.contains(card)) {
				return centerStack;
			}
		}
		if (faceUpDeckCards.contains(card)) return faceUpDeckCards;
		
		ArrayList<Stack<Card>> stacks = new ArrayList<Stack<Card>>();
		stacks.add(heartsFinal);
		stacks.add(diamondsFinal);
		stacks.add(clubsFinal);
		stacks.add(spadesFinal);
		for (Stack<Card> winStack : stacks) {
			if (winStack.contains(card)) {
				return winStack;
			}
		}
		return null;
	}
	
	//precondition: an instance of solitaire is initialized
	//postcondition: returns a boolean; if the final piles are full return true, else return false
	public boolean checkWin() {
		boolean win;
		if(this.diamondsFinal.size() == 13 && this.spadesFinal.size() == 13 && this.clubsFinal.size() == 13 && this.heartsFinal.size() == 13) {
			win=true;
		} else {
			win=false;
		}
		return win;
	}

	// the part of your program that's in charge of game rules goes here.
}

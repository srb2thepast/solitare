// Creator: Alex Hazoume
// Description: The class that evaluates the logical componenets of solitare, including the legality of  actions to be done.
// Date: 10/19/2023

package solitaire;

import java.util.*;
import java.util.Queue;

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
	}

	public String toString() {
		String finalString = " {=-=} CENTER: ";
		
		int i = 0;
		for (Stack<Card> cardList : centerPiles) {
			finalString += "\nCOLOUMN [" + i + "]: ";
			finalString += cardList;
			i+=1;
		}

		finalString += "\n {=-=} DECK: ";
		finalString += "\n" + deck;
		finalString +=  "\n face up: " + faceUpDeckCards + ")";

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
	
	private void initiate() {
		diamondsFinal = new Stack<Card>();
		heartsFinal = new Stack<Card>();
		spadesFinal = new Stack<Card>();
		clubsFinal = new Stack<Card>();
		centerPiles = new ArrayList<Stack<Card>>();
		deck = new LinkedList<Card>();

		ArrayList<Card> temp = new ArrayList<Card>();

		for (Suit suit : Suit.values()) {
			for (int value = 1; value <= 13; ++value) {
				temp.add(new Card(value, suit));
			}
		}

		Collections.shuffle(temp);

		deck.addAll(temp);

		for (int i = 1; i <= 7; i++) {
			System.out.println(i);
			centerPiles.add(new Stack<Card>());

			for (int j = 0; j < i; j++) {
				centerPiles.get(centerPiles.size() - 1).add(deck.remove());
			}
		}

	}

	public boolean legalMove(Card toMove, Card location) {

		// display cards for debugging
		
		

		// make sure you check to see if the card is actually visible to us! You can do
		// so by doing.

		// If the moving card is face down, the move is illegal
		if (toMove.isReversed == true) {
				return false;

		}
		
		// MOVING TO FINAL

		// If the target card is in the one of the final decks:
		if (
			diamondsFinal.contains(location) || 
			spadesFinal.contains(location) ||
			heartsFinal.contains(location) ||
			clubsFinal.contains(location)) {
			// if the card being moved is in the center and is at the bottom of it's stack (thus meaning it's moving alone)
			for (Stack<Card> pile : centerPiles) { 
				if (pile.indexOf(toMove) == pile.size()-1) {
					// if toMove is 1 more than the target card, and the cards are the same suit, then valid
					if (location.suit == toMove.suit && location.value == toMove.value - 1) 	{
						return true;
					}
				}
			}

			// if the card being moved is simply one of the face-up deck cards
			if (faceUpDeckCards.contains(toMove)) {
				// if toMove is 1 more than the target card, and the cards are the same suit, then valid
				if (location.suit == toMove.suit && location.value == toMove.value - 1) 	{
					return true;
				}
			}
		}
		
		// MOVING TO CENTER
		
		// If the target card is in one of the center piles & it's at the bottom
		for (Stack<Card> i : centerPiles) {
			if (i.indexOf(location) == i.size()-1) {
				// if the current toMove card is 1 less than the target Card and they are opposite suits, then valid
				if (toMove.value +  1 == location.value && toMove.suit != location.suit) {
					return true;
				}

			}
		}


		
		return false;
	}
	public Stack<Card> getNextDeckCards(){
		Stack<Card> revealedCards = new Stack<Card>();
		Queue<Card> secondDeck = new LinkedList<Card>();
		if(deck.isEmpty()){
			for(int i = 0; i < revealedCards.size()-1;i++) {
				secondDeck.add(revealedCards.pop());
			}
		} else{
			for(int i = 0; i<3; i++){
				if(!deck.isEmpty()){
					revealedCards.push(deck.poll());
				}
			}
		}
		return revealedCards;

	}

	// the part of your program that's in charge of game rules goes here.
}

// Creator: Alex Hazoume
// Description: A pane that contains every coloum of active cards.
// Date: 10/19/2023

package solitaire;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.util.*;

import javax.swing.*;

import solitaire.Card.Suit;

public class CardPileContainerPane extends JLayeredPane {
	private ArrayList<CardPile> pilePanes;

	public CardPileContainerPane() {
		setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.cyan));

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(new Dimension(500, 500));
		setPreferredSize(new Dimension(150, 10));
		pilePanes = new ArrayList<CardPile>();
	}

	public void setAllPilePanes(ArrayList<Stack<Card>> pileList) {
		System.out.println("Setting all piles");
		pilePanes.clear();
		this.removeAll();

		for (Stack<Card> cardStack : pileList) {
			drawPile(cardStack);

			pilePanes.add(new CardPile(cardStack));
		}

		System.out.println("Redrawing all piles");
		for (CardPile pile : pilePanes) {
			pile.drawPile();
			add(pile);
		}
	}

	private void testDraw2() {
		ArrayList<Stack<Card>> centerPiles = new ArrayList<Stack<Card>>();

		LinkedList<Card> deck = new LinkedList<Card>();

		ArrayList<Card> temp = new ArrayList<Card>();

		for (Suit suit : Suit.values()) {
			for (int value = 1; value <= 13; ++value) {
				temp.add(new Card(value, suit));
			}
		}

		Collections.shuffle(temp);

		deck.addAll(temp);

		for (int i = 1; i <= 7; i++) {
			centerPiles.add(new Stack<Card>());

			for (int j = 0; j < i; j++) {
				centerPiles.get(centerPiles.size() - 1).add(deck.remove());
			}
		}
		setAllPilePanes(centerPiles);
	}

	private void testDraw() {

		// Create a dummy card list
		ArrayList<Stack<Card>> pileList = new ArrayList<Stack<Card>>();
		for (int i = 0; i < 7; i++) {

			Stack<Card> testStack = new Stack<Card>();
			testStack.add(new Card(i + 1, Suit.Diamonds));
			testStack.add(new Card(i + 1, Suit.Hearts));
			testStack.add(new Card(2, Suit.Hearts));
			testStack.add(new Card(3, Suit.Hearts));
			testStack.add(new Card(4, Suit.Hearts));
			testStack.add(new Card(5, Suit.Hearts));
			testStack.add(new Card(6, Suit.Hearts));
			testStack.add(new Card(7, Suit.Hearts));
			pileList.add(testStack);
		}

		// set it
		setAllPilePanes(pileList);
	}

	public JLayeredPane drawPile(Stack<Card> stackIn) {

		// the drawing of the cards is mostly handled in CardPile.drawPile().
		CardPile pile = new CardPile(stackIn);
		pile.drawPile();

		return pile;
	}
}

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

	// Precondition: A list of the 7 cards that should be drawn to the screen.
	// Post: Draws all 7 cards.
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

	// Precondition: The stack of cards to be drawn
	// Post: Draws the given stack as a new CardPile.
	public JLayeredPane drawPile(Stack<Card> stackIn) {

		// the drawing of the cards is mostly handled in CardPile.drawPile().
		CardPile pile = new CardPile(stackIn);
		pile.drawPile();

		return pile;
	}
}

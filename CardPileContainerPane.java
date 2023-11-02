// Creator: Alex Hazoume
// Description: A pane that contains every coloum of active cards.
// Date: 10/19/2023

package solitaire;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Stack;

import javax.swing.*;

import solitaire.Card.Suit;

public class CardPileContainerPane extends JLayeredPane {
	private CardPile[] piles;

	public CardPileContainerPane() {
		setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.cyan));

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(new Dimension(500, 500));
		setPreferredSize(new Dimension(150, 10));
		for (int i = 0; i < 7; i++) {

			Stack<Card> testStack = new Stack<Card>();
			testStack.add(new Card(i+1, Suit.Diamonds));
			testStack.add(new Card(i+1, Suit.Hearts));
			testStack.add(new Card(2, Suit.Hearts));
			testStack.add(new Card(3, Suit.Hearts));
			testStack.add(new Card(4, Suit.Hearts));
			testStack.add(new Card(5, Suit.Hearts));
			testStack.add(new Card(6, Suit.Hearts));
			testStack.add(new Card(7, Suit.Hearts));
			
			
			add(drawPile(testStack));
			

		}
	}
	

	   public JLayeredPane drawPile(Stack<Card> stackIn) {

		    Object cards[];

		    cards = stackIn.toArray(); 

			// the drawing of the cards is mostly handled in CardPile.drawPile().
			CardPile pile = new CardPile(cards);
			pile.drawPile();

		    return pile;
			
		}
}

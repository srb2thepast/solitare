// Creator: Alex Hazoume
// Description: A pane that contains one column of cards.
// Date: 10/19/2023

package solitaire;
import java.awt.Button;
import java.awt.Color;
import java.util.*;
import java.awt.Dimension;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;


public class CardPile extends JLayeredPane {
	private Stack<Card> cards;
	


	// Precondition: none
	// Post: Creates a new CardPile.
	public CardPile() {
		cards = new Stack<Card>();
		setSize(new Dimension(0,500));
		setPreferredSize(new Dimension(0,10));

		setOpaque(false);
		setLayout(null);
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
	}

	// Precondition: none
	// Post: Creates a new CardPile with the given array.
	public CardPile(Card[] cardArr) {
		this();
		for (Card card : cardArr) {
			addCard(card);
		}
	}
	

	// Precondition: none
	// Post: Creates a new CardPile with the given array.
	public CardPile(Object[] cardArr) {
		this();
		for (Object card : cardArr) {
			addCard((Card)card);
		}
	}

	// Precondition: none
	// Post: Creates a new CardPile with the given stack.
	public CardPile(Stack<Card> cardStack) {
		// Calls the Object[] array constructor 
		this(cardStack.toArray());
	}

	// Precondition: Any card.
	// Post: Adds the given card to the bottom of the CardPile.
	public void addCard(Card card) {
		cards.add(card);
		
		drawPile();
	}

	// Precondition: none
	// Post: draws the pile stored in this class onto the screen.
	public void drawPile() {
		removeAll();

		// System.out.println("A pile is being drawn.");
		int i = 0;
		Object cardsObj[];
		cardsObj = cards.toArray(); //please note we convert this stack to an array so that we can iterate through it backwards while drawing. You�ll need to cast each element inside cards to a <Card> in order to use the methods to adjust their position

		// System.out.println("Card count:  " + cards.size() + ", cards: " + cards);
		
		for (i = cards.size()-1; i >= 0; i-=1) {
			Card card = cards.get(i);
			this.setPosition(card, cardsObj.length-i);
			card.setBounds(0, i*39, card.getWidth(), card.getHeight());
			add(card);
		}


	}
}

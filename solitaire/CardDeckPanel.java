// Creator: Alex Hazoume
// Description: A pane that contains and manages the revealed 3 cards that the player can look at and the deck of new cards.
// Date: 10/19/2023

package solitaire;


import javax.swing.*;
import java.awt.*;
import java.util.*;

import javax.swing.BorderFactory;

import solitaire.Card.Suit;

public class CardDeckPanel extends JLayeredPane {
	private Stack<Card> cards;
	

	public CardDeckPanel() {
		cards = new Stack<Card>();
		setPreferredSize(new Dimension(200,16));

		setOpaque(false);
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
	}

	public void setDisplayedDeck(Stack<Card> cards,Card topOfDeck) {
		removeAll();
		int i = 0;
		Object cardsObj[];
		cardsObj = cards.toArray(); //please note we convert this stack to an array so that we can iterate through it backwards while drawing. You�ll need to cast each element inside cards to a <Card> in order to use the methods to adjust their position

		// System.out.println("Card count:  " + cards.size() + ", cards: " + cards);

		Card deckTop = new Card(100,Suit.Spades);
		if (topOfDeck != null) {
			deckTop = topOfDeck;
		} 
		this.setPosition(deckTop, 0);
		deckTop.setBounds(0, i*39, deckTop.getWidth(), deckTop.getHeight());
		add(deckTop);
		
		for (i = cards.size()-1; i >= 0; i-=1) {
			Card card = cards.get(i);
			this.setPosition(card, cardsObj.length-i);
			card.setBounds(0, i*39+200, card.getWidth(), card.getHeight());
			add(card);
		}
	}
}

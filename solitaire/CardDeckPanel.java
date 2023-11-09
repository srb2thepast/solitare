// Creator: Alex Hazoume
// Description: A pane that contains and manages the revealed 3 cards that the player can look at and the deck of new cards.
// Date: 10/19/2023

package solitaire;


import javax.swing.*;
import java.awt.*;
import java.util.*;

import javax.swing.BorderFactory;

public class CardDeckPanel extends JLayeredPane {
	private Stack<Card> cards;
	

	public CardDeckPanel() {
		cards = new Stack<Card>();
		setPreferredSize(new Dimension(200,16));

		setOpaque(false);
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
	}

}

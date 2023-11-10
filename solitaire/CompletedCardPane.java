package solitaire;
// Creator: Alex Hazoume
// Description: A pane that contains and manages the cards that the player has finalized.
// Date: 10/19/2023

import javax.swing.*;
import java.awt.*;
import java.util.*;

import javax.swing.BorderFactory;

public class CompletedCardPane extends JLayeredPane {
	public CompletedCardPane() {
		setPreferredSize(new Dimension(200,16));

		setOpaque(false);
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));
	}
	
	// Precondition: takes in the 4 final card piles to be displayed
	// Postcondiiton: draws the top 4 cards to the screen
	public void setDisplayedCompleted(Stack<Card> heartStack,Stack<Card> diamondStack,Stack<Card> clubStack,Stack<Card> spadeStack) {
		removeAll();
		
		ArrayList<Stack<Card>> stacks = new ArrayList<Stack<Card>>();
		stacks.add(heartStack);
		stacks.add(diamondStack);
		stacks.add(clubStack);
		stacks.add(spadeStack);
		
		// System.out.println("Card count:  " + cards.size() + ", cards: " + cards); 
		
		
		for (int i = 0; i < stacks.size(); i++) {
			Stack<Card> curStack = stacks.get(i);
			if (curStack.size() == 0) continue;
			Object cardsObj[];
			cardsObj = curStack.toArray(); //please note we convert this stack to an array so that we can iterate through it backwards while drawing. You�ll need to cast each element inside cards to a <Card> in order to use the methods to adjust their position
			
			Card card = curStack.get(curStack.size()-1);
			this.setPosition(card, cardsObj.length-i);
			card.setBounds(50, 20+i*160, card.getWidth(), card.getHeight());
			add(card);
		}
	}
}

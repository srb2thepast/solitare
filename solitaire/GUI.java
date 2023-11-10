package solitaire;

import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import solitaire.Card.Suit;

public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	Solitaire game;
	CardPileContainerPane pileContainer;
	CardDeckPanel deckContainer;
	CompletedCardPane completedContainer;

	public GUI(Solitaire game) {
		this.game = game;
	  for(Card c: game.deck) {
		c.addMouseListener(this);
	   }
	   for(Stack<Card> c : game.centerPiles) {
		for(Card d : c) {
			d.addMouseListener(this);
		}
	   }
	   for(Card c : game.faceUpDeckCards) {
		c.addMouseListener(this);
	   }
	   for(Card c : game.diamondsFinal) {
		c.addMouseListener(this);
	   }
	   for(Card c : game.heartsFinal) {
		c.addMouseListener(this);
	   }
	   for(Card c : game.spadesFinal) {
		c.addMouseListener(this);
	   }
	   for(Card c : game.clubsFinal) {
		c.addMouseListener(this);
	   }
		// Create and set up the window.
		setTitle("Solitaire");
		setSize(1200, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// this supplies the background
		try {
			URL background = getClass().getResource("../solitaire/images/background.jpg");
			setContentPane(new ImagePanel(ImageIO.read(background)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*******
		 * This is just a test to make sure images are being read correctly on your
		 * machine. Please replace once you have confirmed that the card shows up
		 * properly. The code below should allow you to play the solitare game once it's
		 * fully created.
		 */
		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		setLayout(new BorderLayout());
		// this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

		pileContainer = new CardPileContainerPane();

		deckContainer = new CardDeckPanel();

		completedContainer = new CompletedCardPane();

		add(pileContainer, BorderLayout.CENTER);

		add(new Button("North"), BorderLayout.NORTH);
		add(new Button("South"), BorderLayout.SOUTH);
		add(completedContainer, BorderLayout.EAST);
		add(deckContainer, BorderLayout.WEST);
		// this.add(card);
		this.setVisible(true);
		update();
		
		
	}

	// Precondition: none
	// Postcondition: reloads the entire screen with the information from the current state of the game.
	private void update() {
		System.out.println("Updating screen.");
		pileContainer.setAllPilePanes(game.centerPiles);
		completedContainer.setDisplayedCompleted(game.heartsFinal,game.diamondsFinal,game.clubsFinal,game.spadesFinal);
		
		if (game.faceUpDeckCards != null) {
			deckContainer.setDisplayedDeck(game.faceUpDeckCards);
		}
		
		
		System.out.println(game.toString());
		revalidate();
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
		if(arg0.getComponent() instanceof Card) {
			Card c = (Card)arg0.getComponent();
			if(toMove.equals(null)) {
				toMove=c;
			} else {
			    location = c;
			}
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}

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

	public GUI(Solitaire game) {
		this.game = game;

		// Create and set up the window.
		setTitle("Solitaire");
		setSize(1200, 700);
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

		CardDeckPanel deckContainer = new CardDeckPanel();

		CompletedCardPane completedContainer = new CompletedCardPane();

		add(pileContainer, BorderLayout.CENTER);

		add(new Button("North"), BorderLayout.NORTH);
		add(new Button("South"), BorderLayout.SOUTH);
		add(completedContainer, BorderLayout.EAST);
		add(deckContainer, BorderLayout.WEST);
		// this.add(card);
		this.setVisible(true);
		update();
		
		
	}

	private void update() {
		System.out.println("Updating screen.");
		pileContainer.setAllPilePanes(game.centerPiles);
		
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
		update();

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

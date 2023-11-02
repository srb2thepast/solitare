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
}

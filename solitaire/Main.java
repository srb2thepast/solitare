package solitaire;

public class Main {

	Solitaire game;
	GUI gui;
	
	public Main() {
		game = new Solitaire();
		gui = new GUI(game);
	}
	
	public static void main(String[] args) {
		Main try1 = new Main();
	}
	
}	
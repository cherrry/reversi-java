package reversi;

import javax.swing.*;
import java.awt.*;

public class Reversi extends JFrame {
	
	public Reversi() {
		super();
		setTitle("Reversi - by Cherry");
		setSize(400, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(1, 1));
		add(new ChessBoard());
	}

	public static void main(String[] args) {
		Reversi game = new Reversi();
		game.setVisible(true);
	}
}
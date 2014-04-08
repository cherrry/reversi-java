package reversi;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ChessButton extends JButton {
	
	private int x, y;
	private boolean occupied = false;
	private boolean owner;
	
	private static final ImageIcon blackIcon = new ImageIcon(ClassLoader.getSystemResource("BlackChess.png"));
	private static final ImageIcon whiteIcon = new ImageIcon(ClassLoader.getSystemResource("WhiteChess.png"));
	private static final ImageIcon blackHover = new ImageIcon(ClassLoader.getSystemResource("BlackHover.png"));
	private static final ImageIcon whiteHover = new ImageIcon(ClassLoader.getSystemResource("WhiteHover.png"));
	private static final ImageIcon blankIcon = new ImageIcon(ClassLoader.getSystemResource("Blank.png"));
	
	public ChessButton() {
	}
	public ChessButton(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.occupied = false;
		this.setText(null);
		this.reset();
		this.setBackground(new Color(250, 250, 200));
	}
	
	public void clear() {
		this.occupied = false;
		this.setEnabled(true);
		this.reset();
	}
	
	public ImageIcon getIcon() {
		if (occupied) {
			if (owner)
				return blackIcon;
			return whiteIcon;
		}
		return blankIcon;
	}
	public ImageIcon getIcon(boolean player) {
		if (player)
			return blackIcon;
		return whiteIcon;
	}

	public int getRow() {
		return this.x;
	}
	public int getColumn() {
		return this.y;
	}
	public boolean getOwner() {
		return this.owner;
	}
	public boolean isOccupied() {
		return this.occupied;
	}

	public void setOwner(boolean player) {
		this.occupied = true;
		this.owner = player;
		this.setEnabled(false);
		this.reset();
	}
	
	public void reset() {
		this.setDisabledIcon(getIcon());
		this.setIcon(null);
		this.setRolloverIcon(null);
	}
	
	public void hover(boolean player) {
		if (player) {
			this.setDisabledIcon(blackHover);
			this.setRolloverIcon(blackIcon);
		} else {
			this.setDisabledIcon(whiteHover);
			this.setRolloverIcon(whiteIcon);
		}
	}
	
}
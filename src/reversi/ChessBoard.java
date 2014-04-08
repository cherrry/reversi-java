package reversi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JPanel {
	
	private boolean currentPlayer = true;
	private ChessButton[][] chess;
	private ChessButton temp;
	private int playerBlack = 2;
	private int playerWhite = 2;
	private int counter = 0;
	
	public ChessBoard() {
		super();

		setLayout(new GridLayout(8, 8));
		chess = new ChessButton[8][8];
		int i, j;
		for (i=0;i<8;i++) {
			for (j=0;j<8;j++) {
				chess[i][j] = new ChessButton(i, j);
				add(chess[i][j]);
				
				chess[i][j].addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						buttonsMouseEntered(evt);
					}
                });
				chess[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						buttonsActionPerformed(evt);
					}
				});
			}
		}
		
		initializeGame();
	}

	public void initializeGame() {
		
		counter = 0;
		playerBlack = 2;
		playerWhite = 2;
		int i, j;
		for (i=0;i<8;i++) {
			for (j=0;j<8;j++) {
				chess[i][j].clear();
			}
		}
		
		chess[3][3].setOwner(true);
		chess[4][4].setOwner(true);
		chess[3][4].setOwner(false);
		chess[4][3].setOwner(false);

	}
	
	private void buttonsMouseEntered(MouseEvent evt) {
		
		int i, j;
		for (i=0;i<8;i++) {
			for (j=0;j<8;j++) {
				chess[i][j].reset();
			}
		}
		
		temp = (ChessButton) (evt.getSource());
		int chessRow = temp.getRow();
		int chessColumn = temp.getColumn();

		if (isValidMove()) {
			int row, column;
			temp.hover(currentPlayer);
			
			if (isToRightValid()) {
				row = chessRow;
				column = chessColumn+1;
				while (column < 7 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].hover(currentPlayer);
					column++;
				}
			}
			if (isToLeftValid()) {
				row = chessRow;
				column = chessColumn-1;
				while (column > 0 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].hover(currentPlayer);
					column--;
				}
			}
			if (isToBelowValid()) {
				row = chessRow+1;
				column = chessColumn;
				while (row < 7 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].hover(currentPlayer);
					row++;
				}
			}
			if (isToAboveValid()) {
				row = chessRow-1;
				column = chessColumn;
				while (row > 0 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].hover(currentPlayer);
					row--;
				}
			}
			if (isToBottomRightValid()) {
				row = chessRow+1;
				column = chessColumn+1;
				while (row < 7 && column < 7 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].hover(currentPlayer);
					row++; column++;
				}
			}
			if (isToTopLeftValid()) {
				row = chessRow-1;
				column = chessColumn-1;
				while (row > 0 && column > 0 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].hover(currentPlayer);
					row--; column--;
				}
			}
			if (isToBottomLeftValid()) {
				row = chessRow+1;
				column = chessColumn-1;
				while (row < 7 && column > 0 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].hover(currentPlayer);
					row++; column--;
				}
			}
			if (isToTopRightValid()) {
				row = chessRow-1;
				column = chessColumn+1;
				while (row > 0 && column < 7 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].hover(currentPlayer);
					row--; column++;
				}
			}
			
		}
	
	}
	private void buttonsActionPerformed(ActionEvent evt) {
		temp = (ChessButton) (evt.getSource());
		int chessRow = temp.getRow();
		int chessColumn = temp.getColumn();
		int switchedChess = 0;
		
		if (isValidMove()) {
			int row, column;
			temp.setOwner(currentPlayer);
			if (isToRightValid()) {
				row = chessRow;
				column = chessColumn+1;
				while (column < 7 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].setOwner(currentPlayer);
					column++;
					switchedChess++;
				}
			}
			if (isToLeftValid()) {
				row = chessRow;
				column = chessColumn-1;
				while (column > 0 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].setOwner(currentPlayer);
					column--;
					switchedChess++;
				}
			}
			if (isToBelowValid()) {
				row = chessRow+1;
				column = chessColumn;
				while (row < 7 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].setOwner(currentPlayer);
					row++;
					switchedChess++;
				}
			}
			if (isToAboveValid()) {
				row = chessRow-1;
				column = chessColumn;
				while (row > 0 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].setOwner(currentPlayer);
					row--;
					switchedChess++;
				}
			}
			if (isToBottomRightValid()) {
				row = chessRow+1;
				column = chessColumn+1;
				while (row < 7 && column < 7 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].setOwner(currentPlayer);
					row++; column++;
					switchedChess++;
				}
			}
			if (isToTopLeftValid()) {
				row = chessRow-1;
				column = chessColumn-1;
				while (row > 0 && column > 0 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].setOwner(currentPlayer);
					row--; column--;
					switchedChess++;
				}
			}
			if (isToBottomLeftValid()) {
				row = chessRow+1;
				column = chessColumn-1;
				while (row < 7 && column > 0 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].setOwner(currentPlayer);
					row++; column--;
					switchedChess++;
				}
			}
			if (isToTopRightValid()) {
				row = chessRow-1;
				column = chessColumn+1;
				while (row > 0 && column < 7 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					chess[row][column].setOwner(currentPlayer);
					row--; column++;
					switchedChess++;
				}
			}
			if (currentPlayer) {
				playerBlack += switchedChess + 1;
				playerWhite -= switchedChess;
			} else {
				playerWhite += switchedChess + 1;
				playerBlack -= switchedChess;
			}
			currentPlayer = !currentPlayer;
			counter++;
			
			if (noValidMove()) {
				currentPlayer = !currentPlayer;
				if (noValidMove()) {
					gameEndedAction();
				} else {
					String message = "No valid move for ";
					if (currentPlayer)
						message += "WHITE";
					else
						message += "BLACK";
					message += " player, please continue.";
					JOptionPane.showMessageDialog(null, message);
				}
			}
			
			if (gameEnded()) {
				gameEndedAction();
			}
			
		}
	}
	
	private boolean gameEnded() {
		if (counter == 60)
			return true;
		if (playerBlack == 0 || playerWhite == 0)
			return true;
		return false;
	}
	
	private void gameEndedAction() {
		
		String message = "--- GAME ENDED --- RESULTS ---\n\n";
		message += "Black Player: " + playerBlack + "\n";
		message += "White Player: " + playerWhite + "\n\n";
		
		if (playerBlack == playerWhite)
			message += "This is a DRAW GAME!\n\n";
		else {
			if (playerBlack > playerWhite) {
				message += "Black Player WINS!\n\n";
			} else {
				message += "White Player WINS!\n\n";
			}
		}
		message += "Would you two like to play again?";
		
		if (JOptionPane.showConfirmDialog(this, message, "End Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			initializeGame();
		} else {
			System.exit(0);
		}
		
	}
	
	private boolean noValidMove() {
		int i, j;
		for (i=0;i<8;i++) {
			for (j=0;j<8;j++) {
				temp = chess[i][j];
				if (isValidMove())
					return false;
			}
		}
		return true;
	}
	
	private boolean isValidMove() {
		
		int row = temp.getRow();
		int column = temp.getColumn();
		
		if (temp.isOccupied())
			return false;

		if (isToRightValid())
			return true;
		
		if (isToLeftValid())
			return true;
		
		if (isToBelowValid())
			return true;
		
		if (isToAboveValid())
			return true;
		
		if (isToBottomRightValid())
			return true;
		
		if (isToTopLeftValid())
			return true;
		
		if (isToBottomLeftValid())
			return true;
		
		if (isToTopRightValid())
			return true;
		
		return false;
	}
	
	private boolean isToRightValid() {
		if (temp.getColumn() < 6) {
			int row = temp.getRow();
			int column = temp.getColumn()+1;
			if (chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
				column++;
				while (column < 7 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					column++;
				}
				if (chess[row][column].isOccupied() && chess[row][column].getOwner() == currentPlayer)
					return true;
			}
		}
		return false;
	}
	
	private boolean isToLeftValid() {
		if (temp.getColumn() > 1) {
			int row = temp.getRow();
			int column = temp.getColumn()-1;
			if (chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
				column--;
				while (column > 0 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					column--;
				}
				if (chess[row][column].isOccupied() && chess[row][column].getOwner() == currentPlayer)
					return true;
			}
		}
		return false;
	}
	
	private boolean isToBelowValid() {
		if (temp.getRow() < 6) {
			int row = temp.getRow()+1;
			int column = temp.getColumn();
			if (chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
				row++;
				while (row < 7 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					row++;
				}
				if (chess[row][column].isOccupied() && chess[row][column].getOwner() == currentPlayer)
					return true;
			}
		}
		return false;
	}
	
	private boolean isToAboveValid() {
		if (temp.getRow() > 1) {
			int row = temp.getRow()-1;
			int column = temp.getColumn();
			if (chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
				row--;
				while (row > 0 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					row--;
				}
				if (chess[row][column].isOccupied() && chess[row][column].getOwner() == currentPlayer)
					return true;
			}
		}
		return false;
	}
	
	private boolean isToBottomRightValid() {
		if (temp.getRow() < 6 && temp.getColumn() < 6) {
			int row = temp.getRow()+1;
			int column = temp.getColumn()+1;
			if (chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
				row++; column++;
				while (row < 7 && column < 7 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					row++; column++;
				}
				if (chess[row][column].isOccupied() && chess[row][column].getOwner() == currentPlayer)
					return true;
			}
		}
		return false;
	}
	
	private boolean isToTopLeftValid() {
		if (temp.getRow() > 1 && temp.getColumn() > 1) {
			int row = temp.getRow()-1;
			int column = temp.getColumn()-1;
			if (chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
				row--; column--;
				while (row > 0 && column > 0 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					row--; column--;
				}
				if (chess[row][column].isOccupied() && chess[row][column].getOwner() == currentPlayer)
					return true;
			}
		}
		return false;
	}
	
	private boolean isToBottomLeftValid() {
		if (temp.getRow() < 6 && temp.getColumn() > 1) {
			int row = temp.getRow()+1;
			int column = temp.getColumn()-1;
			if (chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
				row++; column--;
				while (row < 7 && column > 0 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					row++; column--;
				}
				if (chess[row][column].isOccupied() && chess[row][column].getOwner() == currentPlayer)
					return true;
			}
		}
		return false;
	}
	
	private boolean isToTopRightValid() {
		if (temp.getRow() > 1 && temp.getColumn() < 6) {
			int row = temp.getRow()-1;
			int column = temp.getColumn()+1;
			if (chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
				row--; column++;
				while (row > 0 && column < 7 && chess[row][column].isOccupied() && chess[row][column].getOwner() != currentPlayer) {
					row--; column++;
				}
				if (chess[row][column].isOccupied() && chess[row][column].getOwner() == currentPlayer)
					return true;
			}
		}
		return false;
	}
}
import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    private final int FIRST_X = 50;
    private final int FIRST_Y = 50;
    private final int BOX_SIDE_LENGTH = 100;
    private TicTacToeViewer window;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer window) {
        this.row = row;
        this.col = col;
        this.window = window;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g) {
        g.drawRect(FIRST_X + FIRST_X * row, col * FIRST_Y + FIRST_Y, BOX_SIDE_LENGTH, BOX_SIDE_LENGTH);

        if (this.isWinningSquare) {
            g.setColor(Color.green);
            g.fillRect(FIRST_X + FIRST_X * row, col * FIRST_Y + FIRST_Y, BOX_SIDE_LENGTH, BOX_SIDE_LENGTH);
        }

        Image image = null;
        if (this.marker.equals("X")) {
            image = new ImageIcon("Resources/X.png").getImage();
        }
        else if (this.marker.equals("O")) {
            image = new ImageIcon("Resources/O.png").getImage();
        }

        g.drawImage(image, FIRST_X + FIRST_X * row, col * FIRST_Y + FIRST_Y, window);

    }
}

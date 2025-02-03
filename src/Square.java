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


    private TicTacToeViewer window;
    private Image X;
    private Image O;

    private final int BOX_LENGTH;
    private final int BOX_WIDTH;

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

        this.BOX_LENGTH = (col + 1) * 50 + 100;
        this.BOX_WIDTH = (row + 1) * 50 + 100;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;

        this.X = new ImageIcon("Resources/X.png").getImage();
        this.O = new ImageIcon("Resources/O.png").getImage();
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
        g.drawRect(BOX_LENGTH, BOX_WIDTH, 50,50);

        if (this.isWinningSquare){
            g.setColor(Color.green);
            g.fillRect(BOX_LENGTH + 1, BOX_WIDTH + 1, 49,49);
            g.setColor(Color.black);
        }

        if (this.marker.equals("X")){
            g.drawImage(X,BOX_LENGTH, BOX_WIDTH,50,50, window);
        }
        else if (this.marker.equals("O")){
            g.drawImage(O,BOX_LENGTH, BOX_WIDTH,50,50, window);
        }
    }
}

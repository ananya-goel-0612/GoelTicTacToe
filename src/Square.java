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

    public static final int BOX_LENGTH = 50;
    public static final int BOX_WIDTH = 50;

    public static final int OFFSET = 100;

    private Image[] images;

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
        this.images = window.getImages();
        Image X = images[0];
        Image O = images[1];

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
        int box_x = (col + 1) * BOX_WIDTH + OFFSET;
        int box_y = (row + 1) * BOX_LENGTH + OFFSET;


        if (this.isWinningSquare){
            g.setColor(Color.green);
            g.fillRect(box_x, box_y, BOX_WIDTH, BOX_LENGTH);
            g.setColor(Color.black);
        }

        g.drawRect(box_x, box_y, BOX_WIDTH,BOX_LENGTH);

        if (this.marker.equals("X")){
            g.drawImage(X, box_x, box_y,BOX_WIDTH,BOX_LENGTH, window);
        }
        else if (this.marker.equals("O")){
            g.drawImage(O, box_x, box_y,BOX_WIDTH,BOX_LENGTH, window);
        }
    }
}

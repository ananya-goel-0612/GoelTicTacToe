// The frontend for TicTacToe.java\
// Handles all the drawing/painting of the game

import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame{
    private final int WINDOW_WIDTH = 450;
    private final int WINDOW_HEIGHT = 500;
    private final TicTacToe game;

    private final Image[] images;

    // Where the win message should be drawn
    public static final int WIN_X = 140;
    public static final int WIN_Y = 400;

    // Coordinate for the row/col numbers
    public static final int NUM_COORDINATE = 130;

    public TicTacToeViewer(TicTacToe game) {
        this.game = game;

        // Downloads the images for the X and O
        this.images = new Image[2];
        this.images[0] = new ImageIcon("Resources/X.png").getImage();
        this.images[1] = new ImageIcon("Resources/O.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages() {
        return this.images;
    }

    public void paint(Graphics g) {
        // Clears the window
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Goes through each row to draw the board and side numbers
        for (int i = 0; i < 3; i++) {
            drawSideNumbers(g, i);
            drawRow(g, i);
        }

        // Calls printWinner() if the game has been won
        if (game.getGameOver()) {
            printWinner(g);
        }
    }

    // Draws the row/col numbers in pairs (i.e. 0 and 0, 1 and 1, 2 and 2)
    public void drawSideNumbers(Graphics g, int i) {
        g.setColor(Color.red);
        int side_coordinate = (i + 1) * Square.BOX_WIDTH + NUM_COORDINATE;

        g.drawString(Integer.toString(i), side_coordinate, NUM_COORDINATE);
        g.drawString(Integer.toString(i), NUM_COORDINATE, side_coordinate);

    }

    // Draws the board by row
    public void drawRow(Graphics g, int i) {
        g.setColor(Color.black);
        for (int j = 0; j < 3; j++) {
            game.getBoard()[i][j].draw(g);
        }
    }

    // If the game is won, the winner is printed out or it prints a tie
    public void printWinner(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 20));

        if (game.checkTie()) {
            g.drawString("It's a Tie", WIN_X, WIN_Y);
        }
        else {
            g.drawString(game.getWinner() + " WINS", WIN_X, WIN_Y);
        }
    }
}
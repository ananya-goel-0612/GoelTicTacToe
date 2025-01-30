import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private final int TITLE_BAR_HEIGHT = 23;
    private Square[][] board;

    public TicTacToeViewer(Square[][] board) {
        // TODO: Initialize instance variables
        this.board = board;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("The Aquarium");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        // Resets the board
        g.setColor(Color.WHITE);
        g.fillRect(0, TITLE_BAR_HEIGHT, 1000, 800);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].draw(g);
            }
        }

    }
}

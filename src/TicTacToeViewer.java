import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private final int TITLE_BAR_HEIGHT = 23;
    private TicTacToe game;
    private Square[][] board;

    public TicTacToeViewer(TicTacToe game) {
        // TODO: Initialize instance variables
        this.game = game;
        this.board = game.getBoard();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        g.setColor(Color.BLACK);
        for (int i = 0; i < 3; i++) {
            g.drawString(String.valueOf(i), 100 + i * 100, 45);
            g.drawString(String.valueOf(i), 20, 100 + i * 100);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].draw(g);
            }
        }

        if (game.getGameOver()) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString(game.getWinner() + " Wins!", WINDOW_WIDTH / 2 - 50, WINDOW_HEIGHT - 50);
        }

    }
}

import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    private final int WINDOW_WIDTH = 450;
    private final int WINDOW_HEIGHT = 500;
    private final int TITLE_BAR_HEIGHT = 23;
    private TicTacToe game;

    private Image[] images;

    public TicTacToeViewer(TicTacToe game) {
        // TODO: Initialize instance variables
        this.game = game;

        images = new Image[2];
        images[0] = new ImageIcon("Resources/X.png").getImage();
        images[1] = new ImageIcon("Resources/O.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages() {
        return images;
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.black);

        for (int i = 0; i < 3; i++) {
            g.drawString(Integer.toString(i), (i + 1) * 50 + 120, 130);
            g.drawString(Integer.toString(i), 130, (i + 1) * 50 + 120);

            for (int j = 0; j < 3; j++) {
                game.getBoard()[i][j].draw(g);
            }
        }

        if (game.getGameOver()) {
            g.setFont(new Font("Arial", Font.BOLD, 20));

            if (game.checkTie()) {
                g.drawString("It's a Tie", 140, 400);
            }
            else {
                g.drawString(game.getWinner() + " WINS", 140, 400);
            }
        }

    }
}

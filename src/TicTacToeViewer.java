import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame{
    private final int WINDOW_WIDTH = 450;
    private final int WINDOW_HEIGHT = 500;
    private final int TITLE_BAR_HEIGHT = 23;
    private final TicTacToe game;

    private final Image[] images;

    public TicTacToeViewer(TicTacToe game) {
        this.game = game;

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
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        for (int i = 0; i < 3; i++) {
            drawNumbers(g, i);

            drawBoard(g, i);
        }

        if (game.getGameOver()) {
            printWinner(g);
        }
    }

    public void drawNumbers(Graphics g, int i) {
        g.setColor(Color.red);
        g.drawString(Integer.toString(i), (i + 1) * 50 + 120, 130);
        g.drawString(Integer.toString(i), 130, (i + 1) * 50 + 120);
    }

    public void drawBoard(Graphics g, int i) {
        g.setColor(Color.black);
        for (int j = 0; j < 3; j++) {
            game.getBoard()[i][j].draw(g);
        }
    }

    public void printWinner(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 20));

        if (game.checkTie()) {
            g.drawString("It's a Tie", 140, 400);
        }
        else {
            g.drawString(game.getWinner() + " WINS", 140, 400);
        }
    }
}
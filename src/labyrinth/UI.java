package labyrinth;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UI implements Runnable {

    private JFrame frame;
    private Character player;
    private Board board;
    private Monster monster;
    private Graph graph;

    public UI(Character p) {
        player = p;
    }

    private void createComponents(Container container) {
        board = new Board(50, 50);
        makeChars();
        board.setPlayer(player);
        frame.addKeyListener(new Listener(player, board, board.getGrid(), graph, monster));

        container.add(board);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void makeChars() {

        Random r = new Random();
        int t = 0;
        int tt = 0;
        for (int i = 0; i < 300; i++) {//make walls
            while (true) {
                t = r.nextInt(50) * 10;
                tt = r.nextInt(50) * 10;
                if (board.getGrid()[t / 10][tt / 10] == 0) {
                    break;
                }
            }
            Wall w = new Wall(t, tt);
            board.addCharacter(w);
        }
        graph = new Graph(board.getGrid());
        monster = new Monster(450, 450);
        monster.addPlayer(player);
        board.addCharacter(monster);
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Shadow s = new Shadow(i * 10, j * 10);
                s.setPlayer(player);
                s.addGrid(board.getGrid());
                board.addShadow(s);
            }
        }

    }

    @Override
    public void run() {
        frame = new JFrame("Labyrinth");
        frame.setPreferredSize(new Dimension(520, 540));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

}

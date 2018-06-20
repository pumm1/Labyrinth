package labyrinth;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class Listener implements KeyListener {

    private Component component;
    private Character player;
    int[][] grid;
    private Graph graph;
    private Monster monster;
    public Listener(Character p, Component c, int[][] g, Graph gr, Monster m) {
        component = c;
        player = p;
        grid = g;
        graph = gr;
        monster = m;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent k) {
        int i = 0;
        if (k.getKeyCode() == KeyEvent.VK_UP) {
            player.move(0, -10);
            i++;
        } else if (k.getKeyCode() == KeyEvent.VK_DOWN) {
            player.move(0, 10);
            i++;
        } else if (k.getKeyCode() == KeyEvent.VK_LEFT) {
            player.move(-10, 0);
            i++;
        } else if (k.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.move(10, 0);
            i++;
        }
        if (i != 0) {
//            System.out.println("repaint");
            monster.shortestPath(graph);
            monster.move();
            component.repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}

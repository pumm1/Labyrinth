package labyrinth;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Stack;

/*
TODO:
-monster uses graph BFS to map its route to the player
 */
public class Monster extends Character {

    private Character player;
    private Node next = null;

    public Monster(int a, int b) {
        super(a, b);
    }

    public void addPlayer(Character p) {
        player = p;
    }

    public void move() {
        if (next != null) {
            int i = next.getX();
            int j = next.getY();

            if (getX() < i) {
                x += 10;
            } else if (getX() > i) {
                x -= 10;
            } else if (getY() < j) {
                y += 10;
            } else {
                y -= 10;
            }

        }
    }

    public void shortestPath(Graph g) {
        
        Node[][] nGrid = g.getNodeGrid();
        Node s = nGrid[getX()][getY()];
        System.out.println("*******");
        System.out.println("x: " + getX() + ", y:" + getY());
        System.out.println("nGrid[x][y]: " + nGrid[getX()][getY()]);
        System.out.println("s: x" + s.getX() + ", y: " + s.getY());
        System.out.println("*******");
//        Node v = nGrid[player.getX()][player.getY()];
        g.BFS(s);
        Node u = g.getNodeGrid()[player.getX()][player.getY()];
        if(u != null){
            System.out.println("u: " + u.getX() + " - " + u.getY());
        }
        u = u.getPrev();
        while (u != s && u != null) {
            next = u;
            u = u.getPrev();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 10, 10);
    }

}

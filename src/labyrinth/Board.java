package labyrinth;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    protected int[][] grid;
    protected Character player;
    protected List<Character> characters;
    Timer timer = new Timer(30, this);

    public Board(int w, int h) {
        super.setBackground(Color.white);
        characters = new ArrayList<>();
        timer.start();
        grid = new int[50][50];
//        System.out.println("grid[0][0]: " + grid[0][0]);
//        System.out.println("grid[49][49]: " + grid[49][49]);

    }

    public Timer getTimer() {
        return timer;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setPlayer(Character p) {
        player = p;
        player.addGrid(grid);
        characters.add(p);
    }

    public void addCharacter(Character i) {
        characters.add(i);
        i.addGrid(grid);
//        System.out.println("i.x: " + i.getX() + "\t i.y: " + i.getY());
        grid[i.getX()][i.getY()] = 1;
    }

    public void addShadow(Shadow i) {
        i.addGrid(grid);
        characters.add(i);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Character i : characters) {
            i.draw(g);
        }
    }

//    @Override
//    public void keyTyped(KeyEvent k) {
//    }
//
//    @Override
//    public void keyPressed(KeyEvent k) {
//        if (k.getKeyCode() == KeyEvent.VK_UP) {
//            player.move(0, -10);
//            System.out.println("up!");
//        } else if (k.getKeyCode() == KeyEvent.VK_DOWN) {
//            player.move(0, 10);
//            System.out.println("down!");
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
//            System.out.println("repaint!");
//            repaint();
        }
    }
}

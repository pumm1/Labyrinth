package labyrinth;

import java.awt.Color;
import java.awt.Graphics;

public class Character {

    protected int x;
    protected int y;
    protected int grid[][];

    public Character(int a, int b) {
        x = a;
        y = b;
    }

    public void move(int a, int b) {
        int i = getX();
        int j = getY();
        int aa = a / 10;
        int bb = b / 10;
        if (i + aa >= 0 && i + aa < 50) {
            if (j + bb >= 0 && j + bb < 50) {
                if (grid[i + aa][j + bb] == 0) {
                    x += a;
                    y += b;
                }
            }
        }
    }

    public void addGrid(int g[][]) {
        grid = g;
    }

    public int getX() {
        return x / 10;
    }

    public int getY() {
        return y / 10;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 10, 10);
    }

}

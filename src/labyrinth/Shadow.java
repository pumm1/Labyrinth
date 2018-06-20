package labyrinth;

import java.awt.Color;
import java.awt.Graphics;

public class Shadow extends Character {

    Character player;

    public Shadow(int a, int b) {
        super(a, b);
    }

    public void setPlayer(Character p) {
        player = p;
    }

    /*SEEMS TO WORK*/
    public boolean checkShadow() {
        int px = player.getX();
        int py = player.getY();
        int i = getX();
        int j = getY();
        if (i == px && j == py) {
            return false;
        }
        if (i == px) {//same x-line
            if (j < py) {//above
                for (int a = 1; a < 4; a++) {
                    if (j + a < py) {
                        if (grid[i][j + a] == 1) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            } else {//below
                for (int a = 1; a < 4; a++) {
                    if (j - a >= py) {
                        if (grid[i][j - a] == 1) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else if (j == py) {//same y-line
            if (i < px) {//left
                for (int a = 1; a < 4; a++) {
                    if (i + a < px) {
                        if (grid[i + a][j] == 1) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            } else {//right
                for (int a = 1; a < 4; a++) {
                    if (i - a >= px) {
                        if (grid[i - a][j] == 1) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            }

        } else if (i < px) {//left side
            if (j < py) {//above

                if (grid[i][j + 1] == 1) {
                    return true;
                }
                if (grid[i + 1][j + 1] == 1) {
                    return true;
                }
                if (grid[i + 1][j] == 1) {//
                    return true;
                }

            } else {//below

                if (grid[i][j - 1] == 1) {
                    return true;
                }

                if (grid[i + 1][j - 1] == 1) {
                    return true;
                }
                if (grid[i + 1][j] == 1) {//
                    return true;
                }

            }
        } else {//right side
            if (j < py) {//above
                if (grid[i][j + 1] == 1) {
                    return true;
                }
                if (grid[i - 1][j + 1] == 1) {
                    return true;
                }
                if (grid[i - 1][j] == 1) {//
                    return true;
                }

            } else {//below

                if (grid[i][j - 1] == 1) {
                    return true;
                }

                if (grid[i - 1][j - 1] == 1) {
                    return true;
                }
                if (grid[i - 1][j] == 1) {//
                    return true;
                }

            }
        }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);

        int i = player.getX();
        int j = player.getY();
        i = Math.abs(i - getX());
        j = Math.abs(j - getY());
        if (i + j <= 3) { //move shadow somewhere else
            if (checkShadow()) {
                if (grid[getX()][getY()] == 1) {
                    g.setColor(Color.gray);
                }
                g.fillRect(x, y, 10, 10);
            } else {
                g.fillRect(900, 900, 10, 10);
            }
        } else {
            g.fillRect(x, y, 10, 10);
        }
    }
}

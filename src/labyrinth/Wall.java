
package labyrinth;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Character{
    
    public Wall(int a, int b) {
        super(a, b);
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(x, y, 10, 10);
    }
    
}

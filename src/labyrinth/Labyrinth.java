package labyrinth;

import javax.swing.SwingUtilities;

public class Labyrinth {

    public static void main(String[] args) {
        Character player = new Character(10, 10);
        UI ui = new UI(player);
        SwingUtilities.invokeLater(ui);
    }

}

package GUI;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        Cards cards = new Cards();

        cards.setSize(500, 500);
        cards.setLocation(500, 200);
        cards.setResizable(false);
        cards.setVisible(true);
        cards.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
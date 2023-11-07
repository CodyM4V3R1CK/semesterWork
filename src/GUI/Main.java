package GUI;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        Cards cards = new Cards();

        cards.setSize(200, 200);
        cards.setVisible(true);
        cards.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
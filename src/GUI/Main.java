package GUI;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        CardLayoutExample1 crdl = new CardLayoutExample1();
        Cards cards = new Cards();

        crdl.setSize(500, 500);
        crdl.setVisible(false);
        crdl.setDefaultCloseOperation(EXIT_ON_CLOSE);

        cards.setSize(200, 200);
        cards.setVisible(false);
        cards.setDefaultCloseOperation(EXIT_ON_CLOSE);

        CardLayoutDemo.createAndShowGUI();
    }
}
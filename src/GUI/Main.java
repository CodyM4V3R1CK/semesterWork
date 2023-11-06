package GUI;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        CardLayoutExample1 crdl = new CardLayoutExample1();

        crdl.setSize(500, 500);
        crdl.setVisible(true);
        crdl.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample1 extends JFrame implements ActionListener {

    CardLayout crd;
    JButton btn1, btn2, btn3;
    Container cPane;

    CardLayoutExample1(){

        cPane = getContentPane();

//default constructor used
// therefore, components will
// cover the whole area
        crd = new CardLayout();

        cPane.setLayout(crd);

// creating the buttons
        btn1 = new JButton("Apple");
        btn2 = new JButton("Boy");
        btn3 = new JButton("Cat");

// adding listeners to it
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        cPane.add("a", btn1); // first card is the button btn1
        cPane.add("b", btn2); // first card is the button btn2
        cPane.add("c", btn3);  // first card is the button btn3

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        crd.next(cPane);
    }
}

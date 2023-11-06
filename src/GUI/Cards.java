package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cards extends JFrame implements ActionListener {

    CardLayout crd;
    JButton login, register;
    Container cPane;

    Cards(){
        cPane = getContentPane();
        crd = new CardLayout();
        cPane.setLayout(crd);

        login = new JButton("Login");
        register = new JButton("Register");

        login.addActionListener(this);
        register.addActionListener(this);

        cPane.add("a", login);
        cPane.add("b", register);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        crd.next(cPane);
    }
}

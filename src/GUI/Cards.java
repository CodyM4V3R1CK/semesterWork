package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cards extends JFrame implements ActionListener {

    CardLayout crd;
    JButton login, register, confirmLogin, confirmRegister;
    JPanel loginSelection, loginScreen, registerScreen;
    Container cPane;

    Cards(){
        cPane = getContentPane();
        crd = new CardLayout();
        cPane.setLayout(crd);

        loginSelection = new JPanel();
        loginScreen = new JPanel();
        registerScreen = new JPanel();

        login = new JButton("Login");
        register = new JButton("Register");
        confirmLogin = new JButton("confirmLogin");
        confirmRegister = new JButton("confirmRegister");

        login.addActionListener(this);
        register.addActionListener(this);
        confirmLogin.addActionListener(this);
        confirmRegister.addActionListener(this);

        loginSelection.add(login);
        loginSelection.add(register);

        loginScreen.add(confirmLogin);

        registerScreen.add(confirmRegister);

        cPane.add("loginSelection", loginSelection);
        cPane.add("confirmLogin", confirmLogin);
        cPane.add("confirmRegister", confirmRegister);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //crd.next(cPane);
        String command = e.getActionCommand();
        if(command.equals("Login")) {
            crd.show(cPane, "confirmLogin");
        }else if(command.equals("Register")){
            crd.show(cPane, "confirmRegister");
        }else{
            crd.show(cPane, "loginSelection");
        }
    }
}

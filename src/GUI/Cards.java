package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cards extends JFrame implements ActionListener {

    CardLayout crd;
    Container cPane;
    JButton login, register, confirmLogin, confirmRegister;
    JPanel loginSelection, loginScreen, registerScreen;
    JTextField loginUsername, loginPassword, registerUsername, registerPassword;

    Cards(){

        cPane = getContentPane();
        crd = new CardLayout();
        cPane.setLayout(crd);

        //creating panels
        loginSelection = new JPanel();
        loginScreen = new JPanel();
        registerScreen = new JPanel();

        //creating buttons
        login = new JButton("Login");
        register = new JButton("Register");
        confirmLogin = new JButton("confirmLogin");
        confirmRegister = new JButton("confirmRegister");

        //adding listeners to buttons
        login.addActionListener(this);
        register.addActionListener(this);
        confirmLogin.addActionListener(this);
        confirmRegister.addActionListener(this);

        //creating text fields
        loginUsername = new JTextField(20);
        loginPassword = new JTextField(20);
        registerUsername = new JTextField(20);
        registerPassword = new JTextField(20);

        //adding stuff to loginSelection panel
        loginSelection.add(login);
        loginSelection.add(register);

        //adding stuff to loginScreen panel
        loginScreen.add(loginUsername);
        loginScreen.add(loginPassword);
        loginScreen.add(confirmLogin);

        //adding stuff to registerScreen panel
        registerScreen.add(registerUsername);
        registerScreen.add(registerPassword);
        registerScreen.add(confirmRegister);

        //adding panels to cardLayout
        cPane.add("loginSelection", loginSelection);
        cPane.add("confirmLogin", confirmLogin);
        cPane.add("confirmRegister", confirmRegister);

    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //get current command (command name = button text)
        String command = e.getActionCommand();

        if(command.equals("Login")) {
            crd.show(cPane, "confirmLogin"); //change to confirmLogin on Login press
        }else if(command.equals("Register")){
            crd.show(cPane, "confirmRegister"); //change to confirmRegister on Register press
        }else{
            crd.show(cPane, "loginSelection");
        }
    }
}

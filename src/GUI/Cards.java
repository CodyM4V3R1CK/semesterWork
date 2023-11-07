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
    JLabel usernameRegisterL, passwordRegisterL, usernameLoginL, passwordLoginL;

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
        loginUsername = new JTextField(40);
        loginPassword = new JTextField(40);
        registerUsername = new JTextField(40);
        registerPassword = new JTextField(40);

        //don't allow text fields to expand beyond given limit
        loginUsername.setMaximumSize(loginUsername.getPreferredSize());
        loginPassword.setMaximumSize(loginPassword.getPreferredSize());
        registerUsername.setMaximumSize(registerUsername.getPreferredSize());
        registerPassword.setMaximumSize(registerPassword.getPreferredSize());

        //creating labels
        usernameRegisterL = new JLabel("Username");
        passwordRegisterL = new JLabel("Password");
        usernameLoginL = new JLabel("Username");
        passwordLoginL = new JLabel("Password");

        //adding stuff to loginSelection panel
        loginSelection.add(Box.createRigidArea(new Dimension(0, 50)));
        loginSelection.add(login);
        loginSelection.add(Box.createRigidArea(new Dimension(0, 50)));
        loginSelection.add(register);

        loginSelection.setLayout(new BoxLayout(loginSelection, BoxLayout.Y_AXIS));
        loginSelection.setBorder(BorderFactory.createEmptyBorder(125, 200, 0, 0));


        //adding stuff to loginScreen panel
        loginScreen.add(Box.createRigidArea(new Dimension(0, 100)));
        loginScreen.add(usernameLoginL);
        loginScreen.add(loginUsername);
        loginScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        loginScreen.add(passwordLoginL);
        loginScreen.add(loginPassword);
        loginScreen.add(Box.createRigidArea(new Dimension(75, 100)));
        loginScreen.add(confirmLogin);

        loginScreen.setLayout(new BoxLayout(loginScreen, BoxLayout.Y_AXIS));
        loginScreen.setBorder(BorderFactory.createEmptyBorder(0, 75, 0, 0));

        //adding stuff to registerScreen panel
        registerScreen.add(Box.createRigidArea(new Dimension(0, 100)));
        registerScreen.add(usernameRegisterL);
        registerScreen.add(registerUsername);
        registerScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        registerScreen.add(passwordRegisterL);
        registerScreen.add(registerPassword);
        registerScreen.add(Box.createRigidArea(new Dimension(75, 100)));
        registerScreen.add(confirmRegister);

        registerScreen.setLayout(new BoxLayout(registerScreen, BoxLayout.Y_AXIS));
        registerScreen.setBorder(BorderFactory.createEmptyBorder(0, 75, 0, 0));

        //adding panels to cardLayout
        cPane.add("loginSelection", loginSelection);
        cPane.add("confirmLogin", loginScreen);
        cPane.add("confirmRegister", registerScreen);
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

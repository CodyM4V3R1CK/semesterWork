package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cards extends JFrame implements ActionListener {

    CardLayout crd;
    Container cPane;
    JButton login, register;    //main screen selection
    JPanel loginSelection, loginScreen, registerScreen;

    //login screen GUI parts
    JButton confirmLogin;
    JTextField loginUsername, loginPassword;
    JLabel usernameLoginL, passwordLoginL;

    //register screen GUI parts
    JButton confirmRegister;
    JTextField registerUsername, registerPassword, registerPhone, registerEmail, registerDorm;
    JLabel usernameRegisterL, passwordRegisterL, phoneRegisterL, emailRegisterL, dormRegisterL;

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
        registerPhone = new JTextField(40);
        registerEmail = new JTextField(40);
        registerDorm = new JTextField(40);

        //don't allow text fields to expand beyond given limit
        loginUsername.setMaximumSize(loginUsername.getPreferredSize());
        loginPassword.setMaximumSize(loginPassword.getPreferredSize());
        registerUsername.setMaximumSize(registerUsername.getPreferredSize());
        registerPassword.setMaximumSize(registerPassword.getPreferredSize());
        registerPhone.setMaximumSize(registerPhone.getPreferredSize());
        registerEmail.setMaximumSize(registerEmail.getPreferredSize());
        registerDorm.setMaximumSize(registerDorm.getPreferredSize());

        //creating labels
        usernameRegisterL = new JLabel("Username:");
        passwordRegisterL = new JLabel("Password:");
        usernameLoginL = new JLabel("Username:");
        passwordLoginL = new JLabel("Password:");
        phoneRegisterL = new JLabel("Phone Number:");
        emailRegisterL = new JLabel("Email address:");
        dormRegisterL = new JLabel("Dorm Room:");

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
        registerScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        registerScreen.add(usernameRegisterL);
        registerScreen.add(registerUsername);
        registerScreen.add(Box.createRigidArea(new Dimension(0, 40)));
        registerScreen.add(passwordRegisterL);
        registerScreen.add(registerPassword);
        registerScreen.add(Box.createRigidArea(new Dimension(0, 40)));
        registerScreen.add(phoneRegisterL);
        registerScreen.add(registerPhone);
        registerScreen.add(Box.createRigidArea(new Dimension(0, 40)));
        registerScreen.add(emailRegisterL);
        registerScreen.add(registerEmail);
        registerScreen.add(Box.createRigidArea(new Dimension(0, 40)));
        registerScreen.add(dormRegisterL);
        registerScreen.add(registerDorm);
        registerScreen.add(Box.createRigidArea(new Dimension(75, 40)));
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

        switch (command) {
            case "Login" -> crd.show(cPane, "confirmLogin"); //change to confirmLogin on Login press
            case "Register" -> crd.show(cPane, "confirmRegister"); //change to confirmRegister on Register press
            case "confirmLogin" -> {
                String username = loginUsername.getText();
                String password = loginPassword.getText();
                System.out.println(username + " " + password);
                Test.testing();
                loginUsername.setText("");
                loginPassword.setText("");
                crd.show(cPane, "loginSelection"); //change to confirmLogin on Login press
            }
            case "confirmRegister" -> {
                String username = registerUsername.getText();
                String password = registerPassword.getText();
                String phoneNumber = registerPhone.getText();
                String email = registerEmail.getText();
                String dorm = registerDorm.getText();
                System.out.println(username + " " + password + " " + phoneNumber + " " + email + " " + dorm);
                registerUsername.setText("");
                registerPassword.setText("");
                crd.show(cPane, "loginSelection"); //change to confirmRegister on Register press
            }
            default -> crd.show(cPane, "loginSelection");
        }
    }
}

package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Cards extends JFrame implements ActionListener {

    CardLayout crd;
    Container cPane;
    JButton login, register;    //main screen selection
    JPanel loginSelectionScreen, loginScreen, registerScreen, userScreen, addBookScreen, getBooksScreen;

    //login screen GUI parts
    JButton confirmLogin;
    JTextField loginUsername, loginPassword;
    JLabel usernameLoginL, passwordLoginL;

    //register screen GUI parts
    JButton confirmRegister;
    JTextField registerUsername, registerPassword, registerPhone, registerEmail, registerDorm;
    JLabel usernameRegisterL, passwordRegisterL, phoneRegisterL, emailRegisterL, dormRegisterL;

    //user screen GUI parts
    JButton addBookButton, getBooksButton;

    //addBook screen GUI parts
    JButton addBookConfirm, addBookReturn;
    JLabel addBookNameL, addBookAuthorL, addBookOwnerL;
    JTextField addBookName, addBookAuthor, addBookOwner;

    //getBooks screen GUI parts
    JTextArea getBooksOutput;
    JButton getBooksReturn;

    //admin screen GUI parts

    Cards(){

        cPane = getContentPane();
        crd = new CardLayout();
        cPane.setLayout(crd);

        //creating panels
        loginSelectionScreen = new JPanel();
        loginScreen = new JPanel();
        registerScreen = new JPanel();
        userScreen = new JPanel();
        addBookScreen = new JPanel();
        getBooksScreen = new JPanel();

        //creating buttons
        login = new JButton("Login");
        register = new JButton("Register");
        confirmLogin = new JButton("confirmLogin");
        confirmRegister = new JButton("confirmRegister");
        addBookButton = new JButton("Add Book");
        addBookConfirm = new JButton("Add This Book");
        addBookReturn = new JButton("Back");
        getBooksButton = new JButton("Get Books");
        getBooksReturn = new JButton("Back");

        //adding listeners to buttons
        login.addActionListener(this);
        register.addActionListener(this);
        confirmLogin.addActionListener(this);
        confirmRegister.addActionListener(this);
        addBookButton.addActionListener(this);
        addBookReturn.addActionListener(this);
        getBooksButton.addActionListener(this);
        getBooksReturn.addActionListener(this);

        //creating text fields
        loginUsername = new JTextField(40);
        loginPassword = new JTextField(40);
        registerUsername = new JTextField(40);
        registerPassword = new JTextField(40);
        registerPhone = new JTextField(40);
        registerEmail = new JTextField(40);
        registerDorm = new JTextField(40);
        addBookAuthor = new JTextField(40);
        addBookName = new JTextField(40);
        addBookOwner = new JTextField(40);

        //don't allow text fields to expand beyond given limit
        loginUsername.setMaximumSize(loginUsername.getPreferredSize());
        loginPassword.setMaximumSize(loginPassword.getPreferredSize());
        registerUsername.setMaximumSize(registerUsername.getPreferredSize());
        registerPassword.setMaximumSize(registerPassword.getPreferredSize());
        registerPhone.setMaximumSize(registerPhone.getPreferredSize());
        registerEmail.setMaximumSize(registerEmail.getPreferredSize());
        registerDorm.setMaximumSize(registerDorm.getPreferredSize());
        addBookAuthor.setMaximumSize(addBookAuthor.getPreferredSize());
        addBookName.setMaximumSize(addBookName.getPreferredSize());
        addBookOwner.setMaximumSize(addBookOwner.getPreferredSize());

        //creating labels
        usernameRegisterL = new JLabel("Username:");
        passwordRegisterL = new JLabel("Password:");
        usernameLoginL = new JLabel("Username:");
        passwordLoginL = new JLabel("Password:");
        phoneRegisterL = new JLabel("Phone Number:");
        emailRegisterL = new JLabel("Email address:");
        dormRegisterL = new JLabel("Dorm Room:");
        addBookNameL = new JLabel("Name");
        addBookAuthorL = new JLabel("Author:");
        addBookOwnerL = new JLabel("Book Owner:");

        //creating text areas
        getBooksOutput = new JTextArea();

        //adding stuff to loginSelection panel
        loginSelectionScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        loginSelectionScreen.add(login);
        loginSelectionScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        loginSelectionScreen.add(register);

        loginSelectionScreen.setLayout(new BoxLayout(loginSelectionScreen, BoxLayout.Y_AXIS));
        loginSelectionScreen.setBorder(BorderFactory.createEmptyBorder(125, 200, 0, 0));


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

        //adding stuff to userScreen panel
        userScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        userScreen.add(addBookButton);
        userScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        userScreen.add(getBooksButton);

        userScreen.setLayout(new BoxLayout(userScreen, BoxLayout.Y_AXIS));
        userScreen.setBorder(BorderFactory.createEmptyBorder(125, 200, 0, 0));

        //adding stuff to addBook panel
        addBookScreen.add(addBookNameL);
        addBookScreen.add(addBookName);
        addBookScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        addBookScreen.add(addBookAuthorL);
        addBookScreen.add(addBookAuthor);
        addBookScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        addBookScreen.add(addBookOwnerL);
        addBookScreen.add(addBookOwner);
        addBookScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        addBookScreen.add(addBookConfirm);
        addBookScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        addBookScreen.add(addBookReturn);

        addBookScreen.setLayout(new BoxLayout(addBookScreen, BoxLayout.Y_AXIS));
        addBookScreen.setBorder(BorderFactory.createEmptyBorder(50, 125, 0, 0));

        //adding stuff to getBooks panel
        getBooksScreen.add(Box.createRigidArea(new Dimension(20, 20)));
        getBooksScreen.add(getBooksOutput);
        getBooksScreen.add(Box.createRigidArea(new Dimension(100, 20)));
        getBooksScreen.add(getBooksReturn);

        getBooksScreen.setLayout(new BoxLayout(getBooksScreen, BoxLayout.Y_AXIS));

        //adding panels to cardLayout
        cPane.add("loginSelection", loginSelectionScreen);
        cPane.add("confirmLogin", loginScreen);
        cPane.add("confirmRegister", registerScreen);
        cPane.add("userScreen", userScreen);
        cPane.add("addBook", addBookScreen);
        cPane.add("getBooks", getBooksScreen);
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
                if (Objects.equals(username, "admin") && Objects.equals(password, "admin")) crd.show(cPane, "userScreen");
            }
            case "Add Book" -> {
                //insert code for adding a book
                crd.show(cPane, "addBook");
            }
            case "Get Books" -> {
                String test = "Hell0 World";
                crd.show(cPane, "getBooks");
                getBooksOutput.setText(test);
            }
            case "Back" -> crd.previous(cPane);
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

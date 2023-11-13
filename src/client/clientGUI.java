package client;

import GUI.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.Objects;
import java.io.*;

public class clientGUI extends JFrame implements ActionListener {

    CardLayout crd;
    Container cPane;
    JButton login, register;    //main screen selection
    JPanel loginSelectionScreen, loginScreen, registerScreen, userScreen, addBookScreen, getBooksScreen,
            adminScreen, addBookAdminScreen, getBooksAdminScreen, removeBookAdminScreen, addUserAdminScreen;

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
    JLabel addBookNameL, addBookAuthorL;
    JTextField addBookName, addBookAuthor;

    //getBooks screen GUI parts
    JTextArea getBooksOutput;
    JButton getBooksReturn;

    //admin screen GUI parts
    JButton addBookButtonAdmin, getBooksButtonAdmin, removeBookButtonAdmin, addUserButtonAdmin;

    //addBookAdmin screen GUI parts
    JButton addBookConfirmAdmin, addBookReturnAdmin;
    JLabel addBookNameAdminL, addBookAuthorAdminL, addBookOwnerAdminL;
    JTextField addBookNameAdmin, addBookAuthorAdmin, addBookOwnerAdmin;

    //getBooksAdmin screen GUI parts
    JTextArea getBooksOutputAdmin;
    JButton getBooksReturnAdmin;

    //removeBookAdmin screen GUI parts
    JButton removeBookConfirmButtonAdmin;
    JTextField removeBookName;
    JLabel removeBookNameL;

    //addUserAdmin screen GUI parts
    JButton addUserConfirmButtonAdmin;
    JTextField addUserUsername, addUserPassword, addUserPhone, addUserEmail, addUserDorm;
    JLabel addUserUsernameL, addUserPasswordL, addUserPhoneL, addUserEmailL, addUserDormL;

    String output;
    Socket s = new Socket("localhost", 1050);// Create client socket
    DataOutputStream out = new DataOutputStream(s.getOutputStream());// to send data to the server
    BufferedReader server = new BufferedReader(new InputStreamReader(s.getInputStream()));// to read data coming from the server
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));// to read data from the keyboard


    clientGUI() throws Exception {

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

        adminScreen = new JPanel();
        addBookAdminScreen = new JPanel();
        getBooksAdminScreen = new JPanel();
        removeBookAdminScreen = new JPanel();
        addUserAdminScreen = new JPanel();

        //creating buttons
        login = new JButton("Login");
        register = new JButton("Register");

        confirmLogin = new JButton("confirmLogin");
        confirmRegister = new JButton("confirmRegister");

        addBookButton = new JButton("Add Book");
        addBookConfirm = new JButton("Add This Book");
        addBookReturn = new JButton("Back To User Menu");

        getBooksButton = new JButton("Get Books");
        getBooksReturn = new JButton("Back To User Menu");

        addBookButtonAdmin = new JButton("Add New Book");
        addBookConfirmAdmin = new JButton("Add The Book");
        addBookReturnAdmin = new JButton("Back To Admin Menu");

        getBooksButtonAdmin = new JButton("Show All Books");
        getBooksReturnAdmin = new JButton("Back To Admin Menu");

        removeBookButtonAdmin = new JButton("Remove Book");
        removeBookConfirmButtonAdmin = new JButton("Remove This Book");

        addUserButtonAdmin = new JButton("Add User");
        addUserConfirmButtonAdmin = new JButton("Add This User");

        //adding listeners to buttons
        login.addActionListener(this);
        register.addActionListener(this);

        confirmLogin.addActionListener(this);
        confirmRegister.addActionListener(this);

        addBookButton.addActionListener(this);
        addBookConfirm.addActionListener(this);
        addBookReturn.addActionListener(this);

        getBooksButton.addActionListener(this);
        getBooksReturn.addActionListener(this);

        addBookButtonAdmin.addActionListener(this);
        addBookConfirmAdmin.addActionListener(this);
        addBookReturnAdmin.addActionListener(this);

        getBooksButtonAdmin.addActionListener(this);
        getBooksReturnAdmin.addActionListener(this);

        removeBookButtonAdmin.addActionListener(this);

        addUserButtonAdmin.addActionListener(this);
        addUserConfirmButtonAdmin.addActionListener(this);

        removeBookConfirmButtonAdmin.addActionListener(this);

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

        addBookNameAdmin = new JTextField(40);
        addBookAuthorAdmin = new JTextField(40);
        addBookOwnerAdmin = new JTextField(40);

        removeBookName = new JTextField(40);

        addUserUsername = new JTextField(40);
        addUserPassword = new JTextField(40);
        addUserPhone = new JTextField(40);

        addUserEmail = new JTextField(40);
        addUserDorm = new JTextField(40);


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

        removeBookName.setMaximumSize(removeBookName.getPreferredSize());

        addBookNameAdmin.setMaximumSize(addBookNameAdmin.getPreferredSize());
        addBookAuthorAdmin.setMaximumSize(addBookAuthorAdmin.getPreferredSize());
        addBookOwnerAdmin.setMaximumSize(addBookOwnerAdmin.getPreferredSize());

        addUserUsername.setMaximumSize(addUserUsername.getPreferredSize());
        addUserPassword.setMaximumSize(addUserPassword.getPreferredSize());
        addUserPhone.setMaximumSize(addUserPhone.getPreferredSize());

        addUserEmail.setMaximumSize(addUserEmail.getPreferredSize());
        addUserDorm.setMaximumSize(addUserDorm.getPreferredSize());

        //creating labels
        usernameLoginL = new JLabel("Username:");
        passwordLoginL = new JLabel("Password:");

        usernameRegisterL = new JLabel("Username:");
        passwordRegisterL = new JLabel("Password:");
        phoneRegisterL = new JLabel("Phone Number:");
        emailRegisterL = new JLabel("Email Address:");
        dormRegisterL = new JLabel("Dorm Room:");

        addBookNameL = new JLabel("Name");
        addBookAuthorL = new JLabel("Author:");

        addBookNameAdminL = new JLabel("Book Name");
        addBookAuthorAdminL = new JLabel("Book Author");
        addBookOwnerAdminL = new JLabel("Book Owner");

        removeBookNameL = new JLabel("Book Name");

        addUserUsernameL = new JLabel("User Username:");
        addUserPasswordL = new JLabel("User Password:");
        addUserPhoneL = new JLabel("User Phone Number:");
        addUserEmailL = new JLabel("User Email Address:");
        addUserDormL = new JLabel("User Dorm Room:");

        //creating text areas
        getBooksOutput = new JTextArea();
        getBooksOutputAdmin = new JTextArea();

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

        //adding stuff to adminScreen
        adminScreen.add(addBookButtonAdmin);
        adminScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        adminScreen.add(getBooksButtonAdmin);
        adminScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        adminScreen.add(removeBookButtonAdmin);
        adminScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        adminScreen.add(addUserButtonAdmin);

        adminScreen.setLayout(new BoxLayout(adminScreen, BoxLayout.Y_AXIS));
        adminScreen.setBorder(BorderFactory.createEmptyBorder(75, 200, 0, 0));

        //adding stuff to addBookAdmin screen
        addBookAdminScreen.add(addBookNameAdminL);
        addBookAdminScreen.add(addBookNameAdmin);
        addBookAdminScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        addBookAdminScreen.add(addBookAuthorAdminL);
        addBookAdminScreen.add(addBookAuthorAdmin);
        addBookAdminScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        addBookAdminScreen.add(addBookOwnerAdminL);
        addBookAdminScreen.add(addBookOwnerAdmin);
        addBookAdminScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        addBookAdminScreen.add(addBookConfirmAdmin);
        addBookAdminScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        addBookAdminScreen.add(addBookReturnAdmin);

        addBookAdminScreen.setLayout(new BoxLayout(addBookAdminScreen, BoxLayout.Y_AXIS));
        addBookAdminScreen.setBorder(BorderFactory.createEmptyBorder(50, 125, 0, 0));

        //adding stuff to getBooksAdmin screen
        getBooksAdminScreen.add(Box.createRigidArea(new Dimension(20, 20)));
        getBooksAdminScreen.add(getBooksOutputAdmin);
        getBooksAdminScreen.add(Box.createRigidArea(new Dimension(100, 20)));
        getBooksAdminScreen.add(getBooksReturnAdmin);

        getBooksAdminScreen.setLayout(new BoxLayout(getBooksAdminScreen, BoxLayout.Y_AXIS));

        //adding stuff to removeBookAdmin screen
        removeBookAdminScreen.add(removeBookNameL);
        removeBookAdminScreen.add(removeBookName);
        removeBookAdminScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        removeBookAdminScreen.add(removeBookConfirmButtonAdmin);

        removeBookAdminScreen.setLayout(new BoxLayout(removeBookAdminScreen, BoxLayout.Y_AXIS));
        removeBookAdminScreen.setBorder(BorderFactory.createEmptyBorder(75, 125, 0, 0));

        //adding stuff to addUserAdmin screen
        addUserAdminScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        addUserAdminScreen.add(addUserUsernameL);
        addUserAdminScreen.add(addUserUsername);
        addUserAdminScreen.add(Box.createRigidArea(new Dimension(0, 40)));
        addUserAdminScreen.add(addUserPasswordL);
        addUserAdminScreen.add(addUserPassword);
        addUserAdminScreen.add(Box.createRigidArea(new Dimension(0, 40)));
        addUserAdminScreen.add(addUserPhoneL);
        addUserAdminScreen.add(addUserPhone);
        addUserAdminScreen.add(Box.createRigidArea(new Dimension(0, 40)));
        addUserAdminScreen.add(addUserEmailL);
        addUserAdminScreen.add(addUserEmail);
        addUserAdminScreen.add(Box.createRigidArea(new Dimension(0, 40)));
        addUserAdminScreen.add(addUserDormL);
        addUserAdminScreen.add(addUserDorm);
        addUserAdminScreen.add(Box.createRigidArea(new Dimension(0, 40)));
        addUserAdminScreen.add(addUserConfirmButtonAdmin);

        addUserAdminScreen.setLayout(new BoxLayout(addUserAdminScreen, BoxLayout.Y_AXIS));
        addUserAdminScreen.setBorder(BorderFactory.createEmptyBorder(0, 125, 0, 0));

        //adding panels to cardLayout
        cPane.add("loginSelection", loginSelectionScreen);
        cPane.add("confirmLogin", loginScreen);
        cPane.add("confirmRegister", registerScreen);
        cPane.add("userScreen", userScreen);
        cPane.add("addBook", addBookScreen);
        cPane.add("getBooks", getBooksScreen);
        cPane.add("adminScreen", adminScreen);
        cPane.add("addBookAdminScreen", addBookAdminScreen);
        cPane.add("getBooksAdminScreen", getBooksAdminScreen);
        cPane.add("removeBookAdminScreen", removeBookAdminScreen);
        cPane.add("addUserAdminScreen", addUserAdminScreen);
    }

    /**
     * Method for getting a command from button press
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //get current command (command name = button text)
        String command = e.getActionCommand();

        switch (command) {
            case "Login" -> {
                output = "SignIn";
                try {
                    out.writeBytes("SignIn\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("testing login");
                crd.show(cPane, "confirmLogin"); //change to confirmLogin on Login press
            }
            case "Register" -> crd.show(cPane, "confirmRegister"); //change to confirmRegister on Register press
            case "confirmLogin" -> {
                String username = loginUsername.getText();
                String password = loginPassword.getText();
                System.out.println(username + " " + password);
                Test.testing();
                loginUsername.setText("");
                loginPassword.setText("");
                //    out.writeBytes(output + "\n");// send to the server
                //    System.out.println(server.readLine().replace("#","\n"));// receive from the server
                if (Objects.equals(username, "user") && Objects.equals(password, "user")) crd.show(cPane, "userScreen");
                if (Objects.equals(username, "admin") && Objects.equals(password, "admin")) crd.show(cPane, "adminScreen");
            }
            case "Add Book" -> crd.show(cPane, "addBook");
            case "Add This Book" -> {
                String bookName = addBookName.getText();
                String bookAuthor = addBookAuthor.getText();
                System.out.println(bookName + " " + bookAuthor);
                crd.show(cPane, "userScreen");
            }
            case "Get Books" -> {
                String test = "Hell0 World";
                crd.show(cPane, "getBooks");
                getBooksOutput.setText(test);
            }
            case "Back To User Menu" -> crd.show(cPane, "userScreen");
            case "Back To Admin Menu" -> crd.show(cPane, "adminScreen");
            case "Add New Book" -> crd.show(cPane, "addBookAdminScreen");
            case "Add The Book" -> {
                String bookNameAdmin = addBookNameAdmin.getText();
                String bookAuthorAdmin = addBookAuthorAdmin.getText();
                String bookOwnerAdmin = addBookOwnerAdmin.getText();
                System.out.println(bookNameAdmin + " " + bookAuthorAdmin + " " + bookOwnerAdmin);
                crd.show(cPane, "adminScreen");
            }
            case "Show All Books" -> {
                String test = "Hell0 World";
                crd.show(cPane, "getBooksAdminScreen");
                getBooksOutputAdmin.setText(test);
            }
            case "Remove Book" -> crd.show(cPane, "removeBookAdminScreen");
            case "Remove This Book" -> {
                String bookName = removeBookName.getText();
                System.out.println(bookName);
                removeBookName.setText("");
                crd.show(cPane, "adminScreen");
            }
            case "Add User" -> crd.show(cPane, "addUserAdminScreen");
            case "Add This User" -> {
                String newUserUsername = addUserUsername.getText();
                String newUserPassword = addUserPassword.getText();
                String newUserPhoneNumber = addUserPhone.getText();
                String newUserEmail = addUserEmail.getText();
                String newUserDorm = addUserDorm.getText();
                System.out.println(newUserUsername + " " + newUserPassword + " " + newUserPhoneNumber + " " + newUserEmail + " " + newUserDorm);
                addUserUsername.setText("");
                addUserPassword.setText("");
                addUserPhone.setText("");
                addUserEmail.setText("");
                addUserDorm.setText("");
                crd.show(cPane, "adminScreen");
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
                registerPhone.setText("");
                registerEmail.setText("");
                registerDorm.setText("");
                crd.show(cPane, "loginSelection"); //change to confirmRegister on Register press
            }
            default -> crd.show(cPane, "loginSelection");
        }
    }
}

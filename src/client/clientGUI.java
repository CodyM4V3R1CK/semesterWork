package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.Objects;
import java.io.*;

public class clientGUI extends JFrame implements ActionListener {

    //defining gui components
    CardLayout crd;
    Container cPane;
    JPanel loginSelectionScreen, loginScreen, registerScreen, userScreen, addBookScreen, getBooksScreen,
            adminScreen, addBookAdminScreen, getBooksAdminScreen, removeBookAdminScreen, addUserAdminScreen,
            getBookInfoScreen, getBookInfoOutputScreen, getBookInfoAdminScreen, getBookInfoOutputAdminScreen,
            lendBookScreen, returnBookScreen, returnBookAdminScreen, getUserInfoScreen, getUserInfoAdminScreen,
            getUserInfoOutputScreen, getUserInfoOutputAdminScreen;

    //main screen GUI parts
    JButton login, register;
    //login screen GUI parts
    JButton confirmLogin, loginReturn;
    JTextField loginUsername;
    JPasswordField loginPassword;
    JLabel usernameLoginL, passwordLoginL;

    //register screen GUI parts
    JButton confirmRegister, registerReturn;
    JTextField registerUsername, registerPhone, registerEmail, registerDorm;
    JTextField registerPassword;
    JLabel usernameRegisterL, passwordRegisterL, phoneRegisterL, emailRegisterL, dormRegisterL;

    //user screen GUI parts
    JButton addBookButton, getBooksButton, getBookInfoButton, lendBookButton, returnBookButton, getUserInfoButton;

    //addBook screen GUI parts
    JButton addBookConfirm, addBookReturn;
    JLabel addBookNameL, addBookAuthorL;
    JTextField addBookName, addBookAuthor;

    //getBooks screen GUI parts
    JTextArea getBooksOutput;
    JButton getBooksReturn;

    //getBookInfo screen GUI parts
    JLabel getBookInfoNameL;
    JTextField getBookInfoName;
    JButton getBookConfirm, getBookInfoReturnButton;

    //getBookInfoOutput screen GUI parts
    JTextArea getBookInfoOutput;
    JButton getBookInfoOutputReturnButton;

    //admin screen GUI parts
    JButton addBookButtonAdmin, getBooksButtonAdmin, removeBookButtonAdmin, addUserButtonAdmin, getBookInfoButtonAdmin,
            returnBookAdminButton, getUserInfoAdminButton;

    //addBookAdmin screen GUI parts
    JButton addBookConfirmAdmin, addBookReturnAdmin;
    JLabel addBookNameAdminL, addBookAuthorAdminL, addBookOwnerAdminL;
    JTextField addBookNameAdmin, addBookAuthorAdmin, addBookOwnerAdmin;

    //getBooksAdmin screen GUI parts
    JTextArea getBooksOutputAdmin;
    JButton getBooksReturnAdmin;

    //getBookInfoAdmin screen GUI parts
    JLabel getBookInfoNameAdminL;
    JTextField getBookInfoNameAdmin;
    JButton getBookInfoConfirmAdminButton, getBookInfoReturnAdminButton;

    //getBookInfoAdminOutput screen GUI parts
    JTextArea getBookInfoOutputAdmin;
    JButton getBookInfoOutputReturnAdminButton;

    //removeBookAdmin screen GUI parts
    JButton removeBookConfirmButtonAdmin, removeBookReturnAdminButton;
    JTextField removeBookName;
    JLabel removeBookNameL;

    //addUserAdmin screen GUI parts
    JButton addUserConfirmButtonAdmin, addUserReturnAdminButton;
    JTextField addUserUsername, addUserPassword, addUserPhone, addUserEmail, addUserDorm;
    JLabel addUserUsernameL, addUserPasswordL, addUserPhoneL, addUserEmailL, addUserDormL;

    //lendBook screen GUI parts
    JButton lendBookConfirmButton, lendBookReturnButton;
    JLabel lendBookNameL;
    JTextField lendBookName;

    //returnBook screen GUI parts
    JButton returnBookConfirmButton, returnBookReturnButton;
    JLabel returnBookNameL;
    JTextField returnBookName;

    //returnBookAdmin screen GUI parts
    JButton returnBookConfirmAdminButton, returnBookReturnAdminButton;
    JLabel returnBookNameAdminL;
    JTextField returnBookNameAdmin;

    //getUserInfo screen GUI parts
    JButton getUserInfoConfirmButton, getUserInfoReturnButton;
    JLabel getUserInfoNameL;
    JTextField getUserInfoName;

    //getUserInfoOutput screen GUI parts
    JButton getUserInfoOutputReturnButton;
    JTextArea getUserInfoOutput;

    //getUserInfoAdmin screen GUI parts
    JButton getUserInfoConfirmAdminButton, getUserInfoReturnAdminButton;
    JLabel getUserInfoNameAdminL;
    JTextField getUserInfoNameAdmin;

    //getUserInfoAdminOutput screen GUI parts
    JButton getUserInfoOutputReturnAdminButton;
    JTextArea getUserInfoOutputAdmin;

    //initializing connection, buffers, etc.

    Socket s = new Socket("localhost", 1050);// Create client socket
    DataOutputStream out = new DataOutputStream(s.getOutputStream());// to send data to the server
    BufferedReader server = new BufferedReader(new InputStreamReader(s.getInputStream()));// to read data coming from the server


    clientGUI() throws Exception {

        //initializing pages

        cPane = getContentPane();
        crd = new CardLayout();
        cPane.setLayout(crd);

        //creating panels
        //login selection
        loginSelectionScreen = new JPanel();
        loginScreen = new JPanel();
        registerScreen = new JPanel();

        //user screen
        userScreen = new JPanel();
        addBookScreen = new JPanel();
        getBooksScreen = new JPanel();
        getBookInfoScreen = new JPanel();
        getBookInfoOutputScreen = new JPanel();
        lendBookScreen = new JPanel();
        returnBookScreen = new JPanel();
        getUserInfoScreen = new JPanel();
        getUserInfoOutputScreen = new JPanel();

        //admin screen
        adminScreen = new JPanel();
        addBookAdminScreen = new JPanel();
        getBooksAdminScreen = new JPanel();
        getBookInfoAdminScreen = new JPanel();
        getBookInfoOutputAdminScreen = new JPanel();
        removeBookAdminScreen = new JPanel();
        addUserAdminScreen = new JPanel();
        returnBookAdminScreen = new JPanel();
        getUserInfoAdminScreen = new JPanel();
        getUserInfoOutputAdminScreen = new JPanel();

        //creating buttons
        //login selection
        login = new JButton("Login");
        register = new JButton("Register");

        confirmLogin = new JButton("confirmLogin");
        confirmRegister = new JButton("confirmRegister");
        loginReturn = new JButton("Back To Login Selection");
        registerReturn = new JButton("Back To Login Selection");

        //user screen
        addBookButton = new JButton("Add Book");
        addBookConfirm = new JButton("Add New Book");
        addBookReturn = new JButton("Back To User Menu");

        getBooksButton = new JButton("Show All Books");
        getBooksReturn = new JButton("Back To User Menu");

        getBookInfoButton = new JButton("Get Book Info");
        getBookConfirm = new JButton("Get Book Info");
        getBookInfoReturnButton = new JButton("Back To User Menu");
        getBookInfoOutputReturnButton = new JButton("Back To User Menu");

        lendBookButton = new JButton("Lend Book");
        lendBookConfirmButton = new JButton("Lend This Book");
        lendBookReturnButton = new JButton("Back To User Menu");

        returnBookButton = new JButton("Return Book");
        returnBookConfirmButton = new JButton("Return This Book");
        returnBookReturnButton = new JButton("Back To User Menu");

        getUserInfoButton = new JButton("Get User Info");
        getUserInfoConfirmButton = new JButton("Get User Info");
        getUserInfoReturnButton = new JButton("Back To User Menu");
        getUserInfoOutputReturnButton = new JButton("Back To User Menu");

        //admin screen
        addBookButtonAdmin = new JButton("Add Book");
        addBookConfirmAdmin = new JButton("Add New Book");
        addBookReturnAdmin = new JButton("Back To Admin Menu");

        getBooksButtonAdmin = new JButton("Show All Books");
        getBooksReturnAdmin = new JButton("Back To Admin Menu");

        getBookInfoButtonAdmin = new JButton("Get Book Info");
        getBookInfoConfirmAdminButton = new JButton("Get Book Info ");
        getBookInfoReturnAdminButton = new JButton("Back To Admin Menu");
        getBookInfoOutputReturnAdminButton = new JButton("Back To Admin Menu");

        removeBookButtonAdmin = new JButton("Remove Book");
        removeBookConfirmButtonAdmin = new JButton("Remove This Book");
        removeBookReturnAdminButton = new JButton("Back To Admin Menu");

        addUserButtonAdmin = new JButton("Add User");
        addUserConfirmButtonAdmin = new JButton("Add This User");
        addUserReturnAdminButton = new JButton("Back To Admin Menu");

        returnBookAdminButton = new JButton("Return Book");
        returnBookConfirmAdminButton = new JButton("Return This Book");
        returnBookReturnAdminButton = new JButton("Back To Admin Menu");

        getUserInfoAdminButton = new JButton("Get The User Info");
        getUserInfoConfirmAdminButton = new JButton("Get Info On This User");
        getUserInfoReturnAdminButton = new JButton("Back To Admin Menu");
        getUserInfoOutputReturnAdminButton = new JButton("Back To Admin Menu");

        //adding listeners to buttons
        //login selection
        login.addActionListener(this);
        register.addActionListener(this);

        confirmLogin.addActionListener(this);
        confirmRegister.addActionListener(this);
        loginReturn.addActionListener(this);
        registerReturn.addActionListener(this);

        //user screen
        addBookButton.setActionCommand("Add Book User");
        addBookButton.addActionListener(this);
        addBookConfirm.setActionCommand("Add Book Confirm User");
        addBookConfirm.addActionListener(this);
        addBookReturn.addActionListener(this);

        getBooksButton.setActionCommand("Get Books User");
        getBooksButton.addActionListener(this);
        getBooksReturn.addActionListener(this);

        getBookInfoButton.setActionCommand("Get Book Info User");
        getBookInfoButton.addActionListener(this);
        getBookConfirm.setActionCommand("Get Book Info Confirm User");
        getBookConfirm.addActionListener(this);
        getBookInfoReturnButton.addActionListener(this);
        getBookInfoOutputReturnButton.addActionListener(this);

        lendBookButton.addActionListener(this);
        lendBookConfirmButton.addActionListener(this);
        lendBookReturnButton.addActionListener(this);

        returnBookButton.setActionCommand("Return Book User");
        returnBookButton.addActionListener(this);
        returnBookConfirmButton.setActionCommand("Return Book Confirm User");
        returnBookConfirmButton.addActionListener(this);
        returnBookReturnButton.addActionListener(this);

        getUserInfoButton.setActionCommand("Get User Info User");
        getUserInfoButton.addActionListener(this);
        getUserInfoConfirmButton.setActionCommand("Get User Info Confirm User");
        getUserInfoConfirmButton.addActionListener(this);
        getUserInfoReturnButton.addActionListener(this);
        getUserInfoOutputReturnButton.addActionListener(this);

        //admin screen
        addBookButtonAdmin.setActionCommand("Add Book Admin");
        addBookButtonAdmin.addActionListener(this);
        addBookConfirmAdmin.setActionCommand("Add Book Confirm Admin");
        addBookConfirmAdmin.addActionListener(this);
        addBookReturnAdmin.addActionListener(this);

        getBooksButtonAdmin.setActionCommand("Get Books Admin");
        getBooksButtonAdmin.addActionListener(this);
        getBooksReturnAdmin.addActionListener(this);

        getBookInfoButtonAdmin.setActionCommand("Get Book Info Admin");
        getBookInfoButtonAdmin.addActionListener(this);
        getBookInfoConfirmAdminButton.setActionCommand("Get Book Info Confirm Admin");
        getBookInfoConfirmAdminButton.addActionListener(this);
        getBookInfoReturnAdminButton.addActionListener(this);
        getBookInfoOutputReturnAdminButton.addActionListener(this);

        removeBookButtonAdmin.addActionListener(this);
        removeBookConfirmButtonAdmin.addActionListener(this);
        removeBookReturnAdminButton.addActionListener(this);

        addUserButtonAdmin.addActionListener(this);
        addUserConfirmButtonAdmin.addActionListener(this);
        addUserReturnAdminButton.addActionListener(this);

        returnBookAdminButton.setActionCommand("Return Book Admin");
        returnBookAdminButton.addActionListener(this);
        returnBookConfirmAdminButton.setActionCommand("Return Book Confirm Admin");
        returnBookConfirmAdminButton.addActionListener(this);
        returnBookReturnAdminButton.addActionListener(this);

        getUserInfoAdminButton.setActionCommand("Get User Info Admin");
        getUserInfoAdminButton.addActionListener(this);
        getUserInfoConfirmAdminButton.setActionCommand("Get User Info Confirm Admin");
        getUserInfoConfirmAdminButton.addActionListener(this);
        getUserInfoReturnAdminButton.addActionListener(this);
        getUserInfoOutputReturnAdminButton.addActionListener(this);

        //creating text fields
        //login selection
        loginUsername = new JTextField(40);
        loginPassword = new JPasswordField(40);

        registerUsername = new JTextField(40);
        registerPassword = new JPasswordField(40);
        registerPhone = new JTextField(40);
        registerEmail = new JTextField(40);
        registerDorm = new JTextField(40);

        //user screen
        addBookAuthor = new JTextField(40);
        addBookName = new JTextField(40);
        getBookInfoName = new JTextField(40);
        lendBookName = new JTextField(40);
        returnBookName = new JTextField(40);
        getUserInfoName = new JTextField(40);

        //user screen
        addBookNameAdmin = new JTextField(40);
        addBookAuthorAdmin = new JTextField(40);
        addBookOwnerAdmin = new JTextField(40);
        getBookInfoNameAdmin = new JTextField(40);
        removeBookName = new JTextField(40);
        addUserUsername = new JTextField(40);
        addUserPassword = new JTextField(40);
        addUserPhone = new JTextField(40);
        addUserEmail = new JTextField(40);
        addUserDorm = new JTextField(40);
        returnBookNameAdmin = new JTextField(40);
        getUserInfoNameAdmin = new JTextField(40);

        //don't allow text fields to expand beyond given limit
        //login selection
        loginUsername.setMaximumSize(loginUsername.getPreferredSize());
        loginPassword.setMaximumSize(loginPassword.getPreferredSize());

        registerUsername.setMaximumSize(registerUsername.getPreferredSize());
        registerPassword.setMaximumSize(registerPassword.getPreferredSize());
        registerPhone.setMaximumSize(registerPhone.getPreferredSize());
        registerEmail.setMaximumSize(registerEmail.getPreferredSize());
        registerDorm.setMaximumSize(registerDorm.getPreferredSize());

        //user screen
        addBookAuthor.setMaximumSize(addBookAuthor.getPreferredSize());
        addBookName.setMaximumSize(addBookName.getPreferredSize());
        getBookInfoName.setMaximumSize(getBookInfoName.getPreferredSize());
        lendBookName.setMaximumSize(lendBookName.getPreferredSize());
        returnBookName.setMaximumSize(returnBookName.getPreferredSize());
        getUserInfoName.setMaximumSize(getUserInfoName.getPreferredSize());

        //admin screen
        addBookNameAdmin.setMaximumSize(addBookNameAdmin.getPreferredSize());
        addBookAuthorAdmin.setMaximumSize(addBookAuthorAdmin.getPreferredSize());
        addBookOwnerAdmin.setMaximumSize(addBookOwnerAdmin.getPreferredSize());
        getBookInfoNameAdmin.setMaximumSize(getBookInfoNameAdmin.getPreferredSize());
        removeBookName.setMaximumSize(removeBookName.getPreferredSize());
        addUserUsername.setMaximumSize(addUserUsername.getPreferredSize());
        addUserPassword.setMaximumSize(addUserPassword.getPreferredSize());
        addUserPhone.setMaximumSize(addUserPhone.getPreferredSize());
        addUserEmail.setMaximumSize(addUserEmail.getPreferredSize());
        addUserDorm.setMaximumSize(addUserDorm.getPreferredSize());
        returnBookNameAdmin.setMaximumSize(returnBookNameAdmin.getPreferredSize());
        getUserInfoNameAdmin.setMaximumSize(getUserInfoNameAdmin.getPreferredSize());

        //creating labels
        //login selection
        usernameLoginL = new JLabel("Username:");
        passwordLoginL = new JLabel("Password:");

        usernameRegisterL = new JLabel("Username:");
        passwordRegisterL = new JLabel("Password:");
        phoneRegisterL = new JLabel("Phone Number:");
        emailRegisterL = new JLabel("Email Address:");
        dormRegisterL = new JLabel("Dorm Room:");

        //user screen
        addBookNameL = new JLabel("Name:");
        addBookAuthorL = new JLabel("Author:");
        getBookInfoNameL = new JLabel("Name Of The Book:");
        lendBookNameL = new JLabel("Name Of A Book To Lend");
        returnBookNameL = new JLabel("Book Name");
        getUserInfoNameL = new JLabel("User Name");

        //admin screen
        addBookNameAdminL = new JLabel("Book Name:");
        addBookAuthorAdminL = new JLabel("Book Author:");
        addBookOwnerAdminL = new JLabel("Book Owner:");
        getBookInfoNameAdminL = new JLabel("Name Of The Book:");
        removeBookNameL = new JLabel("Book Name:");
        addUserUsernameL = new JLabel("User Username:");
        addUserPasswordL = new JLabel("User Password:");
        addUserPhoneL = new JLabel("User Phone Number:");
        addUserEmailL = new JLabel("User Email Address:");
        addUserDormL = new JLabel("User Dorm Room:");
        returnBookNameAdminL = new JLabel("Book Name");
        getUserInfoNameAdminL = new JLabel("User Name");

        //creating text areas
        //user screen
        getBooksOutput = new JTextArea();
        getBookInfoOutput = new JTextArea();
        getUserInfoOutput = new JTextArea();

        //admin screen
        getBooksOutputAdmin = new JTextArea();
        getBookInfoOutputAdmin = new JTextArea();
        getUserInfoOutputAdmin = new JTextArea();

        //adding stuff to loginSelection panel
        loginSelectionScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        loginSelectionScreen.add(login);
        loginSelectionScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        loginSelectionScreen.add(register);

        loginSelectionScreen.setLayout(new BoxLayout(loginSelectionScreen, BoxLayout.Y_AXIS));
        loginSelectionScreen.setBorder(BorderFactory.createEmptyBorder(125, 200, 0, 0));


        //adding stuff to loginScreen panel
        loginScreen.add(usernameLoginL);
        loginScreen.add(loginUsername);
        loginScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        loginScreen.add(passwordLoginL);
        loginScreen.add(loginPassword);
        loginScreen.add(Box.createRigidArea(new Dimension(75, 50)));
        loginScreen.add(confirmLogin);
        loginScreen.add(Box.createRigidArea(new Dimension(75, 50)));
        loginScreen.add(loginReturn);

        loginScreen.setLayout(new BoxLayout(loginScreen, BoxLayout.Y_AXIS));
        loginScreen.setBorder(BorderFactory.createEmptyBorder(50, 75, 0, 0));

        //adding stuff to registerScreen panel
        registerScreen.add(usernameRegisterL);
        registerScreen.add(registerUsername);
        registerScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        registerScreen.add(passwordRegisterL);
        registerScreen.add(registerPassword);
        registerScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        registerScreen.add(phoneRegisterL);
        registerScreen.add(registerPhone);
        registerScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        registerScreen.add(emailRegisterL);
        registerScreen.add(registerEmail);
        registerScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        registerScreen.add(dormRegisterL);
        registerScreen.add(registerDorm);
        registerScreen.add(Box.createRigidArea(new Dimension(75, 40)));
        registerScreen.add(confirmRegister);
        registerScreen.add(Box.createRigidArea(new Dimension(75, 40)));
        registerScreen.add(registerReturn);

        registerScreen.setLayout(new BoxLayout(registerScreen, BoxLayout.Y_AXIS));
        registerScreen.setBorder(BorderFactory.createEmptyBorder(20, 75, 0, 0));

        //adding stuff to userScreen panel
        userScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        userScreen.add(addBookButton);
        userScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        userScreen.add(getBooksButton);
        userScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        userScreen.add(getBookInfoButton);
        userScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        userScreen.add(lendBookButton);
        userScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        userScreen.add(returnBookButton);
        userScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        userScreen.add(getUserInfoButton);

        userScreen.setLayout(new BoxLayout(userScreen, BoxLayout.Y_AXIS));
        userScreen.setBorder(BorderFactory.createEmptyBorder(50, 200, 0, 0));

        //adding stuff to addBook panel
        addBookScreen.add(addBookNameL);
        addBookScreen.add(addBookName);
        addBookScreen.add(Box.createRigidArea(new Dimension(0, 25)));
        addBookScreen.add(addBookAuthorL);
        addBookScreen.add(addBookAuthor);
        addBookScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        addBookScreen.add(addBookConfirm);
        addBookScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        addBookScreen.add(addBookReturn);

        addBookScreen.setLayout(new BoxLayout(addBookScreen, BoxLayout.Y_AXIS));
        addBookScreen.setBorder(BorderFactory.createEmptyBorder(50, 125, 0, 0));

        //adding stuff to getBooks panel
        getBooksScreen.add(getBooksOutput);
        getBooksScreen.add(Box.createRigidArea(new Dimension(100, 20)));
        getBooksScreen.add(getBooksReturn);

        getBooksScreen.setLayout(new BoxLayout(getBooksScreen, BoxLayout.Y_AXIS));
        getBooksScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

        //adding stuff to getBookInfo screen
        getBookInfoScreen.add(getBookInfoNameL);
        getBookInfoScreen.add(getBookInfoName);
        getBookInfoScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        getBookInfoScreen.add(getBookConfirm);
        getBookInfoScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        getBookInfoScreen.add(getBookInfoReturnButton);

        getBookInfoScreen.setLayout(new BoxLayout(getBookInfoScreen, BoxLayout.Y_AXIS));
        getBookInfoScreen.setBorder(BorderFactory.createEmptyBorder(50, 125, 0, 0));

        //adding stuff to getBookInfoOutput screen
        getBookInfoOutputScreen.add(getBookInfoOutput);
        lendBookScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        getBookInfoOutputScreen.add(getBookInfoOutputReturnButton);

        getBookInfoOutputScreen.setLayout(new BoxLayout(getBookInfoOutputScreen, BoxLayout.Y_AXIS));
        getBookInfoOutputScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

        //adding stuff to the lendBook screen
        lendBookScreen.add(lendBookNameL);
        lendBookScreen.add(lendBookName);
        lendBookScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        lendBookScreen.add(lendBookConfirmButton);
        lendBookScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        lendBookScreen.add(lendBookReturnButton);

        lendBookScreen.setLayout(new BoxLayout(lendBookScreen, BoxLayout.Y_AXIS));
        lendBookScreen.setBorder(BorderFactory.createEmptyBorder(50, 125, 0, 0));

        //adding stuff to the returnBook screen
        returnBookScreen.add(returnBookNameL);
        returnBookScreen.add(returnBookName);
        returnBookScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        returnBookScreen.add(returnBookConfirmButton);
        returnBookScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        returnBookScreen.add(returnBookReturnButton);

        returnBookScreen.setLayout(new BoxLayout(returnBookScreen, BoxLayout.Y_AXIS));
        returnBookScreen.setBorder(BorderFactory.createEmptyBorder(50, 125, 0, 0));

        //adding stuff to the getUserInfo screen
        getUserInfoScreen.add(getUserInfoNameL);
        getUserInfoScreen.add(getUserInfoName);
        getUserInfoScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        getUserInfoScreen.add(getUserInfoConfirmButton);
        getUserInfoScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        getUserInfoScreen.add(getUserInfoReturnButton);

        getUserInfoScreen.setLayout(new BoxLayout(getUserInfoScreen, BoxLayout.Y_AXIS));
        getUserInfoScreen.setBorder(BorderFactory.createEmptyBorder(50, 125, 0, 0));

        //adding stuff to the getUserInfoOutput screen
        getUserInfoOutputScreen.add(getUserInfoOutput);
        getUserInfoOutputScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        getUserInfoOutputScreen.add(getUserInfoOutputReturnButton);

        getUserInfoOutputScreen.setLayout(new BoxLayout(getUserInfoOutputScreen, BoxLayout.Y_AXIS));
        getUserInfoOutputScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

        //adding stuff to adminScreen
        adminScreen.add(addBookButtonAdmin);
        adminScreen.add(Box.createRigidArea(new Dimension(0, 30)));
        adminScreen.add(getBooksButtonAdmin);
        adminScreen.add(Box.createRigidArea(new Dimension(0, 30)));
        adminScreen.add(getBookInfoButtonAdmin);
        adminScreen.add(Box.createRigidArea(new Dimension(0, 30)));
        adminScreen.add(removeBookButtonAdmin);
        adminScreen.add(Box.createRigidArea(new Dimension(0, 30)));
        adminScreen.add(addUserButtonAdmin);
        adminScreen.add(Box.createRigidArea(new Dimension(0, 30)));
        adminScreen.add(returnBookAdminButton);
        adminScreen.add(Box.createRigidArea(new Dimension(0, 30)));
        adminScreen.add(getUserInfoAdminButton);

        adminScreen.setLayout(new BoxLayout(adminScreen, BoxLayout.Y_AXIS));
        adminScreen.setBorder(BorderFactory.createEmptyBorder(50, 200, 0, 0));

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
        getBooksAdminScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

        //adding stuff to the getBookInfoAdmin screen
        getBookInfoAdminScreen.add(Box.createRigidArea(new Dimension(0, 40)));
        getBookInfoAdminScreen.add(getBookInfoNameAdminL);
        getBookInfoAdminScreen.add(getBookInfoNameAdmin);
        getBookInfoAdminScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        getBookInfoAdminScreen.add(getBookInfoConfirmAdminButton);
        getBookInfoAdminScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        getBookInfoAdminScreen.add(getBookInfoReturnAdminButton);

        getBookInfoAdminScreen.setLayout(new BoxLayout(getBookInfoAdminScreen, BoxLayout.Y_AXIS));
        getBookInfoAdminScreen.setBorder(BorderFactory.createEmptyBorder(0, 125, 0, 0));

        //adding stuff to the GetBookInfoOutputAdmin screen
        getBookInfoOutputAdminScreen.add(getBookInfoOutputAdmin);
        getBookInfoOutputAdminScreen.add(getBookInfoOutputReturnAdminButton);

        getBookInfoOutputAdminScreen.setLayout(new BoxLayout(getBookInfoOutputAdminScreen, BoxLayout.Y_AXIS));
        getBookInfoOutputAdminScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

        //adding stuff to removeBookAdmin screen
        removeBookAdminScreen.add(removeBookNameL);
        removeBookAdminScreen.add(removeBookName);
        removeBookAdminScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        removeBookAdminScreen.add(removeBookConfirmButtonAdmin);
        removeBookAdminScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        removeBookAdminScreen.add(removeBookReturnAdminButton);

        removeBookAdminScreen.setLayout(new BoxLayout(removeBookAdminScreen, BoxLayout.Y_AXIS));
        removeBookAdminScreen.setBorder(BorderFactory.createEmptyBorder(75, 125, 0, 0));

        //adding stuff to addUserAdmin screen
        addUserAdminScreen.add(addUserUsernameL);
        addUserAdminScreen.add(addUserUsername);
        addUserAdminScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        addUserAdminScreen.add(addUserPasswordL);
        addUserAdminScreen.add(addUserPassword);
        addUserAdminScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        addUserAdminScreen.add(addUserPhoneL);
        addUserAdminScreen.add(addUserPhone);
        addUserAdminScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        addUserAdminScreen.add(addUserEmailL);
        addUserAdminScreen.add(addUserEmail);
        addUserAdminScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        addUserAdminScreen.add(addUserDormL);
        addUserAdminScreen.add(addUserDorm);
        addUserAdminScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        addUserAdminScreen.add(addUserConfirmButtonAdmin);
        addUserAdminScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        addUserAdminScreen.add(addUserReturnAdminButton);

        addUserAdminScreen.setLayout(new BoxLayout(addUserAdminScreen, BoxLayout.Y_AXIS));
        addUserAdminScreen.setBorder(BorderFactory.createEmptyBorder(20, 100, 0, 0));

        //adding stuff to the returnBookAdmin screen
        returnBookAdminScreen.add(returnBookNameAdminL);
        returnBookAdminScreen.add(returnBookNameAdmin);
        returnBookAdminScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        returnBookAdminScreen.add(returnBookConfirmAdminButton);
        returnBookAdminScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        returnBookAdminScreen.add(returnBookReturnAdminButton);

        returnBookAdminScreen.setLayout(new BoxLayout(returnBookAdminScreen, BoxLayout.Y_AXIS));
        returnBookAdminScreen.setBorder(BorderFactory.createEmptyBorder(50, 125, 0, 0));

        //adding stuff to the getUserInfoAdmin screen
        getUserInfoAdminScreen.add(getUserInfoNameAdminL);
        getUserInfoAdminScreen.add(getUserInfoNameAdmin);
        getUserInfoAdminScreen.add(Box.createRigidArea(new Dimension(0, 50)));
        getUserInfoAdminScreen.add(getUserInfoConfirmAdminButton);
        getUserInfoAdminScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        getUserInfoAdminScreen.add(getUserInfoReturnAdminButton);

        getUserInfoAdminScreen.setLayout(new BoxLayout(getUserInfoAdminScreen, BoxLayout.Y_AXIS));
        getUserInfoAdminScreen.setBorder(BorderFactory.createEmptyBorder(50, 125, 0, 0));

        //adding stuff to the getUserInfoOutputAdmin screen
        getUserInfoOutputAdminScreen.add(getUserInfoOutputAdmin);
        getUserInfoOutputAdminScreen.add(Box.createRigidArea(new Dimension(0, 20)));
        getUserInfoOutputAdminScreen.add(getUserInfoOutputReturnAdminButton);

        getUserInfoOutputAdminScreen.setLayout(new BoxLayout(getUserInfoOutputAdminScreen, BoxLayout.Y_AXIS));
        getUserInfoOutputAdminScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

        //adding panels to cardLayout
        //login selection
        cPane.add("loginSelection", loginSelectionScreen);
        cPane.add("confirmLogin", loginScreen);
        cPane.add("confirmRegister", registerScreen);
        //user screen
        cPane.add("userScreen", userScreen);
        cPane.add("addBook", addBookScreen);
        cPane.add("getBooks", getBooksScreen);
        cPane.add("getBookInfo", getBookInfoScreen);
        cPane.add("getBookInfoOutput", getBookInfoOutputScreen);
        cPane.add("lendBook", lendBookScreen);
        cPane.add("returnBook", returnBookScreen);
        cPane.add("getUserInfo", getUserInfoScreen);
        cPane.add("getUserInfoOutput", getUserInfoOutputScreen);
        //admin screen
        cPane.add("adminScreen", adminScreen);
        cPane.add("addBookAdminScreen", addBookAdminScreen);
        cPane.add("getBooksAdminScreen", getBooksAdminScreen);
        cPane.add("getBookInfoAdmin", getBookInfoAdminScreen);
        cPane.add("getBookInfoOutputAdmin", getBookInfoOutputAdminScreen);
        cPane.add("removeBookAdminScreen", removeBookAdminScreen);
        cPane.add("addUserAdminScreen", addUserAdminScreen);
        cPane.add("returnBookAdmin", returnBookAdminScreen);
        cPane.add("getUserInfoAdmin", getUserInfoAdminScreen);
        cPane.add("getUserInfoOutputAdmin", getUserInfoOutputAdminScreen);
    }

    //declaring commands
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            //login selection
            case "Login" -> crd.show(cPane, "confirmLogin");
            case "Register" -> crd.show(cPane, "confirmRegister");
            case "confirmLogin" -> {
                try {
                    out.writeBytes("signIn\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String username = loginUsername.getText();
                String password = loginPassword.getText();
                String input;

                loginUsername.setText("");
                loginPassword.setText("");

                try {
                    out.writeBytes(username + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    input = server.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if(Objects.equals(input, "Zle meno")){
                    crd.show(cPane, "loginSelection");
                    break;
                }

                try {
                    out.writeBytes(password + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    input = server.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if(Objects.equals(input, "Zle heslo")){
                    crd.show(cPane, "loginSelection");
                    break;
                }

                try {
                    input = server.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if(Objects.equals(input, "0")){
                    crd.show(cPane, "adminScreen");
                }else if(Objects.equals(input, "1")){
                    crd.show(cPane, "userScreen");
                }

            }
            case "confirmRegister" -> {
                try {
                    out.writeBytes("register\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String username = registerUsername.getText();
                String password = registerPassword.getText();
                String phoneNumber = registerPhone.getText();
                String email = registerEmail.getText();
                String dorm = registerDorm.getText();
                registerUsername.setText("");
                registerPassword.setText("");
                registerPhone.setText("");
                registerEmail.setText("");
                registerDorm.setText("");

                try {
                    out.writeBytes(username + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    out.writeBytes(password + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    out.writeBytes(phoneNumber + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    out.writeBytes(email + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    out.writeBytes(dorm + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                crd.show(cPane, "loginSelection"); //change to confirmRegister on Register press
            }
            case "Back To Login Selection" -> crd.show(cPane, "loginSelection");
            //user screen
            case "Add Book User" -> crd.show(cPane, "addBook");
            case "Add Book Confirm User" -> {
                try {
                    out.writeBytes("addBook\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String bookName = addBookName.getText();
                addBookName.setText("");
                try {
                    out.writeBytes(bookName + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String bookAuthor = addBookAuthor.getText();
                addBookAuthor.setText("");
                try {
                    out.writeBytes(bookAuthor + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                crd.show(cPane, "userScreen");
            }
            case "Get Books User" -> {
                try {
                    out.writeBytes("getBooks\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                String books;
                try {
                    books = server.readLine().replace("#","\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                crd.show(cPane, "getBooks");
                getBooksOutput.setText(books);
            }
            case "Get Book Info User" -> crd.show(cPane, "getBookInfo");
            case "Get Book Info Confirm User" -> {
                try {
                    out.writeBytes("getBookInfo\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String bookName = getBookInfoName.getText();
                getBookInfoName.setText("");
                try {
                    out.writeBytes(bookName + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String bookInfo;
                try {
                    bookInfo = server.readLine().replace("#","\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                getBookInfoOutput.setText(bookInfo);
                crd.show(cPane, "getBookInfoOutput");
            }
            case "Lend Book" -> crd.show(cPane, "lendBook");
            case "Lend This Book" -> {
                try {
                    out.writeBytes("lendBook\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String bookName = lendBookName.getText();
                lendBookName.setText("");
                try {
                    out.writeBytes(bookName + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                crd.show(cPane, "userScreen");
            }
            case "Return Book User" -> crd.show(cPane, "returnBook");
            case "Return Book Confirm User" ->{
                try {
                    out.writeBytes("returnBook\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                String bookName = returnBookName.getText();
                returnBookName.setText("");
                try {
                    out.writeBytes(bookName + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                crd.show(cPane, "userScreen");
            }
            case "Get User Info User" -> crd.show(cPane, "getUserInfo");
            case "Get User Info Confirm User" -> {
                try {
                    out.writeBytes("getUserInfo\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String userName = getUserInfoName.getText();
                getUserInfoName.setText("");
                try {
                    out.writeBytes(userName + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String userInfo;
                try {
                    userInfo = server.readLine().replace("#","\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                getUserInfoOutput.setText(userInfo);
                crd.show(cPane, "getUserInfoOutput");
            }
            case "Back To User Menu" -> crd.show(cPane, "userScreen");
            //admin screen
            case "Add Book Admin" -> crd.show(cPane, "addBookAdminScreen");
            case "Add Book Confirm Admin" -> {
                try {
                    out.writeBytes("addBook\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String bookName = addBookNameAdmin.getText();
                addBookNameAdmin.setText("");
                try {
                    out.writeBytes(bookName + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String bookAuthor = addBookAuthorAdmin.getText();
                addBookAuthorAdmin.setText("");
                try {
                    out.writeBytes(bookAuthor + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String bookOwner = addBookOwnerAdmin.getText();
                addBookOwnerAdmin.setText("");
                try {
                    out.writeBytes(bookOwner + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                crd.show(cPane, "adminScreen");
            }
            case "Get Books Admin" -> {
                try {
                    out.writeBytes("getBooks\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                String books;
                try {
                    books = server.readLine().replace("#","\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                crd.show(cPane, "getBooksAdminScreen");
                getBooksOutputAdmin.setText(books);
            }
            case "Get Book Info Admin" -> crd.show(cPane, "getBookInfoAdmin");
            case "Get Book Info Confirm Admin" -> {
                try {
                    out.writeBytes("getBookInfo\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String bookName = getBookInfoNameAdmin.getText();
                getBookInfoNameAdmin.setText("");
                try {
                    out.writeBytes(bookName + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String bookInfo;
                try {
                    bookInfo = server.readLine().replace("#","\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                getBookInfoOutputAdmin.setText(bookInfo);
                crd.show(cPane, "getBookInfoOutputAdmin");
            }
            case "Remove Book" -> crd.show(cPane, "removeBookAdminScreen");
            case "Remove This Book" -> {
                try {
                    out.writeBytes("removeBook\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                String bookName = removeBookName.getText();
                removeBookName.setText("");
                try {
                    out.writeBytes(bookName + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                crd.show(cPane, "adminScreen");
            }
            case "Add User" -> crd.show(cPane, "addUserAdminScreen");
            case "Add This User" -> {
                try {
                    out.writeBytes("addUser\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String username = addUserUsername.getText();
                addUserUsername.setText("");
                try {
                    out.writeBytes(username + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String password = addUserPassword.getText();
                addUserPassword.setText("");
                try {
                    out.writeBytes(password + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String phoneNumber = addUserPhone.getText();
                addUserPhone.setText("");
                try {
                    out.writeBytes(phoneNumber + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String email = addUserEmail.getText();
                addUserEmail.setText("");
                try {
                    out.writeBytes(email + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String dorm = addUserDorm.getText();
                addUserDorm.setText("");
                try {
                    out.writeBytes(dorm + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                crd.show(cPane, "adminScreen");
            }
            case "Return Book Admin" -> crd.show(cPane, "returnBookAdmin");
            case "Return Book Confirm Admin" ->{
                try {
                    out.writeBytes("returnBook\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                String bookName = returnBookNameAdmin.getText();
                returnBookNameAdmin.setText("");
                try {
                    out.writeBytes(bookName + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                crd.show(cPane, "adminScreen");
            }
            case "Get User Info Admin" -> crd.show(cPane, "getUserInfoAdmin");
            case "Get User Info Confirm Admin" -> {
                try {
                    out.writeBytes("getUserInfo\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String userName = getUserInfoNameAdmin.getText();
                getUserInfoNameAdmin.setText("");
                try {
                    out.writeBytes(userName + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String userInfo;
                try {
                    userInfo = server.readLine().replace("#","\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                getUserInfoOutputAdmin.setText(userInfo);
                crd.show(cPane, "getUserInfoOutputAdmin");
            }
            case "Back To Admin Menu" -> crd.show(cPane, "adminScreen");

            default -> crd.show(cPane, "loginSelection");
        }
    }
}

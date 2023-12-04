package client;

import java.io.*;
import java.net.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    /*
    this is client side application
    this function initiates connection to server, defines buffers for keyboard input, server input and server output
    and it runs in a loop until 
     */
    public static void main(String[] args) throws Exception {
        //Socket s = new Socket("localhost", 1050);// Create client socket
        //DataOutputStream out = new DataOutputStream(s.getOutputStream());// to send data to the server
        //BufferedReader server = new BufferedReader(new InputStreamReader(s.getInputStream()));// to read data coming from the server
        //BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));// to read data from the keyboard

        clientGUI GUI = new clientGUI();

        //while (!(output = keyboard.readLine()).equals("exit")) {// repeat as long as exit is not typed at client
        //    out.writeBytes(output + "\n");// send to the server
        //    System.out.println(server.readLine().replace("#","\n"));// receive from the server
        //}

        GUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
        GUI.setSize(500, 500);
        GUI.setLocation(500, 200);
        GUI.setResizable(false);
        GUI.setVisible(true);

        // close connection.
        //out.close();
        //server.close();
        //keyboard.close();
        //s.close();
    }
}
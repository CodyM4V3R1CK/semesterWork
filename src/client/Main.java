package client;

import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 1050);// Create client socket
        DataOutputStream out = new DataOutputStream(s.getOutputStream());// to send data to the server
        BufferedReader server = new BufferedReader(new InputStreamReader(s.getInputStream()));// to read data coming from the server
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));// to read data from the keyboard
        String output;
        while (!(output = keyboard.readLine()).equals("exit")) {// repeat as long as exit is not typed at client
            out.writeBytes(output + "\n");// send to the server
            System.out.println(server.readLine().replace("#","\n"));// receive from the server
        }
        // close connection.
        out.close();
        server.close();
        keyboard.close();
        s.close();
    }
}
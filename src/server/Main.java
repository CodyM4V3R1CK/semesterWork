package server;

import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws Exception{

        // Create server Socket
        ServerSocket ss = new ServerSocket(888);

        // connect it to client socket
        Socket s = ss.accept();
        System.out.println("Connection established");

        // to send data to the client
        PrintStream ps
                = new PrintStream(s.getOutputStream());

        // to read data coming from the client
        BufferedReader br
                = new BufferedReader(
                new InputStreamReader(
                        s.getInputStream()));

        // to read data from the keyboard
        BufferedReader kb
                = new BufferedReader(
                new InputStreamReader(System.in));

        Book book = new Book("Hlava 22");

        // server executes continuously
        while(true) {

            String str, str1, str2;

            // repeat as long as the client
            // does not send a null string

            // read from client
            while((str = br.readLine()) != null) {
                //System.out.println(str);
                switch(str){
                    case "1":
                        ps.println("meno knizky je " + book.getName());
                        break;
                    case "2":
                        str2 = "Zadaj nazov knizky";
                        ps.println(str2);
                        str = br.readLine();
                        Book test = new Book(str);
                        ps.println(test.getName());
                        break;
                    default:
                        ps.println("Wrong command, try again");
                        break;
                }
                /*
                if(str.equals("1")){
                    System.out.println("testing if if() works");
                    System.out.println("meno knizky je " + book.getName());
                }

                if(str.equals("2")){
                    str2 = "Zadaj nazov knizky";
                    ps.println(str2);
                    str = br.readLine();
                    Book test = new Book(str);
                    System.out.println(test.getName());
                }
                str1 = kb.readLine();

                // send to client
                ps.println(str1);

                 */
            }

            // close connection
            ps.close();
            br.close();
            kb.close();
            ss.close();
            s.close();

            // terminate application
            System.exit(0);

        } // end of while
    }
}

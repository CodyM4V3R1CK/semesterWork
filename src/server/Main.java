package server;

import java.io.*;
import java.net.*;
import java.util.*;

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

        LinkedList<Book> bookList = new LinkedList<>();
        bookList.add(new Book("Matematika1"));
        bookList.add(new Book("Fyzika1"));
        bookList.add(new Book("Matematika2"));
        bookList.get(0).setAuthor("Polakovic");
        bookList.get(0).setOwner("Fero");
        bookList.get(1).setAuthor("Newton");
        bookList.get(1).setOwner("Palo");
        Comparator<Book> c = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        // server executes continuously
        while(true) {

            String str, str1, str2;

            // repeat as long as the client
            // does not send a null string

            // read from client
            while((str = br.readLine()) != null) {
                System.out.println(str);
                int index=0;
                switch(str){
                    case "getBooks":
                        Iterator<Book> iterator = bookList.iterator();
                        str2="";
                        while(iterator.hasNext()){
                            str2+=iterator.next().getName()+"#";
                        }
                        ps.println(str2);
                        break;
                    case "getBookInfo":
                        ps.println("Zadaj nazov knizky");
                        index = Collections.binarySearch(bookList,new Book(br.readLine()),c);
                        ps.println(bookList.get(index).getAuthor()+"#"+bookList.get(index).getOwner());
                        break;
                    case "addBook":
                        ps.println("Zadaj nazov knizky");
                        str = br.readLine();
                        bookList.add(new Book(str));
                        index = Collections.binarySearch(bookList,new Book(str),c);
                        ps.println("Zadaj nazov autora");
                        bookList.get(index).setAuthor(br.readLine());
                        ps.println("Zadaj nazov vlastnika");
                        bookList.get(index).setOwner(br.readLine());
                        ps.println("Hotovo");
                        break;
                    case "removeBook":
                        ps.println("Zadaj nazov knizky");
                        index = Collections.binarySearch(bookList,new Book(br.readLine()),c);
                        bookList.remove(index);
                        ps.println("Hotovo");
                    default:
                        ps.println("Unknown command");
                }
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

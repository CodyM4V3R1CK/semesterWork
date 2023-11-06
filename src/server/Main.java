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
            /**
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             */
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(bookList,c);//binary search needs sorted list

        LinkedList<Student> studentList = new LinkedList<>();
        studentList.add(new Student("0Admin"));
        studentList.add(new Student("Fero"));
        studentList.add(new Student("Palo"));
        studentList.get(0).setPassword("heslo");
        studentList.get(1).setPhone("123");
        studentList.get(2).setEmail("abc");
        Comparator<Student> sc = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(studentList,sc);//binary search needs sorted list

        int status = -1;//-1 not signed in, 0 admin, 1+ user

        // server executes continuously
        while(true) {
            if(status > 0){
    
                String str, str1, str2;
    
                // repeat as long as the client
                // does not send a null string
    
                // read from client
                while ((str = br.readLine()) != null) {
                    int index = 0;
                    switch (str) {
                        case "getBooks"://this function gives us names of all saved books
                            Iterator<Book> iterator = bookList.iterator();//this allows us to go through all the saved books one by one
                            str2 = "";//variable where we gonna save the books
                            while (iterator.hasNext()) {//while loop that gets book names one by one and saves them in string
                                str2 += iterator.next().getName() + "#";
                            }
                            ps.println(str2);//this returns the list of books
                            break;
                        case "getBookInfo"://this function asks for name of a book and it returns info about the book
                            ps.println("Zadaj nazov knizky");
                            index = Collections.binarySearch(bookList, new Book(br.readLine()), c);//here we are using binary search to find index of book with the choosen name
                            ps.println(bookList.get(index).getAuthor() + "#" + bookList.get(index).getOwner());//here we are returning book info
                            break;
                        case "addBook"://this function allows us to add a new book to our list
                            ps.println("Zadaj nazov knizky");//ask for name
                            str = br.readLine();//get name
                            bookList.add(new Book(str));//create new book with choosen name
                            Collections.sort(bookList, c);
                            index = Collections.binarySearch(bookList, new Book(str), c);//get index of the new book
                            ps.println("Zadaj nazov autora");//ask for author
                            bookList.get(index).setAuthor(br.readLine());//add author name to this book
                            ps.println("Zadaj nazov vlastnika");//ask for owner
                            bookList.get(index).setOwner(br.readLine());//add owner name to this book
                            ps.println("Hotovo");//confirm
                            break;
                        default:
                            ps.println("Unknown command. Available commands: getBooks, getBookInfo and addBook");
                            break;
                    }
                }
            } else if (status == 0) {

                String str, str1, str2;

                // repeat as long as the client
                // does not send a null string

                // read from client
                while ((str = br.readLine()) != null) {
                    int index = 0;
                    switch (str) {
                        case "getBooks"://this function gives us names of all saved books
                            Iterator<Book> iterator = bookList.iterator();//this allows us to go through all the saved books one by one
                            str2 = "";//variable where we gonna save the books
                            while (iterator.hasNext()) {//while loop that gets book names one by one and saves them in string
                                str2 += iterator.next().getName() + "#";
                            }
                            ps.println(str2);//this returns the list of books
                            break;
                        case "getBookInfo"://this function asks for name of a book and it returns info about the book
                            ps.println("Zadaj nazov knizky");
                            index = Collections.binarySearch(bookList, new Book(br.readLine()), c);//here we are using binary search to find index of book with the choosen name
                            ps.println(bookList.get(index).getAuthor() + "#" + bookList.get(index).getOwner());//here we are returning book info
                            break;
                        case "addBook"://this function allows us to add a new book to our list
                            ps.println("Zadaj nazov knizky");//ask for name
                            str = br.readLine();//get name
                            bookList.add(new Book(str));//create new book with choosen name
                            Collections.sort(bookList, c);
                            index = Collections.binarySearch(bookList, new Book(str), c);//get index of the new book
                            ps.println("Zadaj nazov autora");//ask for author
                            bookList.get(index).setAuthor(br.readLine());//add author name to this book
                            ps.println("Zadaj nazov vlastnika");//ask for owner
                            bookList.get(index).setOwner(br.readLine());//add owner name to this book
                            ps.println("Hotovo");//confirm
                            break;
                        case "removeBook"://this function allows us to remove books
                            ps.println("Zadaj nazov knizky");//ask for name
                            index = Collections.binarySearch(bookList, new Book(br.readLine()), c);//find index of the book
                            bookList.remove(index);//remove it
                            ps.println("Hotovo");//confirm
                            break;
                        default:
                            ps.println("Unknown command. Avaiable commands: getBooks, getBookInfo, addBook and removeBook");
                            break;
                    }
                }
                
            }else{

                String str, str1, str2;

                // repeat as long as the client
                // does not send a null string

                // read from client
                while ((str = br.readLine()) != null && status == -1) {
                    int index = 0;
                    switch (str) {
                        case "signIn":
                            ps.println("Zadaj meno:");
                            index = Collections.binarySearch(studentList, new Student(br.readLine()), sc);
                            ps.println("Zadaj heslo:");
                            if(studentList.get(index).getPassword().compareTo(br.readLine())==0){
                                if(index==0){
                                    status=0;
                                }else{
                                    status=1;
                                }
                                ps.println("Si prihlaseny");
                            }else{
                                ps.println("Zle meno/heslo");
                            }
                            break;
                        case "register":
                            ps.println("Zadaj meno:");
                            str=br.readLine();
                            studentList.add(new Student(str));
                            Collections.sort(studentList, sc);
                            index = Collections.binarySearch(studentList, new Student(str), sc);
                            ps.println("Zadaj heslo:");
                            studentList.get(index).setPassword(br.readLine());
                            ps.println("Zadaj telefonne cislo:");
                            studentList.get(index).setPhone(br.readLine());
                            ps.println("Zadaj email:");
                            studentList.get(index).setEmail(br.readLine());
                            ps.println("Zadaj cislo izby:");
                            studentList.get(index).setDormRoom(br.readLine());
                            ps.println("Si zaregistrovany");
                            break;
                        default:
                            ps.println("You need to sign in [signIn] or register [register]");
                            break;
                    }
                    if(status!=-1){
                        break;
                    }
                }

            }
            /*
            // close connection
            ps.close();
            br.close();
            kb.close();
            ss.close();
            s.close();
            // terminate application
            System.exit(0);
            */

        } // end of while
    }
}

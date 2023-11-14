package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(1050);// Create server Socket
        Socket s = ss.accept();// connect it to client socket
        System.out.println("Connection established");
        PrintStream out = new PrintStream(s.getOutputStream());// to send data to the client
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));// to read data coming from the client

        LinkedList<Book> bookList = new LinkedList<>();
        bookList.add(new Book("Matematika1"));
        bookList.add(new Book("Fyzika1"));
        bookList.add(new Book("Matematika2"));
        bookList.get(0).setAuthor("Polakovic");
        bookList.get(0).setOwner("Fero");
        bookList.get(1).setAuthor("Newton");
        bookList.get(1).setOwner("Palo");
        Comparator<Book> c = new Comparator<>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        bookList.sort(c);//binary search needs sorted list

        LinkedList<Student> studentList = new LinkedList<>();
        studentList.add(new Student("0Admin"));
        studentList.add(new Student("Fero"));
        studentList.add(new Student("Palo"));
        studentList.get(0).setPassword("heslo");
        studentList.get(1).setPassword("pass");
        studentList.get(1).setPhone("123");
        studentList.get(2).setEmail("abc");
        Comparator<Student> sc = new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        studentList.sort(sc);//binary search needs sorted list
        int status = -1;//-1 not signed in, 0 admin, 1+ user
        while(true) {// server executes continuously
            if(status > 0){
                String input, output;
                while ((input = in.readLine()) != null) {
                    int index;
                    switch (input) {
                        case "getBooks"://this function gives us names of all saved books
                            Iterator<Book> iterator = bookList.iterator();//this allows us to go through all the saved books one by one
                            output = "";//variable where we gonna save the books
                            while (iterator.hasNext()) {//while loop that gets book names one by one and saves them in string
                                output += iterator.next().getName() + "#";
                            }
                            out.println(output);//this returns the list of books
                            break;
                        case "getBookInfo"://this function asks for name of a book and it returns info about the book
                            out.println("Zadaj nazov knizky");
                            index = Collections.binarySearch(bookList, new Book(in.readLine()), c);//here we are using binary search to find index of book with the choosen name
                            if(index>=0){
                                out.println(bookList.get(index).getAuthor() + "#" + bookList.get(index).getOwner() + "#" + bookList.get(index).getCurrentOwner());//here we are returning book info
                            }else{
                                out.println("Zly nazov");
                            }
                            break;
                        case "addBook"://this function allows us to add a new book to our list
                            out.println("Zadaj nazov knizky");//ask for name
                            input = in.readLine();//get name
                            if(Collections.binarySearch(bookList, new Book(input), c)<0){
                                bookList.add(new Book(input));//create new book with choosen name
                                bookList.sort(c);
                                index = Collections.binarySearch(bookList, new Book(input), c);//get index of the new book
                                out.println("Zadaj nazov autora");//ask for author
                                bookList.get(index).setAuthor(in.readLine());//add author name to this book
                                bookList.get(index).setOwner(in.readLine());//add owner name to this book
                                out.println("Hotovo");//confirm
                            }else{
                                out.println("Kniha uz v zozname existuje");
                            }
                            break;
                        case "getUserInfo":
                            out.println("Zadaj meno uzivatela");
                            index = Collections.binarySearch(studentList, new Student(in.readLine()), sc);
                            if (index >= 0) {
                                out.println(studentList.get(index).getPhone() + "#" + studentList.get(index).getEmail() + "#" + studentList.get(index).getDormRoom());
                            }else{
                                out.println("Zle meno");
                            }
                            break;
                        case "lendBook":
                            out.println("Zadaj nazov knizky");
                            index = Collections.binarySearch(bookList, new Book(in.readLine()), c);//here we are using binary search to find index of book with the choosen name
                            if(index>=0){
                                bookList.get(index).setCurrentOwner(studentList.get(status).getName());
                                out.println("hotovo");//here we are returning book info
                            }else{
                                out.println("Zly nazov");
                            }
                            break;
                        case "returnBook":
                            out.println("Zadaj nazov knizky");
                            index = Collections.binarySearch(bookList, new Book(in.readLine()), c);//here we are using binary search to find index of book with the choosen name
                            if(index>=0){
                                bookList.get(index).setCurrentOwner(bookList.get(index).getOwner());
                                out.println("hotovo");//here we are returning book info
                            }else{
                                out.println("Zly nazov");
                            }
                            break;
                        default:
                            out.println("Unknown command. Available commands: getBooks, getBookInfo, getUserInfo, lendBook, returnBook and addBook");
                            break;
                    }
                }
            } else if (status == 0) {
                String input, output;
                while ((input = in.readLine()) != null) {
                    int index;
                    switch (input) {
                        case "getBooks"://this function gives us names of all saved books
                            Iterator<Book> iterator = bookList.iterator();//this allows us to go through all the saved books one by one
                            output = "";//variable where we gonna save the books
                            while (iterator.hasNext()) {//while loop that gets book names one by one and saves them in string
                                output += iterator.next().getName() + "#";
                            }
                            out.println(output);//this returns the list of books
                            break;
                        case "getBookInfo"://this function asks for name of a book and it returns info about the book
                            out.println("Zadaj nazov knizky");
                            index = Collections.binarySearch(bookList, new Book(in.readLine()), c);//here we are using binary search to find index of book with the choosen name
                            if(index>=0){
                                out.println(bookList.get(index).getAuthor() + "#" + bookList.get(index).getOwner());//here we are returning book info
                            }else{
                                out.println("Zly nazov");
                            }
                            break;
                        case "addBook"://this function allows us to add a new book to our list
                            out.println("Zadaj nazov knizky");//ask for name
                            input = in.readLine();//get name
                            if(Collections.binarySearch(bookList, new Book(input), c)<0){
                                bookList.add(new Book(input));//create new book with choosen name
                                bookList.sort(c);
                                index = Collections.binarySearch(bookList, new Book(input), c);//get index of the new book
                                out.println("Zadaj nazov autora");//ask for author
                                bookList.get(index).setAuthor(in.readLine());//add author name to this book
                                output="";
                                for (Student student : studentList) {
                                    output += "#" + student.getName();
                                }
                                out.println("Zadaj nazov vlastnika"+output);//ask for owner
                                input=in.readLine();
                                if(Collections.binarySearch(studentList, new Student(input), sc)<0){
                                    out.println("taky uzivatel neexistuje");
                                    bookList.remove(Collections.binarySearch(bookList, new Book(bookList.get(index).getName()), c));

                                }else{
                                    bookList.get(index).setOwner(input);//add owner name to this book
                                    out.println("Hotovo");//confirm
                                }
                            }else{
                                out.println("Kniha uz v zozname existuje");
                            }
                            break;
                        case "removeBook"://this function allows us to remove books
                            out.println("Zadaj nazov knizky");//ask for name
                            index = Collections.binarySearch(bookList, new Book(in.readLine()), c);//find index of the book
                            if(index>=0){
                                bookList.remove(index);//remove it
                                out.println("Hotovo");
                            }else{
                                out.println("Zly nazov");
                            }
                            break;
                        case "getUserInfo":
                            out.println("Zadaj meno uzivatela");
                            index = Collections.binarySearch(studentList, new Student(in.readLine()), sc);
                            if (index >= 0) {
                                out.println(studentList.get(index).getPhone() + "#" + studentList.get(index).getEmail() + "#" + studentList.get(index).getDormRoom());
                            }else{
                                out.println("Zle meno");
                            }
                            break;
                        case "addUser":
                            out.println("Zadaj meno:");
                            input=in.readLine();
                            if(Collections.binarySearch(studentList, new Student(input), sc)<0){
                                studentList.add(new Student(input));
                                studentList.sort(sc);
                                index = Collections.binarySearch(studentList, new Student(input), sc);
                                out.println("Zadaj heslo:");
                                studentList.get(index).setPassword(in.readLine());
                                out.println("Uzivatel pridany");
                            }else{
                                out.println("Uzivatel s takym menom existuje");
                            }
                            break;
                        case "returnBook":
                            out.println("Zadaj nazov knizky");
                            index = Collections.binarySearch(bookList, new Book(in.readLine()), c);//here we are using binary search to find index of book with the choosen name
                            if(index>=0){
                                bookList.get(index).setCurrentOwner(bookList.get(index).getOwner());
                                out.println("hotovo");//here we are returning book info
                            }else{
                                out.println("Zly nazov");
                            }
                            break;
                        default:
                            out.println("Unknown command. Avaiable commands: getBooks, getBookInfo, getUserInfo, addUser, returnBook, addBook and removeBook");
                          break;
                    }
                }
            }else{
                String input;
                while ((input = in.readLine()) != null) {
                    int index = 0;
                    switch (input) {
                        case "signIn":
                            //out.println("Zadaj meno:");
                            index = Collections.binarySearch(studentList, new Student(in.readLine()), sc);
                            if(index<0){
                                out.println("Zle meno");
                            }else{
                                out.println("Zadaj heslo:");
                                if(studentList.get(index).getPassword().compareTo(in.readLine())==0){
                                    status=index;
                                    out.println("Si prihlaseny");
                                    out.println(index);
                                }else{
                                    out.println("Zle heslo");
                                }
                            }
                            break;
                        case "register":
                            //out.println("Zadaj meno:");
                            input=in.readLine();
                            if(Collections.binarySearch(studentList, new Student(input), sc)<-1) {
                                studentList.add(new Student(input));
                                studentList.sort(sc);
                                index = Collections.binarySearch(studentList, new Student(input), sc);
                                //out.println("Zadaj heslo:");
                                input=in.readLine();
                                studentList.get(index).setPassword(input);
                                //out.println("Zadaj telefonne cislo:");
                                input=in.readLine();
                                studentList.get(index).setPhone(input);
                                //out.println("Zadaj email:");
                                input=in.readLine();
                                studentList.get(index).setEmail(input);
                                //out.println("Zadaj cislo izby:");
                                input=in.readLine();
                                studentList.get(index).setDormRoom(input);
                                //out.println("Si zaregistrovany");
                            }else if (Collections.binarySearch(studentList, new Student(input), sc)==-1) {
                                out.println("Na zaciatku mena nesmu byt cisla");
                            }else{
                                out.println("Uzivatel s takym menom existuje");
                            }
                            break;
                        default:
                            out.println("You need to sign in [signIn] or register [register]");
                            break;
                    }
                    if(status>=0){
                        break;
                    }
                }
            }
            /*
            // close connection
            out.close();
            in.close();
            kb.close();
            ss.close();
            s.close();
            System.exit(0);// terminate application
            */
        } // end of while
    }
}
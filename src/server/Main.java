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

        Comparator<Book> cBook = new Comparator<Book>() {
            /**
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return
             */
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        LinkedList<Student> studentList = new LinkedList<>();
        studentList.add(new Student("Cody"));
        studentList.add(new Student("Zajlord"));
        studentList.get(0).setDormRoom("101");
        studentList.get(1).setDormRoom("102");

        Comparator<Student> cStudent = new Comparator<Student>() {
            /**
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return
             */
            @Override
            public int compare(Student o1, Student o2) {
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
                    case "getBooks":    //this function gives us names of all saved books
                        Iterator<Book> iteratorBook = bookList.iterator();  //this allows us to go through all the saved books one by one
                        str2="";    //variable where we're going to save the books

                        while(iteratorBook.hasNext()){  //while loop that gets book names one by one and saves them in string
                            str2 += iteratorBook.next().getName()+"#";
                        }

                        ps.println(str2);   //this returns the list of books
                        break;

                    case "getBookInfo": //this function asks for name of a book, and it returns info about the book
                        ps.println("Zadaj nazov knizky");
                        index = Collections.binarySearch(bookList, new Book(br.readLine()), cBook);   //here we are using binary search to find index of book with the chosen name
                        ps.println(bookList.get(index).getAuthor()+"#"+bookList.get(index).getOwner()); //here we are returning book info
                        break;

                    case "addBook": //this function allows us to add a new book to our list
                        ps.println("Zadaj nazov knizky");   //ask for name
                        str = br.readLine();    //get name
                        bookList.add(new Book(str));    //create new book with chosen name
                        index = Collections.binarySearch(bookList, new Book(str), cBook); //get index of the new book

                        ps.println("Zadaj nazov autora");   //ask for author
                        bookList.get(index).setAuthor(br.readLine());   //add author name to this book
                        ps.println("Zadaj nazov vlastnika");    //ask for owner
                        bookList.get(index).setOwner(br.readLine());    //add owner name to this book

                        ps.println("Hotovo");   //confirm
                        break;

                    case "removeBook":  //this function allows us to remove books
                        ps.println("Zadaj nazov knizky");//ask for name
                        index = Collections.binarySearch(bookList, new Book(br.readLine()), cBook);//find index of the book
                        bookList.remove(index);//remove it

                        ps.println("Hotovo");//confirm
                        break;

                    case "getStudents":
                        Iterator<Student> iteratorStudent = studentList.iterator();    //this allows us to go through all the saved students one by one
                        str2="";    //variable where we will save the students

                        while(iteratorStudent.hasNext()){  //while loop that gets student names one by one and saves them in string
                            str2 += iteratorStudent.next().getName()+"#";
                        }

                        ps.println(str2);   //this returns the list of students
                        break;

                    case "addStudent":
                        ps.println("Zadaj meno studenta");   //ask for name
                        str = br.readLine();    //get name
                        studentList.add(new Student(str));    //create new student with chosen name
                        index = Collections.binarySearch(studentList, new Student(str), cStudent); //get index of the new student

                        ps.println("Zadaj izbu");   //ask for dorm room
                        studentList.get(index).setDormRoom(br.readLine());   //add author name to this book

                        break;

                    default:
                        ps.println("Unknown command");
                        break;
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

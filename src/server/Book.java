package server;

public class Book {

    private String name;
    private String author;
    private String owner;
    private String currentOwner;

    public Book(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getCurrentOwner(){
        return currentOwner;
    }
    public void setCurrentOwner(String currentOwner){
        this.currentOwner=currentOwner;
    }
}

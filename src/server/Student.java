package server;

public class Student {

    private String name;
    private String dormRoom;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDormRoom() {
        return dormRoom;
    }

    public void setDormRoom(String dormRoom) {
        this.dormRoom = dormRoom;
    }
}

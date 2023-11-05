package server;

public class Student {

    private String name;
    private int dormRoom;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDormRoom() {
        return dormRoom;
    }

    public void setDormRoom(int dormRoom) {
        this.dormRoom = dormRoom;
    }
}

package server;

public class Student {

    String name;
    int dormRoom;

    public Student(String name, int dormRoom) {
        this.name = name;
        this.dormRoom = dormRoom;
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

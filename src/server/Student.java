package server;

public class Student {

    private String name;
    private String password = "password";
    private String phone;
    private String email;
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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDormRoom() {
        return dormRoom;
    }

    public void setDormRoom(String dormRoom) {
        this.dormRoom = dormRoom;
    }
}

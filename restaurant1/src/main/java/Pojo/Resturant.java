package Pojo;

public class Resturant implements java.io.Serializable{
    int id;
    String name;
    String location;
    String time;

    public Resturant() {
    }

    public Resturant(int id, String name, String location, String time) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

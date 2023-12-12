package Pojo;

public class RestaurantManage {
    int id;
    String username;
    String password;
    String restaurant;

    public RestaurantManage() {
    }

    public RestaurantManage(int id, String username, String password, String restaurant) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
}

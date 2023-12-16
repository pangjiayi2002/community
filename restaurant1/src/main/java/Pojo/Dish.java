package Pojo;

public class Dish {
    private int id;
    private String name;
    private  String foodtype;
    private float price;
    private String cover;
    private String restaurantName;

    public Dish() {
    }

    public Dish(int id, String name, String foodtype, float price, String cover, String restaurantName) {

        this.id = id;
        this.name = name;
        this.foodtype = foodtype;
        this.price = price;
        this.cover = cover;
        this.restaurantName = restaurantName;
    }

    public Dish(String name, String foodtype, float price, String cover, String restaurantName) {
        this.name = name;
        this.foodtype = foodtype;
        this.price = price;
        this.cover = cover;
        this.restaurantName = restaurantName;
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

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foodtype='" + foodtype + '\'' +
                ", price=" + price +
                ", cover='" + cover + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                '}';
    }
}

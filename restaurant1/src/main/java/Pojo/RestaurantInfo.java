package Pojo;

public class RestaurantInfo {
    private int id;
    private String name;//食堂名称
    private String introduction;//简介
    private String cover;//食堂图片
    private String location;
    private String time;//营业时间

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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    public RestaurantInfo() {
    }

    public RestaurantInfo(int id, String name, String introduction, String cover, String location, String time) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.cover = cover;
        this.location = location;
        this.time = time;
    }
}

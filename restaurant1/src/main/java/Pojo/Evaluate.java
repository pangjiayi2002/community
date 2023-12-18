package Pojo;

public class Evaluate implements java.io.Serializable{
    int id;
    String title;
    String content;
    String sender;
    String sendertype;
    String restaurant;
    String food;
    String receiver;
    int isread;
    int evaluateID;

    public Evaluate() {
    }


    public Evaluate(int id, String title, String content, String sender, String sendertype, String restaurant, String food, String receiver, int isread,int evaluateID) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.sender = sender;
        this.sendertype = sendertype;
        this.restaurant = restaurant;
        this.food = food;
        this.receiver = receiver;
        this.isread = isread;
        this.evaluateID=evaluateID;
    }

    public Evaluate(String title, String content, String sender, String sendertype, String restaurant, String food, String receiver, int isread, int evaluateID) {
        this.title = title;
        this.content = content;
        this.sender = sender;
        this.sendertype = sendertype;
        this.restaurant = restaurant;
        this.food = food;
        this.receiver = receiver;
        this.isread = isread;
        this.evaluateID = evaluateID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSendertype() {
        return sendertype;
    }

    public void setSendertype(String sendertype) {
        this.sendertype = sendertype;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getIsread() {
        return isread;
    }

    public void setIsread(int isread) {
        this.isread = isread;
    }
    public int getEvaluateID() {
        return evaluateID;
    }

    public void setEvaluateID(int evaluateID) {
        this.evaluateID = evaluateID;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", sendertype='" + sendertype + '\'' +
                ", restaurant='" + restaurant + '\'' +
                ", food='" + food + '\'' +
                ", receiver='" + receiver + '\'' +
                ", isread=" + isread +
                ", evaluateID=" + evaluateID +
                '}';
    }
}

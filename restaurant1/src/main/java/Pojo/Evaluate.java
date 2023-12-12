package Pojo;

public class Evaluate implements java.io.Serializable{
    int id;
    String title;
    String content;
    String sender;
    String sendertype;
    String restuarant;
    String food;
    String receiver;

    public Evaluate() {
    }

    public Evaluate(int id, String title, String content, String sender, String sendertype, String restuarant, String food, String receiver) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.sender = sender;
        this.sendertype = sendertype;
        this.restuarant = restuarant;
        this.food = food;
        this.receiver = receiver;
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

    public String getRestuarant() {
        return restuarant;
    }

    public void setRestuarant(String restuarant) {
        this.restuarant = restuarant;
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
}

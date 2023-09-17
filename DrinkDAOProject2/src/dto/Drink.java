package dto;

public class Drink {
    //ID
    private int id;
    
    //ドリンクの名前
    private String name;

    //ドリンクの価格
    private int price;

    //販売時間のID
    private int time_id;

    //ID用のgetter/setter
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //ドリンクの名前用getter/setter
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //ドリンクの価格用getter/setter
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    //	販売時間のID用getter/setter
    public int getTime_id() {
        return this.time_id;
    }
    public void setTime_id(int time_id) {
        this.time_id = time_id;
    }
}
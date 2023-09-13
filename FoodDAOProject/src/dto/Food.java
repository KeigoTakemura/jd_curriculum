package dto;

public class Food {
    //ID
    private int id;
    
    //フードの名前
    private String name;

    //フードの価格
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

    //フードの名前用getter/setter
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //フードの価格用getter/setter
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
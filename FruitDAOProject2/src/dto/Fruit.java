package dto;

public class Fruit {
    //ID
    private int id;
    
    //フルーツの名前
    private String name;

    //フルーツの値段
    private int price;

    //フルーツの産地
    private int prefecture_id;

    //フルーツの旬の季節
    private int season_id;
    
    //ID用のgetter/setter
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //フルーツの名前用getter/setter
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //フルーツの値段用getter/setter
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    //フルーツの産地用getter/setter
    public int getPrefecture_id() {
        return this.prefecture_id;
    }
    public void setPrefecture_id(int prefecture_id) {
        this.prefecture_id = prefecture_id;
    }
    
    //フルーツの旬の季節用getter/setter
    public int getSeason_id() {
        return this.season_id;
    }
    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }
}
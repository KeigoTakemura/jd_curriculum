package dto;

public class User {
    //ユーザーID
    private int id;
    
    //ユーザーの名前
    private String name;

    //ユーザーの年齢
    private int age;

    //ユーザーの性別
    private int gender;

    //ユーザーID用のgetter/setter
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //ユーザーの名前用getter/setter
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //ユーザーの年齢用getter/setter
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    //ユーザーの年齢用getter/setter
    public int getGender() {
        return this.gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
}
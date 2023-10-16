package com.example.demo.form;

import com.example.demo.entity.Fruit;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class FruitData {
    // ID
    private Integer id;
    // フルーツの名前
    private String name;
    // フルーツの価格
    private Integer price;
    // フルーツの産地
    private Integer prefecture_id;
    // フルーツの旬の季節
    private Integer season_id;

    // Fruitエンティティへの変換
    public Fruit toEntity() {
        Fruit fruit = new Fruit();
        fruit.setId(id);
        fruit.setName(name);
        fruit.setPrice(price);
        fruit.setPrefecture_id(prefecture_id);
        fruit.setSeason_id(season_id);

        return fruit;
    }
}
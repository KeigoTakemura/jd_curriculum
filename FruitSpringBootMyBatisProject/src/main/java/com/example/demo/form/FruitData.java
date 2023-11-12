package com.example.demo.form;

import com.example.demo.entity.Fruit;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class FruitData {
    // フルーツID
	private Integer id;
    // フルーツの名前
	private String name;
    // フルーツの価格
	private Integer price;
	// フルーツの産地
	private Integer prefecture;
	// フルーツの旬の季節
	private Integer season;
	
    // Fruitエンティティへの変換
	public Fruit toEntity() {
		Fruit fruit = new Fruit();
		fruit.setId(id);
		fruit.setName(name);
		fruit.setPrice(price);
		fruit.setPrefecture(prefecture);
		fruit.setSeason(season);
		
		return fruit;
	}
}
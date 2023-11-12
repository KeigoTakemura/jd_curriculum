package com.example.demo.form;

import com.example.demo.entity.Dessert;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class DessertData {
    // デザートID
	private Integer id;
    // デザートの名前
	private String name;
    // デザートの価格
	private Integer price;
	// デザートの販売時間
	private Integer time;
	
    // Dessertエンティティへの変換
	public Dessert toEntity() {
		Dessert dessert = new Dessert();
		dessert.setId(id);
		dessert.setName(name);
		dessert.setPrice(price);
		dessert.setTime(time);
		
		return dessert;
	}
}
package com.example.demo.form;

import com.example.demo.entity.Drink;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class DrinkData {
    // ドリンクID
	private Integer id;
    // ドリンクの名前
	private String name;
    // ドリンクの価格
	private Integer price;
	// ドリンクの販売時間
	private Integer time;
	
    // Drinkエンティティへの変換
	public Drink toEntity() {
		Drink drink = new Drink();
		drink.setId(id);
		drink.setName(name);
		drink.setPrice(price);
		drink.setTime(time);
		
		return drink;
	}
}
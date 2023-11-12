package com.example.demo.form;

import com.example.demo.entity.Food;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class FoodData {
    // フードD
	private Integer id;
    // フードの名前
	private String name;
    // フードの価格
	private Integer price;
	// フードの販売時間
	private Integer time;
	
    // Foodエンティティへの変換
	public Food toEntity() {
		Food food = new Food();
		food.setId(id);
		food.setName(name);
		food.setPrice(price);
		food.setTime(time);
		
		return food;
	}
}
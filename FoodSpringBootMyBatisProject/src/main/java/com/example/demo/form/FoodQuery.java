package com.example.demo.form;

import com.example.demo.entity.Food;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class FoodQuery {
    // フードID
	private Integer id;
    // フードの点数
	private String name;
	
    // Fruitエンティティへの変換
	public Food toEntity() {
		Food food = new Food();
		food.setId(id);
		food.setName(name);
		
		return food;
	}
}
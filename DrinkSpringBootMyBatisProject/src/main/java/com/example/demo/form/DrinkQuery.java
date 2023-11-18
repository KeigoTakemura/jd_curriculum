package com.example.demo.form;

import com.example.demo.entity.Drink;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class DrinkQuery {
    // ドリンクID
	private Integer id;
    // ドリンクの点数
	private String name;
	
    // Drinkエンティティへの変換
	public Drink toEntity() {
		Drink drink = new Drink();
		drink.setId(id);
		drink.setName(name);
		
		return drink;
	}
}
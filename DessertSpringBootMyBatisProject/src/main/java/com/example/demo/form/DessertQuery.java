package com.example.demo.form;

import com.example.demo.entity.Dessert;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class DessertQuery {
    // デザートID
	private Integer id;
    // デザートの点数
	private String name;
	
    // Drinkエンティティへの変換
	public Dessert toEntity() {
		Dessert dessert = new Dessert();
		dessert.setId(id);
		dessert.setName(name);
		
		return dessert;
	}
}
package com.example.demo.form;

import com.example.demo.entity.Fruit;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class FruitQuery {
    // フルーツID
	private Integer id;
    // フルーツの点数
	private String name;
	
    // Fruitエンティティへの変換
	public Fruit toEntity() {
		Fruit fruit = new Fruit();
		fruit.setId(id);
		fruit.setName(name);
		
		return fruit;
	}
}
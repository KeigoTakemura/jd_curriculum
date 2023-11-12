package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Food;
import com.example.demo.repository.FoodMapper;

import lombok.AllArgsConstructor;

// Lombokの使用(すべてのフィールドを引数に持つコンストラクタを自動生成する)
@AllArgsConstructor
// サービスロジックであることを示す
@Service
public class FoodService {
	
    // FoodMapperインターフェイスのインスタンス
	private final FoodMapper foodMapper;
	
    // 全件検索して得られたFoodオブジェクトをリスト形式で返すメソッド
	public List<Food> findAll() {
		return foodMapper.findAll();
	}

    // ID によってFoodオブジェクトを検索するメソッド
	public Food findById(int id) {
		return foodMapper.findById(id);
	}
	
    // Foodオブジェクトを保存するメソッド
	public void save(Food food) {
		foodMapper.save(food);
	}
	
    // Foodオブジェクトを更新するメソッド
	public void update(Food food) {
		foodMapper.update(food);
	}
	
    // ID によってFoodオブジェクトを削除するメソッド
	public void delete(int id) {
		foodMapper.delete(id);
	}
	
	// ID によってFoodオブジェクトを論理削除するメソッド
	public void logicalDelete(int id) {
		foodMapper.logicalDelete(id);
	}
}
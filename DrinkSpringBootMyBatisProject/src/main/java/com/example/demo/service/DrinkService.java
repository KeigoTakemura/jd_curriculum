package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Drink;
import com.example.demo.repository.DrinkMapper;

import lombok.AllArgsConstructor;

// Lombokの使用(すべてのフィールドを引数に持つコンストラクタを自動生成する)
@AllArgsConstructor
// サービスロジックであることを示す
@Service
public class DrinkService {
	
    // DrinkMapperインターフェイスのインスタンス
	private final DrinkMapper drinkMapper;
	
    // 全件検索して得られたDrinkオブジェクトをリスト形式で返すメソッド
	public List<Drink> findAll() {
		return drinkMapper.findAll();
	}

    // ID によってDrinkオブジェクトを検索するメソッド
	public Drink findById(int id) {
		return drinkMapper.findById(id);
	}
	
    // Drinkオブジェクトを保存するメソッド
	public void save(Drink drink) {
		drinkMapper.save(drink);
	}
	
    // Drinkオブジェクトを更新するメソッド
	public void update(Drink drink) {
		drinkMapper.update(drink);
	}
	
    // ID によってDrinkオブジェクトを削除するメソッド
	public void delete(int id) {
		drinkMapper.delete(id);
	}
	
	// ID によってDrinkオブジェクトを論理削除するメソッド
	public void logicalDelete(int id) {
		drinkMapper.logicalDelete(id);
	}
}
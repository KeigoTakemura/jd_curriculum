package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Fruit;
import com.example.demo.repository.FruitMapper;

import lombok.AllArgsConstructor;

// Lombokの使用(すべてのフィールドを引数に持つコンストラクタを自動生成する)
@AllArgsConstructor
// サービスロジックであることを示す
@Service
public class FruitService {
	
    // FruitMapperインターフェイスのインスタンス
	private final FruitMapper fruitMapper;
	
    // 全件検索して得られたFruitオブジェクトをリスト形式で返すメソッド
	public List<Fruit> findAll() {
		return fruitMapper.findAll();
	}

    // ID によってFruitオブジェクトを検索するメソッド
	public Fruit findById(int id) {
		return fruitMapper.findById(id);
	}
	
    // Fruitオブジェクトを保存するメソッド
	public void save(Fruit fruit) {
		fruitMapper.save(fruit);
	}
	
    // Fruitオブジェクトを更新するメソッド
	public void update(Fruit fruit) {
		fruitMapper.update(fruit);
	}
	
    // ID によってFruitオブジェクトを削除するメソッド
	public void delete(int id) {
		fruitMapper.delete(id);
	}
	
	// ID によってFruitオブジェクトを論理削除するメソッド
	public void logicalDelete(int id) {
		fruitMapper.logicalDelete(id);
	}
}
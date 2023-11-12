package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Dessert;
import com.example.demo.repository.DessertMapper;

import lombok.AllArgsConstructor;

// Lombokの使用(すべてのフィールドを引数に持つコンストラクタを自動生成する)
@AllArgsConstructor
// サービスロジックであることを示す
@Service
public class DessertService {
	
    // DessertMapperインターフェイスのインスタンス
	private final DessertMapper dessertMapper;
	
    // 全件検索して得られたDessertオブジェクトをリスト形式で返すメソッド
	public List<Dessert> findAll() {
		return dessertMapper.findAll();
	}

    // ID によってDessertオブジェクトを検索するメソッド
	public Dessert findById(int id) {
		return dessertMapper.findById(id);
	}
	
    // Dessertオブジェクトを保存するメソッド
	public void save(Dessert dessert) {
		dessertMapper.save(dessert);
	}
	
    // Dessertオブジェクトを更新するメソッド
	public void update(Dessert dessert) {
		dessertMapper.update(dessert);
	}
	
    // ID によってDessertオブジェクトを削除するメソッド
	public void delete(int id) {
		dessertMapper.delete(id);
	}
	
	// ID によってDessertオブジェクトを論理削除するメソッド
	public void logicalDelete(int id) {
		dessertMapper.logicalDelete(id);
	}
}
package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Drink;

// MyBatisのマッパーインターフェースを示す
@Mapper
public interface DrinkMapper {
    // すべてのドリンクを検索するメソッド
	List<Drink> findAll();

    // IDを指定してドリンクを検索するメソッド
	Drink findById(int id);
	
	// 検索フォームから受け取った情報をもとに動的検索を実施するメソッド
    List<Drink> search(Drink drink);

    // ドリンク情報を保存するメソッド
	void save(Drink drink);

    // ドリンク情報を更新するメソッド
	void update(Drink drink);

    // IDを指定してドリンクを削除するメソッド
	void delete(int id);
	
	// IDを指定してドリンクを論理削除するメソッド
    void logicalDelete(int id);
}
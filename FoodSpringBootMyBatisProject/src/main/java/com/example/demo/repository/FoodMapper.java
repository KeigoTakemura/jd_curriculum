package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Food;

// MyBatisのマッパーインターフェースを示す
@Mapper
public interface FoodMapper {
    // すべてのフードを検索するメソッド
	List<Food> findAll();

    // IDを指定してフードを検索するメソッド
	Food findById(int id);

    // フード情報を保存するメソッド
	void save(Food food);

    // フード情報を更新するメソッド
	void update(Food food);

    // IDを指定してフードを削除するメソッド
	void delete(int id);
	
	// IDを指定してフードを論理削除するメソッド
    void logicalDelete(int id);
}
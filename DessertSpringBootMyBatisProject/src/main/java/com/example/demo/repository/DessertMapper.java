package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Dessert;

// MyBatisのマッパーインターフェースを示す
@Mapper
public interface DessertMapper {
    // すべてのデザートを検索するメソッド
	List<Dessert> findAll();

    // IDを指定してデザートを検索するメソッド
	Dessert findById(int id);

    // デザート情報を保存するメソッド
	void save(Dessert dessert);

    // デザート情報を更新するメソッド
	void update(Dessert dessert);

    // IDを指定してデザートを削除するメソッド
	void delete(int id);
	
	// IDを指定してデザートを論理削除するメソッド
    void logicalDelete(int id);
}
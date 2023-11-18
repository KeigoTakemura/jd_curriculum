package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Fruit;

// MyBatisのマッパーインターフェースを示す
@Mapper
public interface FruitMapper {
    // すべてのフルーツを検索するメソッド
	List<Fruit> findAll();

    // IDを指定してフルーツを検索するメソッド
	Fruit findById(int id);
	
	// 検索フォームから受け取った情報をもとに動的検索を実施するメソッド
    List<Fruit> search(Fruit fruit);

    // フルーツ情報を保存するメソッド
	void save(Fruit fruit);

    // フルーツ情報を更新するメソッド
	void update(Fruit fruit);

    // IDを指定してフルーツを削除するメソッド
	void delete(int id);
	
	// IDを指定してフルーツを論理削除するメソッド
    void logicalDelete(int id);
}
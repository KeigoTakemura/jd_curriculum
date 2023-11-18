package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;

// MyBatisのマッパーインターフェースを示す
@Mapper
public interface UserMapper {
    // すべての学生を検索するメソッド
	List<User> findAll();

    // IDを指定してユーザーを検索するメソッド
	User findById(int id);
	
	// 検索フォームから受け取った情報をもとに動的検索を実施するメソッド
    List<User> search(User user);

    // ユーザー情報を保存するメソッド
	void save(User user);

    // ユーザー情報を更新するメソッド
	void update(User user);

    // IDを指定してユーザーを削除するメソッド
	void delete(int id);

	// IDを指定してユーザーを論理削除するメソッド
    void logicalDelete(int id);
}
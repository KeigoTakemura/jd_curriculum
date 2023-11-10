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

    // ユーザー情報を保存するメソッド
	void save(User user);

    // ユーザー情報を更新するメソッド
	void update(User user);

    // IDを指定してユーザーを削除するメソッド
	void delete(int id);
}
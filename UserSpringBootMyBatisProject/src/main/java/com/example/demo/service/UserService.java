package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserMapper;

import lombok.AllArgsConstructor;

// Lombokの使用(すべてのフィールドを引数に持つコンストラクタを自動生成する)
@AllArgsConstructor
// サービスロジックであることを示す
@Service
public class UserService {
	
    // UserMapperインターフェイスのインスタンス
	private final UserMapper userMapper;
	
    // 全件検索して得られたUserオブジェクトをリスト形式で返すメソッド
	public List<User> findAll() {
		return userMapper.findAll();
	}

    // ID によってUserオブジェクトを検索するメソッド
	public User findById(int id) {
		return userMapper.findById(id);
	}
	
    // Userオブジェクトを保存するメソッド
	public void save(User user) {
		userMapper.save(user);
	}
	
    // Userオブジェクトを更新するメソッド
	public void update(User user) {
		userMapper.update(user);
	}
	
    // ID によってUserオブジェクトを削除するメソッド
	public void delete(int id) {
		userMapper.delete(id);
	}
}
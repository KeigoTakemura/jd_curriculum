package com.example.demo.form;

import com.example.demo.entity.User;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class UserData {
    // ユーザーID
	private Integer id;
    // ユーザーの名前
	private String name;
    // ユーザーの年齢
	private Integer age;
	// ユーザーの性別
	private Integer gender;
	
    // Userエンティティへの変換
	public User toEntity() {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		user.setGender(gender);
		
		return user;
	}
}
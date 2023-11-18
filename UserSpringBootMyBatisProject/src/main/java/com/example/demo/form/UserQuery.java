package com.example.demo.form;

import com.example.demo.entity.User;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class UserQuery {
    // ユーザーID
	private Integer id;
    // ユーザーの点数
	private String name;
	
    // Userエンティティへの変換
	public User toEntity() {
		User user = new User();
		user.setId(id);
		user.setName(name);
		
		return user;
	}
}
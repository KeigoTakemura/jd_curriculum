package com.example.demo.form;

import com.example.demo.entity.User;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class UserData {
	// 学生ID
    private Integer id;

    // ユーザーの名前
    // 入力されなかった場合に下記メッセージを表示
    @NotBlank(message="名前を入力してください")
    private String name;

    // ユーザーの年齢
    // 入力されなかった場合に下記メッセージを表示
    @NotNull(message="年齢を入力してください")
    // 指定の数値以下が入力された場合に下記メッセージを表示
    @Min(value=0, message="0歳以上で入力してください")
    // 指定の数値以上が入力された場合に下記メッセージを表示
    @Max(value=150, message="150歳以下で入力してください")
    private Integer age;
    
    // ユーザーの性別
    // 入力されなかった場合に下記メッセージを表示
    @NotNull(message="性別を入力してください")
    // 指定の数値以下が入力された場合に下記メッセージを表示
    @Min(value=1, message="1または2で入力してください")
    // 指定の数値以上が入力された場合に下記メッセージを表示
    @Max(value=2, message="1または2で入力してください")
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
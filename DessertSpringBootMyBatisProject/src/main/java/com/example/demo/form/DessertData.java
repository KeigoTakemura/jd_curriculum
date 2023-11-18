package com.example.demo.form;

import com.example.demo.entity.Dessert;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class DessertData {
    // デザートID
	private Integer id;
	
    // デザートの名前
	// 入力されなかった場合に下記メッセージを表示
	@NotBlank(message="名前を入力してください")
	private String name;
	
    // デザートの価格
	// 入力されなかった場合に下記メッセージを表示
	@NotNull(message="価格を入力してください")
	// 指定の数値以下が入力された場合に下記メッセージを表示
	@Min(value=0, message="0円以上で入力してください")
	// 指定の数値以上が入力された場合に下記メッセージを表示
	@Max(value=99999, message="99,999円以下で入力してください")
	private Integer price;
	
	// デザートの販売時間
	// 入力されなかった場合に下記メッセージを表示
	@NotNull(message="時間IDを入力してください")
	// 指定の数値以下が入力された場合に下記メッセージを表示
	@Min(value=1, message="1以上で入力してください")
	// 指定の数値以上が入力された場合に下記メッセージを表示
	@Max(value=4, message="4以下で入力してください")
	private Integer time;
	
    // Dessertエンティティへの変換
	public Dessert toEntity() {
		Dessert dessert = new Dessert();
		dessert.setId(id);
		dessert.setName(name);
		dessert.setPrice(price);
		dessert.setTime(time);
		
		return dessert;
	}
}
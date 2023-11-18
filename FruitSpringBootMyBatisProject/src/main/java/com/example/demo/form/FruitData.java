package com.example.demo.form;

import com.example.demo.entity.Fruit;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class FruitData {
    // フルーツID
	private Integer id;
	
    // フルーツの名前
	// 入力されなかった場合に下記メッセージを表示
	@NotBlank(message="名前を入力してください")
	private String name;
	
    // フルーツの価格
	// 入力されなかった場合に下記メッセージを表示
	@NotNull(message="価格を入力してください")
	// 指定の数値以下が入力された場合に下記メッセージを表示
	@Min(value=0, message="0円以上で入力してください")
	// 指定の数値以上が入力された場合に下記メッセージを表示
	@Max(value=99999, message="99,999円以下で入力してください")
	private Integer price;
	
	// フルーツの産地
	// 入力されなかった場合に下記メッセージを表示
	@NotNull(message="産地IDを入力してください")
	// 指定の数値以下が入力された場合に下記メッセージを表示
	@Min(value=1, message="1以上で入力してください")
	// 指定の数値以上が入力された場合に下記メッセージを表示
	@Max(value=48, message="48以下で入力してください")
	private Integer prefecture;
	
	// フルーツの旬の季節
	// 入力されなかった場合に下記メッセージを表示
	@NotNull(message="季節IDを入力してください")
	// 指定の数値以下が入力された場合に下記メッセージを表示
	@Min(value=1, message="1以上で入力してください")
	// 指定の数値以上が入力された場合に下記メッセージを表示
	@Max(value=4, message="4以下で入力してください")
	private Integer season;
	
    // Fruitエンティティへの変換
	public Fruit toEntity() {
		Fruit fruit = new Fruit();
		fruit.setId(id);
		fruit.setName(name);
		fruit.setPrice(price);
		fruit.setPrefecture(prefecture);
		fruit.setSeason(season);
		
		return fruit;
	}
}
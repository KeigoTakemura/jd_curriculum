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
    // ID
	private Integer id;

    // フルーツの名前
    // 入力されなかった場合に下記メッセージを表示
    @NotBlank(message="名称を入力してください")
    private String name;
    

    // フルーツの価格
    // 入力されなかった場合に下記メッセージを表示
    @NotNull(message="価格を入力してください")
    // 指定の数値以下が入力された場合に下記メッセージを表示
    @Min(value=1, message="1円以上で入力してください")
    // 指定の数値以上が入力された場合に下記メッセージを表示
    @Max(value=99999, message="99,999円以下で入力してください")
    private Integer price;
    // 入力されなかった場合に下記メッセージを表示
    @NotNull(message="産地を入力してください")
    // 指定の数値以下が入力された場合に下記メッセージを表示
    @Min(value=1, message="1以上で入力してください")
    // 指定の数値以上が入力された場合に下記メッセージを表示
    @Max(value=47, message="47以下で入力してください")
    // フルーツの産地
    private Integer prefecture_id;
    // 入力されなかった場合に下記メッセージを表示
    @NotNull(message="旬の季節を入力してください")
    // 指定の数値以下が入力された場合に下記メッセージを表示
    @Min(value=1, message="1以上で入力してください")
    // 指定の数値以上が入力された場合に下記メッセージを表示
    @Max(value=4, message="5以下で入力してください")
    // フルーツの旬の季節
    private Integer season_id;

    // Fruitエンティティへの変換
    public Fruit toEntity() {
        Fruit fruit = new Fruit();
        fruit.setId(id);
        fruit.setName(name);
        fruit.setPrice(price);
        fruit.setPrefecture_id(prefecture_id);
        fruit.setSeason_id(season_id);

        return fruit;
    }
}
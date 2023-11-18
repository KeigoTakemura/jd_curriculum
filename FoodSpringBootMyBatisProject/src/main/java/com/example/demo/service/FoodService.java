package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.entity.Food;
import com.example.demo.form.FoodData;
import com.example.demo.repository.FoodMapper;

import lombok.AllArgsConstructor;

// Lombokの使用(すべてのフィールドを引数に持つコンストラクタを自動生成する)
@AllArgsConstructor
// サービスロジックであることを示す
@Service
public class FoodService {
	
    // FoodMapperインターフェイスのインスタンス
	private final FoodMapper foodMapper;
	
    // 全件検索して得られたFoodオブジェクトをリスト形式で返すメソッド
	public List<Food> findAll() {
		return foodMapper.findAll();
	}

    // ID によってFoodオブジェクトを検索するメソッド
	public Food findById(int id) {
		return foodMapper.findById(id);
	}
	
	// 検索フォームの条件によってFoodオブジェクトを検索するメソッド
	public List<Food> search(Food food) {
		return foodMapper.search(food);
	}
	
    // Foodオブジェクトを保存するメソッド
	public void save(Food food) {
		foodMapper.save(food);
	}
	
    // Foodオブジェクトを更新するメソッド
	public void update(Food food) {
		foodMapper.update(food);
	}
	
    // ID によってFoodオブジェクトを削除するメソッド
	public void delete(int id) {
		foodMapper.delete(id);
	}
	
	// ID によってFoodオブジェクトを論理削除するメソッド
	public void logicalDelete(int id) {
		foodMapper.logicalDelete(id);
	}
	
	// カスタムバリデーション(全角スペースで構成されているかを判定)
    // Controllerからフォームから入力されたFoodDataオブジェクトとデフォルトバリデーションの結果を保持したBindingResultオブジェクトを受け取る
	public boolean isValid(FoodData foodData, BindingResult result) {
        // バリデーションにエラーが含まれるか判定するためのフラグ
		boolean answer = true;
        // FoodDataオブジェクトの名前を取得
		String name = foodData.getName();
        // 名前がnullもしくわ空白でないとき処理を実施
		if (name != null && !name.equals("")) {
            // 全角スペースで構成されているか判定するフラグ
			boolean isAllDoubleSpace = true;
            // 名前を一文字ずつ判定する
			for (int i = 0; i < name.length(); i++) {
                // 文字が全角スペース以外であれば処理を実施
				if (name.charAt(i) != '　') {
                    // 全角スペース判定フラグをfalseに設定
					isAllDoubleSpace = false;
                    //繰り返し処理を抜ける
					break;
				}
			}
            // 全角スペース判定フラグがTrueなら処理を実施
			if (isAllDoubleSpace) {
                // FieldErrorオブジェクトに下記内容を引数として渡す
				FieldError fieldError = new FieldError(
						result.getObjectName(),
						"name",
						"件名が全角スペースです"
						);
                // エラーリストに上記結果を追加する
				result.addError(fieldError);
                //バリデーションエラー判定フラグをfalseに設定
				answer = false;
			}
		}
        // 結果を返す
		return answer;
	}
}
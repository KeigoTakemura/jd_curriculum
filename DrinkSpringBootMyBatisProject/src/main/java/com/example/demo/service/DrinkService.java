package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.entity.Drink;
import com.example.demo.form.DrinkData;
import com.example.demo.repository.DrinkMapper;

import lombok.AllArgsConstructor;

// Lombokの使用(すべてのフィールドを引数に持つコンストラクタを自動生成する)
@AllArgsConstructor
// サービスロジックであることを示す
@Service
public class DrinkService {
	
    // DrinkMapperインターフェイスのインスタンス
	private final DrinkMapper drinkMapper;
	
    // 全件検索して得られたDrinkオブジェクトをリスト形式で返すメソッド
	public List<Drink> findAll() {
		return drinkMapper.findAll();
	}

    // ID によってDrinkオブジェクトを検索するメソッド
	public Drink findById(int id) {
		return drinkMapper.findById(id);
	}
	
	// 検索フォームの条件によってDrinkオブジェクトを検索するメソッド
	public List<Drink> search(Drink drink) {
		return drinkMapper.search(drink);
	}
	
    // Drinkオブジェクトを保存するメソッド
	public void save(Drink drink) {
		drinkMapper.save(drink);
	}
	
    // Drinkオブジェクトを更新するメソッド
	public void update(Drink drink) {
		drinkMapper.update(drink);
	}
	
    // ID によってDrinkオブジェクトを削除するメソッド
	public void delete(int id) {
		drinkMapper.delete(id);
	}
	
	// ID によってDrinkオブジェクトを論理削除するメソッド
	public void logicalDelete(int id) {
		drinkMapper.logicalDelete(id);
	}
	
	// カスタムバリデーション(全角スペースで構成されているかを判定)
    // Controllerからフォームから入力されたDrinkDataオブジェクトとデフォルトバリデーションの結果を保持したBindingResultオブジェクトを受け取る
	public boolean isValid(DrinkData drinkData, BindingResult result) {
        // バリデーションにエラーが含まれるか判定するためのフラグ
		boolean answer = true;
        // DrinkDataオブジェクトの名前を取得
		String name = drinkData.getName();
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
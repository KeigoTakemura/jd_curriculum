package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.entity.User;
import com.example.demo.form.UserData;
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
	
	// 検索フォームの条件によってUserオブジェクトを検索するメソッド
	public List<User> search(User user) {
		return userMapper.search(user);
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
	
	// ID によってUserオブジェクトを論理削除するメソッド
	public void logicalDelete(int id) {
		userMapper.logicalDelete(id);
	}
	
    // カスタムバリデーション(全角スペースで構成されているかを判定)
    // Controllerからフォームから入力されたUserDataオブジェクトとデフォルトバリデーションの結果を保持したBindingResultオブジェクトを受け取る
	public boolean isValid(UserData userData, BindingResult result) {
        // バリデーションにエラーが含まれるか判定するためのフラグ
		boolean answer = true;
        // UserDataオブジェクトの名前を取得
		String name = userData.getName();
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
package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.form.UserData;
import com.example.demo.form.UserQuery;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;

// ControllerクラスがマッピングするURLを定義する
@RequestMapping("/")
// 全てのフィールドを引数とするコンストラクタを自動生成する
@AllArgsConstructor
// コントローラーであることを示す
@Controller
public class UserController {
	
    // UserServiceクラスのインスタンスを保持する
	private final UserService userService;
	
    // 一覧画面にアクセスするメソッド
    // GETリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
	@GetMapping("")
    // ModelAndView: ビュー名とモデルデータを保持するオブジェクト
	public ModelAndView index(ModelAndView mv) {
        // 全件検索した結果をuserオブジェクト型のリストで取得する
		List<User> userList = userService.findAll();
		
        // 表示するView(HTML)の設定
		mv.setViewName("index");
        // データベースから所得したリストデータを「userList」という名前でモデルに設定する
		mv.addObject("userList", userList);
		// 検索値を受け取るため、空のフォームクラス「UserQuery」を設定する
		mv.addObject("userQuery", new UserQuery());
        // モデルデータとViewを返す(index.html)
		return mv;
	}
	
    // 検索結果をもとに一覧画面にアクセスするメソッド
    // POSTリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
	@PostMapping("")
    // @ModelAttribute: リクエストパラメーターから受け取ったデータからUserQueryオブジェクトを作成する
    // ModelAndView: ビュー名とモデルデータを保持するオブジェクト
	public ModelAndView search(@ModelAttribute UserQuery userQuery, ModelAndView mv) {
        // 検索フォームのデータをエンティティに変換
		User user = userQuery.toEntity();
		// 変換したデータをもとに検索
		List<User> userList = userService.search(user);
        // 表示するView(HTML)の設定
		mv.setViewName("index");
        // データベースから所得したリストデータを「userList」という名前でモデルに設定する
		mv.addObject("userList", userList);
        // モデルデータとViewを返す(index.html)
		return mv;
	}
	
    // 新規登録画面にアクセスするメソッド
    // GETリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
	@GetMapping("/create")
    // ModelAndView: ビュー名とモデルデータを保持するオブジェクト
	public ModelAndView create(ModelAndView mv) {
        // 表示するView(HTML)の設定
		mv.setViewName("create");
        // 入力値を受け取るため、空のフォームクラス「UserData」を設定する
		mv.addObject("userData", new UserData());
        // モデルデータとViewを返す(create.html)
		return mv;
	}
	
    // 新規登録処理を行うメソッド
	// POSTリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
	@PostMapping("/create")
	// @ModelAttribute: リクエストパラメーターから受け取ったデータからUserDataオブジェクトを作成する
	// @Validated: 入力フォームのデータ検証
	// BindingResult: 検証結果を保持
	// ModelAndView: ビュー名とモデルデータを保持するオブジェクト
	public ModelAndView save(@ModelAttribute @Validated UserData userData, BindingResult result, ModelAndView mv) {
	    // ServiceロジックのisValidメソッドを呼び出し、結果をboolean型で受け取る
	    boolean isValid = userService.isValid(userData, result);
	    // 入力フォームの検証結果にエラーが含まれる場合、入力値を保持した状態で新規登録画面へ戻す。
	    // デフォルトのバリデーションチェック or カスタムバリデーションにエラーが検出されたらcreate.htmlへ返す
		if (result.hasErrors() || !isValid) {
	        // 表示するView(HTML)の設定
			mv.setViewName("create");
	        // モデルデータとViewを返す(新規登録画面create.html)
			return mv;

	    // 検証結果にエラーが含まれない場合、登録処理を行う。
		} else {
	        // 入力フォームのデータをエンティティに変換
			User user = userData.toEntity();
	        // 変換したデータをデータベースへ保存
			userService.save(user);
	        // リダイレクト先の設定
			mv.setViewName("redirect:/");
	        // モデルデータとViewを返す(一覧画面index.html)
			return mv;			
		}
	}
	
    // 編集画面にアクセスするメソッド
    // GETリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
	@GetMapping("/edit/{id}")
    // @PathVariable: URLパラメーターからデータを受け取って変数にセット(バインド)する
    // ModelAndView: ビュー名とモデルデータを保持するオブジェクト
	public ModelAndView edit(@PathVariable("id") int id, ModelAndView mv) {
        // URLパスパラメーターから受け取ったIDに一致するユーザー情報の取得
		User user = userService.findById(id);
        // 表示するView(HTML)の設定
		mv.setViewName("edit");
        // 検索結果を「UserData」として設定する
		mv.addObject("userData", user);
        // モデルデータとViewを返す(edit.html)
		return mv;
	}

	// 変更処理を行うメソッド
	// PATCHリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。      
	@PatchMapping("/update")
	// @ModelAttribute: リクエストパラメーターから受け取ったデータからUserDataオブジェクトを作成する
	// @Validated: 入力フォームのデータ検証
	// BindingResult: 検証結果を保持
	// ModelAndView: ビュー名とモデルデータを保持するオブジェクト
	public ModelAndView update(@ModelAttribute UserData userData, BindingResult result, ModelAndView mv) {
	    // ServiceロジックのisValidメソッドを呼び出し、結果をboolean型で受け取る
	    boolean isValid = userService.isValid(userData, result);
	    // 入力フォームの検証結果にエラーが含まれる場合、入力値を保持した状態で新規登録画面へ戻す。
	    // デフォルトのバリデーションチェック or カスタムバリデーションにエラーが検出されたらcreate.htmlへ返す
		if (result.hasErrors() || !isValid) {
	        // 表示するView(HTML)の設定
			mv.setViewName("edit");
	        // モデルデータとViewを返す(新規登録画面edit.html)
			return mv;

	    // 検証結果にエラーが含まれない場合、登録処理を行う。
		} else {
	        // 入力フォームのデータをエンティティに変換
			User user = userData.toEntity();
	        // 変換したデータでデータベースを更新
			userService.update(user);
	        // リダイレクト先の設定
			mv.setViewName("redirect:/edit/" + user.getId());
	        // モデルデータとViewを返す(一覧画面index.html)
			return mv;
		}
	}
	
		// 削除処理を行うメソッド
	    // DELETEリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
		@DeleteMapping("/delete")
	    // @RequestParam: リクエストパラメーターから受け取ったデータを変数にセット(バインド)する
		public String delete(@RequestParam("id") int id) {
	        // リクエストパラメーターから受け取ったIDに一致するフルーツ情報を削除
			userService.delete(id);
	        // 一覧画面(index.html)へリダイレクト
			return "redirect:/";
		}	
		
    // 論理削除処理を行うメソッド
    // PATCHリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
	@PatchMapping("/logical/delete")
    // @RequestParam: リクエストパラメーターから受け取ったデータを変数にセット(バインド)する
	public String logicalDelete(@RequestParam("id") int id) {
        // リクエストパラメーターから受け取ったIDに一致するユーザー情報を論理削除
		userService.logicalDelete(id);
        // 一覧画面(index.html)へリダイレクト
		return "redirect:/";
	}
}
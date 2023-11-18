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

import com.example.demo.entity.Drink;
import com.example.demo.form.DrinkData;
import com.example.demo.form.DrinkQuery;
import com.example.demo.service.DrinkService;

import lombok.AllArgsConstructor;

// ControllerクラスがマッピングするURLを定義する
@RequestMapping("/")
// 全てのフィールドを引数とするコンストラクタを自動生成する
@AllArgsConstructor
// コントローラーであることを示す
@Controller
public class DrinkController {
	
    // DrinkServiceクラスのインスタンスを保持する
	private final DrinkService drinkService;
	
    // 一覧画面にアクセスするメソッド
    // GETリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
	@GetMapping("")
    // ModelAndView: ビュー名とモデルデータを保持するオブジェクト
	public ModelAndView index(ModelAndView mv) {
        // 全件検索した結果をdrinkオブジェクト型のリストで取得する
		List<Drink> drinkList = drinkService.findAll();
		
        // 表示するView(HTML)の設定
		mv.setViewName("index");
        // データベースから所得したリストデータを「drinkList」という名前でモデルに設定する
		mv.addObject("drinkList", drinkList);
		// 検索値を受け取るため、空のフォームクラス「DrinkQuery」を設定する
		mv.addObject("drinkQuery", new DrinkQuery());
        // モデルデータとViewを返す(index.html)
		return mv;
	}
	
    // 検索結果をもとに一覧画面にアクセスするメソッド
    // POSTリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
	@PostMapping("")
    // @ModelAttribute: リクエストパラメーターから受け取ったデータからDrinkQueryオブジェクトを作成する
    // ModelAndView: ビュー名とモデルデータを保持するオブジェクト
	public ModelAndView search(@ModelAttribute DrinkQuery drinkQuery, ModelAndView mv) {
        // 検索フォームのデータをエンティティに変換
		Drink drink = drinkQuery.toEntity();
		// 変換したデータをもとに検索
		List<Drink> drinkList = drinkService.search(drink);
        // 表示するView(HTML)の設定
		mv.setViewName("index");
        // データベースから所得したリストデータを「drinkList」という名前でモデルに設定する
		mv.addObject("drinkList", drinkList);
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
        // 入力値を受け取るため、空のフォームクラス「DrinkData」を設定する
		mv.addObject("drinkData", new DrinkData());
        // モデルデータとViewを返す(create.html)
		return mv;
	}
	
	// 新規登録処理を行うメソッド
	// POSTリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
	@PostMapping("/create")
	// @ModelAttribute: リクエストパラメーターから受け取ったデータからDrinkDataオブジェクトを作成する
	// @Validated: 入力フォームのデータ検証
	// BindingResult: 検証結果を保持
	// ModelAndView: ビュー名とモデルデータを保持するオブジェクト
	public ModelAndView save(@ModelAttribute @Validated DrinkData drinkData, BindingResult result, ModelAndView mv) {
	    // ServiceロジックのisValidメソッドを呼び出し、結果をboolean型で受け取る
	    boolean isValid = drinkService.isValid(drinkData, result);
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
			Drink drink = drinkData.toEntity();
	        // 変換したデータをデータベースへ保存
			drinkService.save(drink);
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
        // URLパスパラメーターから受け取ったIDに一致するドリンク情報の取得
		Drink drink = drinkService.findById(id);
        // 表示するView(HTML)の設定
		mv.setViewName("edit");
        // 検索結果を「DrinkData」として設定する
		mv.addObject("drinkData", drink);
        // モデルデータとViewを返す(edit.html)
		return mv;
	}

	// 更新処理を行うメソッド
	// PATCHリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。      
	@PatchMapping("/update")
	// @ModelAttribute: リクエストパラメーターから受け取ったデータからDrinkDataオブジェクトを作成する
	// @Validated: 入力フォームのデータ検証
	// BindingResult: 検証結果を保持
	// ModelAndView: ビュー名とモデルデータを保持するオブジェクト
	public ModelAndView update(@ModelAttribute @Validated DrinkData drinkData, BindingResult result, ModelAndView mv) {
	    // ServiceロジックのisValidメソッドを呼び出し、結果をboolean型で受け取る
	    boolean isValid = drinkService.isValid(drinkData, result);
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
			Drink drink = drinkData.toEntity();
	        // 変換したデータでデータベースを更新
			drinkService.update(drink);
	        // リダイレクト先の設定
			mv.setViewName("redirect:/edit/" + drink.getId());
	        // モデルデータとViewを返す(一覧画面index.html)
			return mv;
		}
	}
	
    // 削除処理を行うメソッド
    // DELETEリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
	@DeleteMapping("/delete")
    // @RequestParam: リクエストパラメーターから受け取ったデータを変数にセット(バインド)する
	public String delete(@RequestParam("id") int id) {
        // リクエストパラメーターから受け取ったIDに一致するフード情報を削除
		drinkService.delete(id);
        // 一覧画面(index.html)へリダイレクト
		return "redirect:/";
	}
	
    // 論理削除処理を行うメソッド
    // PATCHリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
	@PatchMapping("/logical/delete")
    // @RequestParam: リクエストパラメーターから受け取ったデータを変数にセット(バインド)する
	public String logicalDelete(@RequestParam("id") int id) {
        // リクエストパラメーターから受け取ったIDに一致するドリンク情報を論理削除
		drinkService.logicalDelete(id);
        // 一覧画面(index.html)へリダイレクト
		return "redirect:/";
	}
}
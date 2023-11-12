package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
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
	public String save(@ModelAttribute DrinkData drinkData) {
        // 入力フォームのデータをエンティティに変換
		Drink drink = drinkData.toEntity();
        // 変換したデータをデータベースへ保存
		drinkService.save(drink);
        // 一覧画面(index.html)へリダイレクト
		return "redirect:/";
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
	public String update(@ModelAttribute DrinkData drinkData) {
        // 入力フォームから受け取った更新データをエンティティに変換
		Drink drink = drinkData.toEntity();
        // 変換したデータを使用してデータベースを更新
		drinkService.update(drink);
        // 更新対象者の編集画面(edit.html)へリダイレクト
		return "redirect:/edit/" + drink.getId();
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
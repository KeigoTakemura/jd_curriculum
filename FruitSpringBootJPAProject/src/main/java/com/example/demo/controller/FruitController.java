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

import com.example.demo.entity.Fruit;
import com.example.demo.form.FruitData;
import com.example.demo.service.FruitService;

import lombok.AllArgsConstructor;

// ControllerクラスがマッピングするURLを定義する
@RequestMapping("/")
// 全てのフィールドを引数とするコンストラクタを自動生成する
@AllArgsConstructor
// Controllerクラスであることを示す
@Controller
public class FruitController {

    // FruitServiceクラスのインスタンスを保持する
    private final FruitService fruitService;

    // 一覧画面にアクセスするメソッド
    // GETリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
    @GetMapping("")
    // ModelAndView: ビュー名とモデルデータを保持するオブジェクト
    public ModelAndView index(ModelAndView mv) {
        // 全件検索した結果をfruitオブジェクト型のリストで取得する
        List<Fruit> fruitList = fruitService.findAll();

        // 表示するView(HTML)の設定
        mv.setViewName("index");
        // データベースから所得したリストデータを「fruitList」という名前でモデルに設定する
        mv.addObject("fruitList", fruitList);
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
        // 入力値を受け取るため、空のフォームクラス「FruitData」を設定する
        mv.addObject("fruitData", new FruitData());
        // モデルデータとViewを返す(create.html)
        return mv;
    }

    // 新規登録処理を行うメソッド
    // POSTリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
    @PostMapping("/create")
    // @ModelAttribute: リクエストパラメーターから受け取ったデータからFruitDataオブジェクトを作成する
    public String save(@ModelAttribute FruitData fruitData) {
        // 入力フォームのデータをエンティティに変換
        Fruit fruit = fruitData.toEntity();
        // 変換したデータをデータベースへ保存
        fruitService.save(fruit);
        // 一覧画面(index.html)へリダイレクト
        return "redirect:/";
    }

    // 編集画面にアクセスするメソッド
    // GETリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
    @GetMapping("/edit/{id}")
    // @PathVariable: URLパラメーターからデータを受け取って変数にセット(バインド)する
    // ModelAndView: ビュー名とモデルデータを保持するオブジェクト
    public ModelAndView edit(@PathVariable("id") int id, ModelAndView mv) {
        // URLパスパラメーターから受け取ったIDに一致するフルーツ情報の取得
        Fruit fruit = fruitService.findById(id);
        // 表示するView(HTML)の設定
        mv.setViewName("edit");
        // 検索結果を「UserData」として設定する
        mv.addObject("fruitData", fruit);
        // モデルデータとViewを返す(edit.html)
        return mv;
    }

    // 更新処理を行うメソッド
    // PATCHリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
    @PatchMapping("/update")
    // @ModelAttribute: リクエストパラメーターから受け取ったデータからFruitDataオブジェクトを作成する
    public String update(@ModelAttribute FruitData fruitData) {
        // 入力フォームから受け取った更新データをエンティティに変換
        Fruit fruit = fruitData.toEntity();
        // 変換したデータを使用してデータベースを更新
        fruitService.update(fruit);
        // 更新対象者の編集画面(edit.html)へリダイレクト
        return "redirect:/edit/" + fruit.getId();
    }

    // 削除処理を行うメソッド
    // DELETEリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
    @DeleteMapping("/delete")
    // @RequestParam: リクエストパラメーターから受け取ったデータを変数にセット(バインド)する
    public String delete(@RequestParam("id") int id) {
        // リクエストパラメーターから受け取ったIDに一致するフルーツの情報を削除
        fruitService.delete(id);
        // 一覧画面(index.html)へリダイレクト
        return "redirect:/";
    }

    // 論理削除処理を行うメソッド
    // DELETEリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
//	@DeleteMapping("/logical/delete")
//    // @RequestParam: リクエストパラメーターから受け取ったデータを変数にセット(バインド)する
//	public String logicalDelete(@RequestParam("id") int id) {
//        // リクエストパラメーターから受け取ったIDに一致する学生情報を論理削除
//		studentService.logicalDelete(id);
//        // 一覧画面(index.html)へリダイレクト
//		return "redirect:/";
//	}
}
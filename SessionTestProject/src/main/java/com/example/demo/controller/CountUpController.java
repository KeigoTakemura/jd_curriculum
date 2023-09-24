package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

//ControllerクラスがマッピングするURLを定義する
@RequestMapping("/")
//全てのフィールドを引数とするコンストラクタを自動生成する
@AllArgsConstructor
//Controllerクラスであることを示す
@Controller
public class CountUpController {
	
    // HttpSessionインスタンスを保持する
	private final HttpSession session;
	
	// Session登録フォーム画面にアクセスするメソッド
	@GetMapping
	// ModelAndView: ビュー名とモデルデータを保持するオブジェクト
	public ModelAndView index(ModelAndView mv) {
		// セッション「num」をInteger型で取得
		Integer num = (Integer)session.getAttribute("num");
		// numがnullでの場合は０で初期化しセッションへセット
		if (num == null) {
			num = 0;
			session.setAttribute("num", num);
		}
		// 表示するView(HTML)の設定
		mv.setViewName("index");
		// numをモデルに設定
		mv.addObject("num", num);
		// モデルデータとViewを返す(index.html)
		return mv;
	}
	
	// Sessionへの追加処理メソッド
	@PostMapping("/up")
	public String up() {
		// セッション領域から「num」を取得し、Integerへキャスト
		Integer num = (Integer)session.getAttribute("num");
		// numに加算
		num++;
		// セッション領域に加算した数値をセット
		session.setAttribute("num", num);
		// Topへリダイレクト
		return "redirect:/";
	}
	
	@PostMapping("/reset")
	public String reset() {
		// セッション領域の「num」を削除
		session.removeAttribute("num");
		// Topへリダイレクト
		return "redirect:/";
	}
}
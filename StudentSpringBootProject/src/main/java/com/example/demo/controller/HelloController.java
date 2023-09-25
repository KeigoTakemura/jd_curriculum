package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.form.IdData;
import com.example.demo.form.NameData;
import com.example.demo.form.ScoreData;

// ControllerクラスがマッピングするURLを定義する
@RequestMapping("/")
// Controllerクラスであることを示す
@Controller
public class HelloController {

    // GETリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
    @GetMapping("/hello1")
    // 返される文字列をHTTPレスポンスとすることを示す
    @ResponseBody
    public String hello1() {
        // Hello Worldという文字列を返す
        return "Hello World";
    }

    // GETリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
    @GetMapping("/hello2")
    // 返される文字列をHTTPレスポンスとすることを示す
    @ResponseBody
    // @RequestParam: リクエストパラメーターから受け取ったデータを変数にセット(バインド)する
    public String hello2(@RequestParam("name") String name) {
        // リクエストパラメータから取得した名前を用いて、「こんにちは、○○さん」という文字列を返す
        return "こんにちは、 "  + name + "さん";
    }

    // GETリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
    @GetMapping("/hello3/{name}")
    // 返される文字列をHTTPレスポンスとすることを示す
    @ResponseBody
    // @PathVariable: URLパラメーターからデータを受け取って変数にセット(バインド)する
    public String hello3(@PathVariable("name") String name) {
        // URLパラメータから取得した名前を用いて、「こんにちは、○○さん」という文字列を返す
        return "こんにちは、 "  + name + "さん"; 
    }	

    // POSTリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する
    @PostMapping("/hello4")
    // 返される文字列をHTTPレスポンスとすることを示す
    @ResponseBody
    // @RequestParam: リクエストパラメーターから受け取ったデータを変数にセット(バインド)する
    public String hello4(@RequestParam("name") String name) {
        // リクエストパラメータから取得した名前を用いて、「こんにちは、○○さん」という文字列を返す
        return "こんにちは、 "  + name + "さん"; 
    }

    // GETリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
    @GetMapping("/hello5")
    // @RequestParam: リクエストパラメーターから受け取ったデータを変数にセット(バインド)する
    // ModelAndView: ビュー名とモデルデータを保持するオブジェクト
    public ModelAndView hello5(@RequestParam("name") String name, @RequestParam("id") int id, @RequestParam("score") int score,ModelAndView mv) {
        // 表示するHtmlの設定
        mv.setViewName("hello5");
        // 「name」という名前でリクエストパラメーターの値を受け渡す
        mv.addObject("name", name);
        // 「id」という名前でリクエストパラメーターの値を受け渡す
        mv.addObject("id", id);
        // 「score」という名前でリクエストパラメーターの値を受け渡す
        mv.addObject("score", score);
        // 設定したモデルデータとViewを返す
        return mv;
    }

    // POSTリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
    @PostMapping("/hello6")
    // @RequestParam: リクエストパラメーターから受け取ったデータを変数にセット(バインド)する
    // ModelAndView: ビュー名とモデルデータを保持するオブジェクト
    public ModelAndView hello6(@RequestParam("name") String name, @RequestParam("id") int id, @RequestParam("score") int score, ModelAndView mv) {
        // 表示するHtmlの設定
        mv.setViewName("hello6");
        // 「name」という名前でリクエストパラメーターの値を受け渡す
        mv.addObject("name", name);
        // 「id」という名前でリクエストパラメーターの値を受け渡す
        mv.addObject("id", id);
        // 「score」という名前でリクエストパラメーターの値を受け渡す
        mv.addObject("score", score);
        // 設定したモデルデータとViewを返す
        return mv;
    }
    
    // POSTリクエストを受け取ることを指定する。また、メソッドがマッピングするURLの定義する。
    @PostMapping("/hello7")
    // @ModelAttribute: リクエストパラメーターから受け取ったデータからNameDataオブジェクトを作成する
    // ModelAndView: ビュー名とモデルデータを保持するオブジェクト
    public ModelAndView hello7(@ModelAttribute NameData nameData, @ModelAttribute IdData idData, @ModelAttribute ScoreData scoreData, ModelAndView mv) {
        // 表示するHtmlの設定
        mv.setViewName("hello7");
        // 「name」という名前でリクエストパラメーターの値を受け渡す
        mv.addObject("NameData", nameData);
        // 「id」という名前でリクエストパラメーターの値を受け渡す
        mv.addObject("IdData", idData);
        // 「score」という名前でリクエストパラメーターの値を受け渡す
        mv.addObject("ScoreData", scoreData);
        // 設定したモデルデータとViewを返す
        return mv;
    }
}
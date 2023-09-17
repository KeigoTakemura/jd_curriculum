package service;

import java.util.List;

import dao.FoodDao;
import dao.FoodDaoImpl;
import dto.Food;

public class FoodService {
    // FoodDaoオブジェクトを格納するフィールド
    private FoodDao foodDao;
    
    // FoodDaoImplオブジェクトをインスタンス化し、FoodDaoフィールドに格納するコンストラクタ
    public FoodService() {
        this.foodDao = new FoodDaoImpl();
    }

    // すべてのフードの情報を検索して、検索結果を表示するメソッド
    public void findAll() {
        System.out.println("------------------------------------------------------");
        System.out.println("【全件検索】");

        // すべてのフードの情報を検索して、結果をFoodオブジェクト型のリストへ格納
        List<Food> foods = foodDao.findAll();
        // 検索結果を1件ずつ表示
        for (Food food : foods) {
            System.out.print("ID: " + food.getId() + ", ");
            System.out.print("名前: " + food.getName() + ", ");
            System.out.println("価格: " + food.getPrice() + "円");
            System.out.println("販売時間: " + food.getTime_id());
        }
        System.out.println("------------------------------------------------------");
    }

    // IDに合致するフードの情報を検索して、検索結果を表示するメソッド
    public void findById(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【ID検索】");

        // IDに合致するフードの情報を検索して、結果をFoodオブジェクト型へ格納
        Food food = foodDao.findById(id);
        // 検索結果を表示
        System.out.print("ID: " + food.getId() + ", ");
        System.out.print("名前: " + food.getName() + ", ");
        System.out.println("価格: " + food.getPrice() + "円");
        System.out.println("販売時間: " + food.getTime_id());
        System.out.println("------------------------------------------------------");
    }

    // フードの情報を登録するメソッド(実行結果を表示する)
    public void save(int id, String name, int price, int time_id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【新規登録】");

        // Foodオブジェクトを作成、ID, Name, price, time_idをセットする
        Food food = new Food();
        food.setId(id);
        food.setName(name);
        food.setPrice(price);
        food.setTime_id(time_id);

        // オブジェクトの情報を保存、実行結果を受け取る
        boolean result = foodDao.save(food);

        // 実行結果の表示
        if (result) {
            System.out.println("登録しました。");
        } else {
            System.out.println("登録に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }

    // フードの情報を更新するメソッド(実行結果を表示する)
    public void update(int id, int price) {
        System.out.println("------------------------------------------------------");
        System.out.println("【更新】");

        // Foodオブジェクトを作成、ID, Priceをセットする
        Food food = new Food();
        food.setId(id);
        food.setPrice(price);

        // オブジェクトの情報で更新、実行結果を受け取る
        boolean result = foodDao.update(food);

        // 実行結果の表示
        if (result) {
            System.out.println("更新しました。");
        } else {
            System.out.println("更新に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }

    // フードの情報を削除するメソッド(実行結果を表示する)
    public void delete(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【削除】");

        // ID情報で削除、実行結果を受け取る
        boolean result = foodDao.delete(id);

        // 実行結果の表示
        if (result) {
            System.out.println("削除しました。");
        } else {
            System.out.println("削除に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }
    
    // 	フードの報を論理削除するメソッド(実行結果を表示する)
    public void logical(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【論理削除】");

        // ID情報で削除、実行結果を受け取る
        boolean result = foodDao.delete(id);

        // 実行結果の表示
        if (result) {
            System.out.println("論理削除しました。");
        } else {
            System.out.println("論理削除に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }
}
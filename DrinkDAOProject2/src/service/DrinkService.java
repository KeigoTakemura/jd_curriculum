package service;

import java.util.List;

import dao.DrinkDao;
import dao.DrinkDaoImpl;
import dto.Drink;

public class DrinkService {
    // DrinkDaoオブジェクトを格納するフィールド
    private DrinkDao drinkDao;
    
    // DrinkDaoImplオブジェクトをインスタンス化し、DrinkDaoフィールドに格納するコンストラクタ
    public DrinkService() {
        this.drinkDao = new DrinkDaoImpl();
    }

    // すべてのドリンクの情報を検索して、検索結果を表示するメソッド
    public void findAll() {
        System.out.println("------------------------------------------------------");
        System.out.println("【全件検索】");

        // すべてのドリンクの情報を検索して、結果をDrinkオブジェクト型のリストへ格納
        List<Drink> drinks = drinkDao.findAll();
        // 検索結果を1件ずつ表示
        for (Drink drink : drinks) {
            System.out.print("ID: " + drink.getId() + ", ");
            System.out.print("名前: " + drink.getName() + ", ");
            System.out.println("価格: " + drink.getPrice() + "円");
            System.out.println("販売時間: " + drink.getTime_id());
        }
        System.out.println("------------------------------------------------------");
    }

    // IDに合致するドリンクの情報を検索して、検索結果を表示するメソッド
    public void findById(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【ID検索】");

        // IDに合致するドリンクの情報を検索して、結果をDrinkオブジェクト型へ格納
        Drink drink = drinkDao.findById(id);
        // 検索結果を表示
        System.out.print("ID: " + drink.getId() + ", ");
        System.out.print("名前: " + drink.getName() + ", ");
        System.out.println("価格: " + drink.getPrice() + "円");
        System.out.println("販売時間: " + drink.getTime_id());
        System.out.println("------------------------------------------------------");
    }

    // ドリンクの情報を登録するメソッド(実行結果を表示する)
    public void save(int id, String name, int price, int time_id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【新規登録】");

        // Drinkオブジェクトを作成、ID, Name, price, time_idをセットする
        Drink drink = new Drink();
        drink.setId(id);
        drink.setName(name);
        drink.setPrice(price);
        drink.setTime_id(time_id);

        // オブジェクトの情報を保存、実行結果を受け取る
        boolean result = drinkDao.save(drink);

        // 実行結果の表示
        if (result) {
            System.out.println("登録しました。");
        } else {
            System.out.println("登録に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }

    // ドリンクの情報を更新するメソッド(実行結果を表示する)
    public void update(int id, int price) {
        System.out.println("------------------------------------------------------");
        System.out.println("【更新】");

        // Drinkオブジェクトを作成、ID, Priceをセットする
        Drink drink = new Drink();
        drink.setId(id);
        drink.setPrice(price);

        // オブジェクトの情報で更新、実行結果を受け取る
        boolean result = drinkDao.update(drink);

        // 実行結果の表示
        if (result) {
            System.out.println("更新しました。");
        } else {
            System.out.println("更新に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }

    // ドリンクの情報を削除するメソッド(実行結果を表示する)
    public void delete(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【削除】");

        // ID情報で削除、実行結果を受け取る
        boolean result = drinkDao.delete(id);

        // 実行結果の表示
        if (result) {
            System.out.println("削除しました。");
        } else {
            System.out.println("削除に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }
    
    // 	ドリンクの報を論理削除するメソッド(実行結果を表示する)
    public void logical(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【論理削除】");

        // ID情報で削除、実行結果を受け取る
        boolean result = drinkDao.delete(id);

        // 実行結果の表示
        if (result) {
            System.out.println("論理削除しました。");
        } else {
            System.out.println("論理削除に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }
}
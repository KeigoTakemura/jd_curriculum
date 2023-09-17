package service;

import java.util.List;

import dao.DessertDao;
import dao.DessertDaoImpl;
import dto.Dessert;

public class DessertService {
    // DessertDaoオブジェクトを格納するフィールド
    private DessertDao dessertDao;
    
    // DessertDaoImplオブジェクトをインスタンス化し、DessertDaoフィールドに格納するコンストラクタ
    public DessertService() {
        this.dessertDao = new DessertDaoImpl();
    }

    // すべてのデザートの情報を検索して、検索結果を表示するメソッド
    public void findAll() {
        System.out.println("------------------------------------------------------");
        System.out.println("【全件検索】");

        // すべてのデザートの情報を検索して、結果をDessertオブジェクト型のリストへ格納
        List<Dessert> desserts = dessertDao.findAll();
        // 検索結果を1件ずつ表示
        for (Dessert dessert : desserts) {
            System.out.print("ID: " + dessert.getId() + ", ");
            System.out.print("名前: " + dessert.getName() + ", ");
            System.out.println("価格: " + dessert.getPrice() + "円");
            System.out.println("販売時間: " + dessert.getTime_id());
        }
        System.out.println("------------------------------------------------------");
    }

    // IDに合致するデザートの情報を検索して、検索結果を表示するメソッド
    public void findById(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【ID検索】");

        // IDに合致するデザートの情報を検索して、結果をDessertオブジェクト型へ格納
        Dessert dessert = dessertDao.findById(id);
        // 検索結果を表示
        System.out.print("ID: " + dessert.getId() + ", ");
        System.out.print("名前: " + dessert.getName() + ", ");
        System.out.println("価格: " + dessert.getPrice() + "円");
        System.out.println("販売時間: " + dessert.getTime_id());
        System.out.println("------------------------------------------------------");
    }

    // デザートの情報を登録するメソッド(実行結果を表示する)
    public void save(int id, String name, int price, int time_id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【新規登録】");

        // Dessertオブジェクトを作成、ID, Name, price, time_idをセットする
        Dessert dessert = new Dessert();
        dessert.setId(id);
        dessert.setName(name);
        dessert.setPrice(price);
        dessert.setTime_id(time_id);

        // オブジェクトの情報を保存、実行結果を受け取る
        boolean result = dessertDao.save(dessert);

        // 実行結果の表示
        if (result) {
            System.out.println("登録しました。");
        } else {
            System.out.println("登録に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }

    // デザートの情報を更新するメソッド(実行結果を表示する)
    public void update(int id, int price) {
        System.out.println("------------------------------------------------------");
        System.out.println("【更新】");

        // Dessertオブジェクトを作成、ID, Priceをセットする
        Dessert dessert = new Dessert();
        dessert.setId(id);
        dessert.setPrice(price);

        // オブジェクトの情報で更新、実行結果を受け取る
        boolean result = dessertDao.update(dessert);

        // 実行結果の表示
        if (result) {
            System.out.println("更新しました。");
        } else {
            System.out.println("更新に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }

    // デザートの情報を削除するメソッド(実行結果を表示する)
    public void delete(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【削除】");

        // ID情報で削除、実行結果を受け取る
        boolean result = dessertDao.delete(id);

        // 実行結果の表示
        if (result) {
            System.out.println("削除しました。");
        } else {
            System.out.println("削除に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }
    
    // 	デザートの報を論理削除するメソッド(実行結果を表示する)
    public void logical(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【論理削除】");

        // ID情報で削除、実行結果を受け取る
        boolean result = dessertDao.delete(id);

        // 実行結果の表示
        if (result) {
            System.out.println("論理削除しました。");
        } else {
            System.out.println("論理削除に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }
}
package service;

import java.util.List;

import dao.FruitDao;
import dao.FruitDaoImpl;
import dto.Fruit;

public class FruitService {
    // FruitDaoオブジェクトを格納するフィールド
    private FruitDao fruitDao;
    
    // FruitDaoImplオブジェクトをインスタンス化し、FruitDaoフィールドに格納するコンストラクタ
    public FruitService() {
        this.fruitDao = new FruitDaoImpl();
    }

    // すべてのフルーツの情報を検索して、検索結果を表示するメソッド
    public void findAll() {
        System.out.println("------------------------------------------------------");
        System.out.println("【全件検索】");

        // すべてのフルーツの情報を検索して、結果をFruitオブジェクト型のリストへ格納
        List<Fruit> fruits = fruitDao.findAll();
        // 検索結果を1件ずつ表示
        for (Fruit fruit : fruits) {
            System.out.print("ID: " + fruit.getId() + ", ");
            System.out.print("名前: " + fruit.getName() + ", ");
            System.out.println("値段: " + fruit.getPrice() + "円");
            System.out.println("産地: " + fruit.getPrefecture_id());
            System.out.println("季節: " + fruit.getSeason_id());
        }
        System.out.println("------------------------------------------------------");
    }

    // IDに合致するフルーツの情報を検索して、検索結果を表示するメソッド
    public void findById(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【ID検索】");

        // IDに合致するフルーツの情報を検索して、結果をFruitオブジェクト型へ格納
        Fruit fruit = fruitDao.findById(id);
        // 検索結果を表示
        System.out.print("ID: " + fruit.getId() + ", ");
        System.out.print("名前: " + fruit.getName() + ", ");
        System.out.println("値段: " + fruit.getPrice() + "円");
        System.out.println("産地: " + fruit.getPrefecture_id());
        System.out.println("季節: " + fruit.getSeason_id());
        System.out.println("------------------------------------------------------");
    }

    // 	フルーツの情報を登録するメソッド(実行結果を表示する)
    public void save(int id, String name, int price, int prefecture_id, int season_id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【新規登録】");

        // Fruitオブジェクトを作成、ID, Name, price, prefecture_id, season_idをセットする
        Fruit fruit = new Fruit();
        fruit.setId(id);
        fruit.setName(name);
        fruit.setPrice(price);
        fruit.setPrefecture_id(prefecture_id);
        fruit.setSeason_id(season_id);

        // オブジェクトの情報を保存、実行結果を受け取る
        boolean result = fruitDao.save(fruit);

        // 実行結果の表示
        if (result) {
            System.out.println("登録しました。");
        } else {
            System.out.println("登録に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }

    // フルーツの情報を更新するメソッド(実行結果を表示する)
    public void update(int id, int price) {
        System.out.println("------------------------------------------------------");
        System.out.println("【更新】");

        // Fruitオブジェクトを作成、ID, Priceをセットする
        Fruit fruit = new Fruit();
        fruit.setId(id);
        fruit.setPrice(price);

        // オブジェクトの情報で更新、実行結果を受け取る
        boolean result = fruitDao.update(fruit);

        // 実行結果の表示
        if (result) {
            System.out.println("更新しました。");
        } else {
            System.out.println("更新に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }

    // フルーツの情報を削除するメソッド(実行結果を表示する)
    public void delete(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【削除】");

        // ID情報で削除、実行結果を受け取る
        boolean result = fruitDao.delete(id);

        // 実行結果の表示
        if (result) {
            System.out.println("削除しました。");
        } else {
            System.out.println("削除に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }
    
    // フルーツの報を論理削除するメソッド(実行結果を表示する)
    public void logical(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【論理削除】");

        // ID情報で削除、実行結果を受け取る
        boolean result = fruitDao.delete(id);

        // 実行結果の表示
        if (result) {
            System.out.println("論理削除しました。");
        } else {
            System.out.println("論理削除に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }
}
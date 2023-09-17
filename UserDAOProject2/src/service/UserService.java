package service;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.User;

public class UserService {
    // UserDaoオブジェクトを格納するフィールド
    private UserDao userDao;
    
    // UserDaoImplオブジェクトをインスタンス化し、UserDaoフィールドに格納するコンストラクタ
    public UserService() {
        this.userDao = new UserDaoImpl();
    }

    // すべてのユーザー情報を検索して、検索結果を表示するメソッド
    public void findAll() {
        System.out.println("------------------------------------------------------");
        System.out.println("【全件検索】");

        // すべてのユーザー情報を検索して、結果をUserオブジェクト型のリストへ格納
        List<User> users = userDao.findAll();
        // 検索結果を1件ずつ表示
        for (User user : users) {
            System.out.print("ID: " + user.getId() + ", ");
            System.out.print("名前: " + user.getName() + "さん, ");
            System.out.println("年齢: " + user.getAge() + "歳");
            System.out.println("性別: " + user.getGender());
        }
        System.out.println("------------------------------------------------------");
    }

    // IDに合致するユーザー情報を検索して、検索結果を表示するメソッド
    public void findById(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【ID検索】");

        // IDに合致するユーザー情報を検索して、結果をStudentオブジェクト型へ格納
        User user = userDao.findById(id);
        // 検索結果を表示
        System.out.print("ID: " + user.getId() + ", ");
        System.out.print("名前: " + user.getName() + "さん, ");
        System.out.println("点数: " + user.getAge() + "歳");
        System.out.println("性別: " + user.getGender());
        System.out.println("------------------------------------------------------");
    }

    // ユーザー情報を登録するメソッド(実行結果を表示する)
    public void save(int id, String name, int age, int gender) {
        System.out.println("------------------------------------------------------");
        System.out.println("【新規登録】");

        // Studentオブジェクトを作成、ID, Name, Scoreをセットする
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);

        // オブジェクトの情報を保存、実行結果を受け取る
        boolean result = userDao.save(user);

        // 実行結果の表示
        if (result) {
            System.out.println("登録しました。");
        } else {
            System.out.println("登録に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }

    // ユーザー情報を更新するメソッド(実行結果を表示する)
    public void update(int id, int age) {
        System.out.println("------------------------------------------------------");
        System.out.println("【更新】");

        // Userオブジェクトを作成、ID, Ageをセットする
        User user = new User();
        user.setId(id);
        user.setAge(age);

        // オブジェクトの情報で更新、実行結果を受け取る
        boolean result = userDao.update(user);

        // 実行結果の表示
        if (result) {
            System.out.println("更新しました。");
        } else {
            System.out.println("更新に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }

    // ユーザー情報を削除するメソッド(実行結果を表示する)
    public void delete(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【削除】");

        // ID情報で削除、実行結果を受け取る
        boolean result = userDao.delete(id);

        // 実行結果の表示
        if (result) {
            System.out.println("削除しました。");
        } else {
            System.out.println("削除に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }
    
    // ユーザー情報を削除するメソッド(実行結果を表示する)
    public void logical(int id) {
        System.out.println("------------------------------------------------------");
        System.out.println("【論理削除】");

        // ID情報で削除、実行結果を受け取る
        boolean result = userDao.delete(id);

        // 実行結果の表示
        if (result) {
            System.out.println("論理削除しました。");
        } else {
            System.out.println("論理削除に失敗しました。");
        }
        System.out.println("------------------------------------------------------");
    }
}
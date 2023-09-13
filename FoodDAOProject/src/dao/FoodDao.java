package dao;

import java.util.List;

import dto.Food;

// DAOインターフェイス
public interface FoodDao {
    // すべてのフードを検索するメソッド
    public List<Food> findAll();

    // IDを指定してフードを検索するメソッド
    public Food findById(int id);

    // フードの情報を保存するメソッド
    public boolean save(Food food);

    // フードの情報を更新するメソッド
    public boolean update(Food food);
    
    // IDを指定してフードを削除するメソッド
    public boolean delete(int id);
}
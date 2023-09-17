package dao;

import java.util.List;

import dto.Dessert;

// DAOインターフェイス
public interface DessertDao {
    // すべてのデザートを検索するメソッド
    public List<Dessert> findAll();

    // IDを指定してデザートを検索するメソッド
    public Dessert findById(int id);

    // デザートの情報を保存するメソッド
    public boolean save(Dessert dessert);

    // デザートの情報を更新するメソッド
    public boolean update(Dessert dessert);
    
    // IDを指定してデザートを削除するメソッド
    public boolean delete(int id);
    
    // IDを指定してデザートを論理削除するメソッド
    public boolean logical(int id);
}
package dao;

import java.util.List;

import dto.Drink;

// DAOインターフェイス
public interface DrinkDao {
    // すべてのドリンクを検索するメソッド
    public List<Drink> findAll();

    // IDを指定してドリンクを検索するメソッド
    public Drink findById(int id);

    // ドリンクの情報を保存するメソッド
    public boolean save(Drink drink);

    // ドリンクの情報を更新するメソッド
    public boolean update(Drink drink);
    
    // IDを指定してドリンクを削除するメソッド
    public boolean delete(int id);
    
    // IDを指定してドリンクを論理削除するメソッド
    public boolean logical(int id);
}
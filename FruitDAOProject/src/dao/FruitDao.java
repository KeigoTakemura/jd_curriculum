package dao;

import java.util.List;

import dto.Fruit;

// DAOインターフェイス
public interface FruitDao {
    // すべてのフルーツを検索するメソッド
    public List<Fruit> findAll();

    // IDを指定してフルーツを検索するメソッド
    public Fruit findById(int id);

    // フルーツ情報を保存するメソッド
    public boolean save(Fruit fruit);

    // フルーツ情報を更新するメソッド
    public boolean update(Fruit fruit);
    
    // IDを指定してフルーツを削除するメソッド
    public boolean delete(int id);
}
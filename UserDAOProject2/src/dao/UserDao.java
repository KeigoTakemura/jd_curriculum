package dao;

import java.util.List;

import dto.User;

// DAOインターフェイス
public interface UserDao {
    // すべての学生を検索するメソッド
    public List<User> findAll();

    // IDを指定してユーザーを検索するメソッド
    public User findById(int id);

    // ユーザー情報を保存するメソッド
    public boolean save(User user);

    // ユーザー情報を更新するメソッド
    public boolean update(User user);
    
    // IDを指定してユーザーを削除するメソッド
    public boolean delete(int id);
    
    
    // IDを指定してユーザーを論理削除するメソッド
    public boolean logical(int id);
}
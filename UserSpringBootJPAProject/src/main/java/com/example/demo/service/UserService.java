package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.AllArgsConstructor;

// Lombokの使用(すべてのフィールドを引数に持つコンストラクタを自動生成する)
@AllArgsConstructor
// サービスロジックであることを示す
@Service
public class UserService {

    // UserRepository クラスのインスタンス
    private final UserRepository userRepository;

    // 全件検索して得られたUserオブジェクトをリスト形式で返すメソッド
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // ID によってuserオブジェクトを検索するメソッド
    public User findById(int id) {
        return userRepository.findById(id).get();
    }
   
    // Userオブジェクトを保存するメソッド
    public void save(User user) {
        userRepository.saveAndFlush(user);
    }

    // Userオブジェクトを更新するメソッド
    public void update(User user) {
        userRepository.saveAndFlush(user);
    }

    // ID によってUserオブジェクトを削除するメソッド
    public void delete(int id) {
        userRepository.deleteById(id);
    }
    
    // ID によってStudentオブジェクトを論理削除するメソッド
//    public void logicalDelete(int id) {
//        studentRepository.logicalDeleteById(id);
//    }
}
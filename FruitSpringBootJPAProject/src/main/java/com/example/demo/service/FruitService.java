package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Fruit;
import com.example.demo.repository.FruitRepository;

import lombok.AllArgsConstructor;

// Lombokの使用(すべてのフィールドを引数に持つコンストラクタを自動生成する)
@AllArgsConstructor
// サービスロジックであることを示す
@Service
public class FruitService {

    // FruitRepository クラスのインスタンス
    private final FruitRepository fruitRepository;

    // 全件検索して得られたFruitオブジェクトをリスト形式で返すメソッド
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    // ID によってfruitオブジェクトを検索するメソッド
    public Fruit findById(int id) {
        return fruitRepository.findById(id).get();
    }
   
    // Fruitオブジェクトを保存するメソッド
    public void save(Fruit fruit) {
        fruitRepository.saveAndFlush(fruit);
    }

    // Fruitオブジェクトを更新するメソッド
    public void update(Fruit fruit) {
        fruitRepository.saveAndFlush(fruit);
    }

    // ID によってFruitオブジェクトを削除するメソッド
    public void delete(int id) {
        fruitRepository.deleteById(id);
    }
    
    // ID によってStudentオブジェクトを論理削除するメソッド
//    public void logicalDelete(int id) {
//        studentRepository.logicalDeleteById(id);
//    }
}
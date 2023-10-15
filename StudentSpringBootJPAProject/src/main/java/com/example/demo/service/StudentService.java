package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import lombok.AllArgsConstructor;

// Lombokの使用(すべてのフィールドを引数に持つコンストラクタを自動生成する)
@AllArgsConstructor
// サービスロジックであることを示す
@Service
public class StudentService {

    // StudentRepository クラスのインスタンス
    private final StudentRepository studentRepository;

    // 全件検索して得られたStudentオブジェクトをリスト形式で返すメソッド
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // ID によってStudentオブジェクトを検索するメソッド
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }
   
    // Studentオブジェクトを保存するメソッド
    public void save(Student student) {
        studentRepository.saveAndFlush(student);
    }

    // Studentオブジェクトを更新するメソッド
    public void update(Student student) {
        studentRepository.saveAndFlush(student);
    }

    // ID によってStudentオブジェクトを削除するメソッド
    public void delete(int id) {
        studentRepository.deleteById(id);
    }
    
    // ID によってStudentオブジェクトを論理削除するメソッド
//    public void logicalDelete(int id) {
//        studentRepository.logicalDeleteById(id);
//    }
}
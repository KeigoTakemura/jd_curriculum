package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

// リポジトリであることを示す
@Repository
// JpaRepositoryを継承する
// <Student, Integer> の部分は、管理するエンティティクラスとその主キーの型を指定するものです
public interface StudentRepository extends JpaRepository<Student, Integer>{

//	void logicalDeleteById(int id);

}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Fruit;

// リポジトリであることを示す
@Repository
// JpaRepositoryを継承する
// <User, Integer> の部分は、管理するエンティティクラスとその主キーの型を指定するものです
public interface FruitRepository extends JpaRepository<Fruit, Integer>{


}

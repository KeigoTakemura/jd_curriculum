package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

// エンティティであることを示す
@Entity
// Lombokの使用(getter/setter/toString自動生成)
@Data
// OracleDBの「sampledb」データベースの「dessert」テーブルに対応
@Table(name="dessert")
public class Dessert {
    // 主キー(primary key)
    @Id
    // 自動採番
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dessert_id_seq")
    @SequenceGenerator(name = "dessert_id_seq", sequenceName = "dessert_id_seq", allocationSize = 1)

    //「dessert」テーブルの「id」カラムに対応
    @Column(name="id")
    private Integer id;
    
    //「dessert」テーブルの「name」カラムに対応
    @Column(name="name")
    private String name;
    
    //「dessert」テーブルの「price」カラムに対応
    @Column(name="price")
    private Integer price;
    
  //「dessert」テーブルの「time」カラムに対応
    @Column(name="time")
    private Integer time;
}
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
// OracleDBの「sampledb」データベースの「food」テーブルに対応
@Table(name="food")
public class Food {
    // 主キー(primary key)
    @Id
    // 自動採番
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_id_seq")
    @SequenceGenerator(name = "food_id_seq", sequenceName = "food_id_seq", allocationSize = 1)

    //「food」テーブルの「id」カラムに対応
    @Column(name="id")
    private Integer id;
    
    //「food」テーブルの「name」カラムに対応
    @Column(name="name")
    private String name;
    
    //「food」テーブルの「price」カラムに対応
    @Column(name="price")
    private Integer price;
    
  //「food」テーブルの「time」カラムに対応
    @Column(name="time")
    private Integer time;
}
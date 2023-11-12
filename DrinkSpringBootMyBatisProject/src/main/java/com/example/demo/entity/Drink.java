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
// OracleDBの「sampledb」データベースの「drink」テーブルに対応
@Table(name="drink")
public class Drink {
    // 主キー(primary key)
    @Id
    // 自動採番
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drink_id_seq")
    @SequenceGenerator(name = "drink_id_seq", sequenceName = "drink_id_seq", allocationSize = 1)

    //「drink」テーブルの「id」カラムに対応
    @Column(name="id")
    private Integer id;
    
    //「drink」テーブルの「name」カラムに対応
    @Column(name="name")
    private String name;
    
    //「drink」テーブルの「price」カラムに対応
    @Column(name="price")
    private Integer price;
    
  //「drink」テーブルの「time」カラムに対応
    @Column(name="time")
    private Integer time;
}
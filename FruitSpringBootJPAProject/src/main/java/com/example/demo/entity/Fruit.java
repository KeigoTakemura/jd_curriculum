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
// OracleDBの「sampledb」データベースの「fruit」テーブルに対応
@Table(name="fruit")
public class Fruit {
    // 主キー(primary key)
    @Id
    // 自動採番
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruit_id_seq")
    @SequenceGenerator(name = "fruit_id_seq", sequenceName = "fruit_id_seq", allocationSize = 1)

    //「fruit」テーブルの「id」カラムに対応
    @Column(name="id")
    private Integer id;
    
    //「fruit」テーブルの「name」カラムに対応
    @Column(name="name")
    private String name;
    
    //「fruit」テーブルの「price」カラムに対応
    @Column(name="price")
    private Integer price;
    
    //「fruit」テーブルの「prefecture_id」カラムに対応
    @Column(name="prefecture_id")
    private Integer prefecture_id;
    
    //「fruit」テーブルの「prefecture_id」カラムに対応
    @Column(name="season_id")
    private Integer season_id;
}
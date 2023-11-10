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
// OracleDBの「sampledb」データベースの「user」テーブルに対応
@Table(name="users")
public class User {
    // 主キー(primary key)
    @Id
    // 自動採番
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)

    //「user」テーブルの「id」カラムに対応
    @Column(name="id")
    private Integer id;
    
    //「user」テーブルの「name」カラムに対応
    @Column(name="name")
    private String name;
    
    //「user」テーブルの「age」カラムに対応
    @Column(name="age")
    private Integer age;
    
  //「user」テーブルの「gender」カラムに対応
    @Column(name="gender")
    private Integer gender;
}
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MemoEntity;

// id - integer. datatype should be class, not primary type
public interface MemoRepository extends JpaRepository<MemoEntity,Integer> {

}

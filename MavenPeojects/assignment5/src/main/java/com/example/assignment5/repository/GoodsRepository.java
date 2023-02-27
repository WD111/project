package com.example.assignment5.repository;


import com.example.assignment5.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface GoodsRepository extends JpaRepository<Goods, Long> {
//    Goods getById(long id);
//    Goods deleteById(long id);
//
//    @Query("select a from goods a where a.name = ?1")
//    Goods getByName(String name);


}

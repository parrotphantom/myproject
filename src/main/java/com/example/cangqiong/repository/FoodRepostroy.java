package com.example.cangqiong.repository;

import com.example.cangqiong.entity.Food;
import com.example.cangqiong.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface FoodRepostroy extends JpaRepository<Food,Long> {
    long count(); //所有的用户
}

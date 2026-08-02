package com.example.cangqiong.repository;

import com.example.cangqiong.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepositroy extends JpaRepository<Shop,Long> {
    long count();

    Shop findByPhonenumber(String phonenumber);
}

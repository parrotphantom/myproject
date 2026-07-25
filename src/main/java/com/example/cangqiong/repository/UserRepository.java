package com.example.cangqiong.repository;

import com.example.cangqiong.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailOrUsername(String stt0,String stt1);
}

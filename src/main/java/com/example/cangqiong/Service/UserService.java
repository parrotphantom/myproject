package com.example.cangqiong.Service;

import com.example.cangqiong.entity.User;
import com.example.cangqiong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User findUserbynameandemail(User user){
        return userRepository.findByEmailOrUsername(user.getEmail(),user.getUsername());
    }
    public boolean findUser(User user){
        if ( findUserbynameandemail(user)== null){
             return false;
        }else {
            return true;
        }
    }
}

package com.example.cangqiong.Service;

import com.example.cangqiong.repository.FoodRepostroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService  {
    @Autowired
    private FoodRepostroy foodRepostroy;
    public long foodUnmber(){return foodRepostroy.count();}


}

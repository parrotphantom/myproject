package com.example.cangqiong.Control;

import com.example.cangqiong.repository.FoodRepostroy;
import com.example.cangqiong.uitity.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class   login_shop {
    @Autowired
    private FoodRepostroy foodRepostroy;
    private Check check;
    @GetMapping("/loginshop")
    public String loginshop(){return "login_shop";}//未创建}
    @PostMapping("/loginshop")
    public  String loginshop1(
            @RequestParam String idshop,
            @RequestParam String password,
            Model model){
        //check.validate(idemployee,check::check_id,"idemployee","");
        return "yes";
        }


}

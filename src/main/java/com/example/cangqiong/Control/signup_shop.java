package com.example.cangqiong.Control;

import com.example.cangqiong.Service.ShopService;
import com.example.cangqiong.entity.Shop;
import com.example.cangqiong.uitity.Check;
import jdk.internal.classfile.impl.BufferedCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@Repository("/api")
public class signup_shop {
    @Autowired
    private Check check;
    private ShopService shopService;
    @GetMapping("/signup_shop")
    public String signupShop(){return "signup_shop";}
    @PostMapping("/signup_shop")
    public String signupShop1(
            @RequestParam String phonenumber,
            @RequestParam String shopName,
            @RequestParam String password,
            Model model
    ){
        Map<String,String> map = new HashMap<>();
        check.validate(phonenumber,check::check_phone,"phone","手机号格式错误",map);
        check.validate(shopName,check::checkName,"name","店铺名格式",map);
        check.validate(phonenumber,check::check_password,"password","密码格式错误",map);
        if (!map.isEmpty()){
            model.addAllAttributes(map);
            return "lognup";
        }
        Shop shop = new Shop(0,shopName,1,phonenumber,password);


        return "yes";
    }
}

package com.example.cangqiong.Control;

import com.example.cangqiong.Service.EmpolyeeService;
import com.example.cangqiong.entity.Employee;
import com.example.cangqiong.uitity.Check;
import jdk.internal.classfile.impl.BufferedCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class siginup_employee {
    @Autowired
    private Check check;
    private EmpolyeeService empolyeeService;

    @GetMapping("/signup_employee")
    public String siginupemployee(){
        return "signpu_employee";
    }

    @PostMapping("/signup_employee")
    public String siginupemployee1(
            @RequestParam String idemployee,
            @RequestParam String password,
            Model model
            ) {
        Employee emp = new Employee(idemployee,null,null,password);
        Map<String,String> mapemployee = new HashMap<>();
        check.validate(idemployee,check::check_id,"id","员工工号格式错误",mapemployee);
        check.validate(password,check::check_password,"password","密码错误",mapemployee);
        if (!mapemployee.isEmpty()){
            model.addAllAttributes(mapemployee);
            return "signup_employee";
        }
        Employee emp1 = empolyeeService.findEmployee(emp);
        if ( emp1==null){
            model.addAttribute("errors","未注册");
            return  "signup_employee";
        }
        if (!emp.getPassword().equals(emp1.getPassword())){
            model.addAttribute("password1","账号或密码错误");
        }
        return  "yes";
    }
}

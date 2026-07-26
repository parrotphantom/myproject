package com.example.cangqiong.Control;

import com.example.cangqiong.Service.EmpolyeeService;
import jdk.internal.classfile.impl.BufferedCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class login_employee {
    @Autowired EmpolyeeService empolyeeService;
    @GetMapping("/login_employee")
    public String loginemployee(){return "login_employee";}
    @PostMapping("/login_employee")
    public String loginemployee1(
            @RequestParam String employee_name,
            @RequestParam String employee_id,
            Model model
    ){

        return "login_em";
    }
}

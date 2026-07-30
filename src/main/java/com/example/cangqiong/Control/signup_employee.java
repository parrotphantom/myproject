package com.example.cangqiong.Control;

import com.example.cangqiong.Service.EmpolyeeService;
import com.example.cangqiong.entity.Employee;
import com.example.cangqiong.uitity.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class signup_employee {
    @Autowired
    private EmpolyeeService empolyeeService;
    private Check check;
    @GetMapping("/login_employee")
    public String loginemployee(){return "login_employee";}
    @PostMapping("/login_employee")
    public String loginemployee1(
            @RequestParam String idnumber,
            @RequestParam String employeename,
            @RequestParam String employee_password,
            Model model
    ){
        Employee employee1 = new Employee(null,idnumber,employeename,employee_password);
        Map<String,String> map = new HashMap<>();
        check.validate(employeename,check::checkName,"employeename","用户名格式错误",map);
        check.validate(idnumber,check::check_idnumber,"employeecheckid","身份证格式错误",map);
        check.validate(employee_password,check::check_password,"employeecheckpassword","用户密码格式错误",map);
        if (!map.isEmpty()) {
            model.addAllAttributes(map);
            return "login_employee";
        }
        if (empolyeeService.findEmployeeByidumber(employee1) != null){
            model.addAttribute("idnumber","用户已注册");
            return "login_employee";
        }
        int year = Year.now().getValue();
        String idnumber1 = String.valueOf(year + empolyeeService.getcount());
        employee1.setidemployee(idnumber1);
        empolyeeService.saveEmployee(employee1);
        return "login_employee";
    }
}

package com.example.cangqiong.Control;

import com.example.cangqiong.Service.EmpolyeeService;
import com.example.cangqiong.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/data")
public class PullAllEmployee {
    @Autowired
    public EmpolyeeService empolyeeService;
    @GetMapping("/dianpu")
    //public String getm(){return "dianpu";}
    //@PostMapping("/dianpu")
    public String Pullname(Model model){
        List<Employee>  listemloyee = empolyeeService.pullAllEmployee();
        model.addAttribute("allemployee",listemloyee);
        return "dianpu";
    }


}

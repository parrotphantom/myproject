package com.example.cangqiong.Control;

import com.example.cangqiong.Service.UserService;
import com.example.cangqiong.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class login {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String loginname(){return  "login";};
    @PostMapping("/login")
    public String login1(
            @RequestParam String username,
            @RequestParam String password,
            Model model,
            HttpServletResponse response
    ) throws IOException {
        User user = new User(username, username, password);

        if(userService.findUserbynameandemail(user) != null 
            && userService.findUserbynameandemail(user).getPassword().equals(user.getPassword()) ){
            return pullText(response,"密码正确");

        }
        return pullText(response,"账号或密码错误");
    }
    private String pullText(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write(message);
        response.getWriter().flush();
        return null;

    }

}

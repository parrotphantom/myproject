package com.example.cangqiong.Control;
import com.example.cangqiong.Service.UserService;
import com.example.cangqiong.entity.User;
import com.example.cangqiong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class signup {
    @Autowired
    private UserService userService;
    @GetMapping("/signup")
    public String signupname(){return "signup";};
    @PostMapping("/signup")
    public String signupname1(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            Model model,
            HttpServletResponse response
    ) throws IOException {
        if (username == null || username.length() < 2 || username.length() > 20) {
            return pullText(response,"用户名长度需在2~20位");
        }
        // 邮箱：简单判断是否包含 @ 和 .
        if (email == null || !email.contains("@") || !email.contains(".")) {
            return pullText(response,"邮箱格式错误");
        }
        // 密码：6~30位
        if (password == null || password.length() < 6 || password.length() > 30) {
            return pullText(response,"密码长度需在6~30位");
        }
        User user = new User(username, email, password);
        if (userService.findUser(user)){
            return pullText(response,"该账户已注册");
        }
        userService.saveUser(user);
        return pullText(response,"注册成功");

    }
    private String pullText(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/plain;charset:UTF-8");
        response.getWriter().write(message);
        response.getWriter().flush();
        return null;

    }
}

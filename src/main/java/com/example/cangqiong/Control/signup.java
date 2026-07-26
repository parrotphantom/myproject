package com.example.cangqiong.Control;
import com.example.cangqiong.Service.UserService;
import com.example.cangqiong.entity.User;
import com.example.cangqiong.repository.UserRepository;
import com.example.cangqiong.uitity.Check;
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
    private Check check;
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
        if (!check.check_name(username))model.addAttribute("usernameif","false");
        if (!check.check_email(email))model.addAttribute("emailif","false");
        if (!check.check_password(password))model.addAttribute("passwordif","false");

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

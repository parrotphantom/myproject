package com.example.cangqiong.Control;
import com.example.cangqiong.Service.UserService;
import com.example.cangqiong.entity.User;
import com.example.cangqiong.uitity.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class signup_user {
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
        Map<String,String> errors = check.allCheck_user(username,email,password);
        if (!errors.isEmpty()){
            model.addAttribute(errors);
            return "signup";
        }
        User user = new User(username, email, password);
        if (userService.findUser(user)){
            model.addAttribute("response","账户已注册");
            return "signup";
        }
        userService.saveUser(user);
            model.addAttribute("response","注册成功");
            return  "signup";

    }
    /*private String pullText(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/plain;charset:UTF-8");
        response.getWriter().write(message);
        response.getWriter().flush();
        return null;

    }*/
}

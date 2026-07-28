package com.example.cangqiong.uitity;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

@Component
public class Check {
    public boolean checkName(String name){
         return name !=null
                 && name.length() <= 10
                 && name.length() >=2;
    }
    public boolean check_email(String email){
        return email !=null && email.contains("@") && email.contains(".");

    }
    public boolean check_password(String password){
        String regex = "^[a-zA-Z0-9]+$";
        return password.matches(regex);
    }
    public  boolean check_id(String id){
         return id.length() == 15;
    }
    public  boolean check_empty(String value){
        return value != null && value.isEmpty();
    }
    /**
     * @param value 校检值
     * @param rule  校检函数
     * @param errorKey 错误的时候key
     * @param errorstr 错误信息
     * @param errors 错误手机器
     */
    public  void  validate(String value, Predicate<String> rule, String errorKey,String errorstr,Map<String,String>errors){
        if (!rule.test(value)){
            errors.put(errorKey,errorstr);
        }
    }
    public Map<String,String> allCheck_user(String name, String email, String password) {
        Map<String,String> errors = new HashMap<>();
        if (!this.checkName(name))  errors.put("nameif","用户名长度需在1~10位");
        if (!this.check_email(email))  errors.put("emailif","邮箱格式不正确，需包含@和.");
        if (!this.check_password(password)) errors.put("passwordif","密码只能包含字母和数字");
        return errors;
    }
    public Map<String,String> allCheck_employeer(String name, String id, String password) {
        Map<String,String> errors = new HashMap<>();
        if (!this.checkName(name))  errors.put("nameif","用户名长度需在1~10位");
        //if (!this.check_email(email))  errors.put("emailif","邮箱格式不正确，需包含@和.");
        if (!this.check_password(password)) errors.put("passwordif","密码只能包含字母和数字");
        if (!this.check_id(id)) errors.put("idif","身份证格式错误");

        return errors;
    }


}

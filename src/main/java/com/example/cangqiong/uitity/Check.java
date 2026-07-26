package com.example.cangqiong.uitity;

import org.springframework.stereotype.Component;

@Component
public class Check {
    public boolean check_name(String name){
        if ( name !=null && name.length() <= 10 && name.length() >=1){
            return true;
        }else  {
            return false;
        }
    }
    public boolean check_email(String email){
        if (email !=null && email.contains("@") && email.contains(".")){
            return true;
        }else {
            return false;
        }
    }
    public boolean check_password(String password){
        String regex = "^[a-zA-Z0-9]+$";
        return password.matches(regex);
    }
    public  boolean check_id(String id){
        if(id.length() == 15){
            return true;

        }else {
            return false;
        }
    }

}

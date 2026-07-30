package com.example.cangqiong.entity;

import javax.persistence.*;

@Entity
@Table(name ="t_user3",
        indexes = {
                @Index(name="username",columnList = "username"),
                @Index(name = "email",columnList = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false,length = 60,unique = true)
    private String username;
    @Column(nullable = false,length = 100,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    public User(){};
    public User(String username,
                String email,
                String password){
        this.email = email;
        this.password = password;
        this.username = username;
    }
    public String getPassword(){return this.password;}
    public String getUsername(){return this.username;}
    public String getEmail(){return this.email;}

}

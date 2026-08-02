package com.example.cangqiong.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_shop",
        indexes = {
        @Index(name = "ID_shop",columnList = "ID_shop"),
        @Index(name = "name_shop",columnList = "name_shop")
        }

)
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //店铺编号
    @Column(nullable = false )
    private long ID_shop;
    //店铺名称
    @Column(nullable = false ,length = 10)
    private String name_shop;
    //代表是否正在运营
    private Integer status;
    //注册手机号
    @Column(nullable = false,length = 11 )
    private String phonenumber;
    //密码
    @Column(nullable = false,length = 20)
    private String password;
    public Shop(){
        this.ID_shop =0;
        this.name_shop = null;
        this.status = 0;
        this.phonenumber =null;
        this.password = null;

    }
    public Shop(long ID_shop,
                String Name_shop,
                Integer status,
                String phonenumber,
                String password){
        this.ID_shop = ID_shop;
        this.name_shop = Name_shop;
        this.status = status;
        this.phonenumber = phonenumber;
        this.password = password;

    }

    public void setID_shop(long ID_shop) {
        this.ID_shop = ID_shop;
    }

    public String getPhonenumber(){return this.phonenumber;}
    public long getId(){return this.id;}
    public Integer getStatus(Integer status){return this.status; }
    public void setStatus(Integer status){this.status =status;}
    public long getID_shop(){return this.ID_shop;}
    public String getName_shop(){return  this.name_shop;}
}

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
    @Column(nullable = false ,length = 10)
    private String ID_shop;
    //店铺名称
    @Column(nullable = false ,length = 10)
    private String name_shop;
    public Shop(){
        this.ID_shop =null;
        this.name_shop = null;

    }
    public Shop(String ID_shop,
                String Name_shop){
        this.ID_shop = ID_shop;
        this.name_shop = Name_shop;
    }
    public long getId(){return this.id;}
    public String getID_shop(){return this.ID_shop;}
    public String getName_shop(){return  this.name_shop;}
}

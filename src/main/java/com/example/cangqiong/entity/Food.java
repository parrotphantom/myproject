package com.example.cangqiong.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_food",
       indexes = {
        @Index(name = "FoodName",columnList = "FoodName"),
        @Index(name = "price",columnList ="price" ),
        @Index(name = "status",columnList = "status")
       })
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false, length = 30)
    private String FoodName;
    //菜品单价 精确到分
    //最大9999999999.99
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    //代表是否上架
    @Column()
    private Integer status;

    public Food(){
        this.FoodName = null;
        this.price = BigDecimal.ZERO;
        this.status = 0;
    }
    public Food(String foodName,BigDecimal price,Integer status ){
        this.FoodName = foodName;
        this.price = price;
        this.status = status;
    }
    public Integer getStatus() {
        return status;
    }
    public String getFoodName() {
        return FoodName;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}



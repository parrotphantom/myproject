package com.example.cangqiong.entity;


import javax.persistence.*;

@Entity
@Table(name ="t_employee",
       indexes = {
        @Index(name="idnumber",columnList = "idnumber"),
        @Index(name = "employeename",columnList = "employeename"),
        @Index(name = "idemployee",columnList = "idemployee")
       })
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //员工工号
    @Column(nullable = false,length = 10)
    private String idemployee;
    //员工身份证
    @Column(nullable = false,length = 100)
    private String idnumber;
    //员工姓名
    @Column(nullable = false,length = 20)
    private   String employeename;
    public Employee(){
        this.idnumber =null;
        this.idemployee = null;
        this.employeename = null;
    };
    public Employee(String idemployee,
                    String idnumber,
                    String employeename){
        this.employeename = employeename;
        this.idemployee = idemployee;
        this.idnumber = idnumber;
    };
    public long getId(){return  this.id;}
    public String getIdemployee(){return this.idemployee;}
    public String getIdnumber(){return  this.idnumber;}
    public String getEmployeename(){return  this.employeename;}



}

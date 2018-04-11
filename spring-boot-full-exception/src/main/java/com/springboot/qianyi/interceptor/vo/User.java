package com.springboot.qianyi.interceptor.vo;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by qianyi on 2017/11/20.
 */
@Entity
@Table
public class User {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Long id;

    @NotNull(message = "名字不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value =16,message = "年龄范围必须大于16")
    @Max(value =150,message = "年龄范围必须小于150")
    private Integer age;



    @Email
    private  String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

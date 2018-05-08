package com.spring.annatation.vo;

/**
 * @description:
 * @author: cqqianyi@sina.cn
 * @create: 2018-05-01
 **/
public class Person {

    private String name;

    private  Integer age;

    private Integer high;

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

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }


    public Person(String name, Integer age, Integer high) {
        this.name = name;
        this.age = age;
        this.high = high;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

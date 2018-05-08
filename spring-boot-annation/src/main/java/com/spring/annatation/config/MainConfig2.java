package com.spring.annatation.config;

import com.spring.annatation.vo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: cqqianyi@sina.cn
 * @create: 2018-05-02
 **/
@Configuration
public class MainConfig2 {


    //给容器中注册一个Bean,类型为返回值的类型，Id默认用方法名称作为id
    @Bean("person1")
    public Person initPerson(){

        return  new Person("qianyi",26,180);
    }
}

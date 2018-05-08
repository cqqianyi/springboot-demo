package com.spring.annatation.config;

import com.spring.annatation.conditional.LinuxCondition;
import com.spring.annatation.conditional.WindowsCondition;
import com.spring.annatation.vo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: cqqianyi@sina.cn
 * @create: 2018-05-01
 **/
@Configuration
//告诉spring这是一个配置类
public class BeanConfig {

    //给容器中注册一个Bean,类型为返回值的类型，Id默认用方法名称作为id
    @Bean("person1")
    public Person initPerson() {

        return new Person("qianyi", 26, 180);
    }


    //给容器中注册一个Bean,类型为返回值的类型，Id默认用方法名称作为id
    @Bean("person2")
    public Person initPerson2() {
        return new Person("qianyi", 26, 180);
    }


    @Conditional(WindowsCondition.class)
    @Bean("person3")
    public Person person1() {
        return new Person("aaaa", 20);
    }

    @Conditional(LinuxCondition.class)
    @Bean("person3")
    public Person person2() {
        return new Person("bbb", 22);
    }
}

package com.spring.annatation.config;

import com.spring.annatation.vo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: cqqianyi@sina.cn
 * @create: 2018-05-01
 **/
@RestController
@RequestMapping(value = "test")
public class TestController {

    @RequestMapping(value = "annotation")
    public void testAnnotation(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(BeanConfig.class);
        Person person=applicationContext.getBean(Person.class);
        System.out.println(person);
        String [] beans=applicationContext.getBeanNamesForType(Person.class);

        for (String bean : beans) {
            System.out.println(bean);
        }



    }
}

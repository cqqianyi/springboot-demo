package com.springboot.qianyi.interceptor.controller;

import com.yunka.buluo.lottery.exception.BussinessException;
import com.springboot.qianyi.interceptor.vo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by qianyi on 2017/11/19.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "hello")
    public String hello(){
        return "Hello";
    }
    /**
     *
     * @return
     */
    @PostMapping(value = "user/add")
    public User addUser(@RequestBody @Valid  User user){
        if(user.getId()==null){
            throw new BussinessException(10,"错误");
        }
        System.out.println("用户为:"+user);
        return user;
    }





    /**
     * 只能写在Controller
     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public Map<String,Object> processValidationError(MethodArgumentNotValidException e) {
//        BindingResult result = e.getBindingResult();
//        List<ValidErrorResponseBody> errors = new ArrayList<>();
//        for (FieldError fieldError : result.getFieldErrors()) {
//            errors.add(new ValidErrorResponseBody(fieldError.getField(),fieldError.getDefaultMessage()));
//        }
//
//        Map map=new HashMap();
//        map.put("status","fail");
//        map.put("data",errors);
//        return map;
//    }
}

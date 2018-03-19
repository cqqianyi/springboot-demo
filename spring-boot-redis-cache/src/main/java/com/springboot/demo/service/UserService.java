package com.km.service;

import com.km.entity.User;

import java.util.List;

/**
 * @description:
 * @author: cqqianyi@sina.cn
 * @create: 2018-03-19
 **/

public interface UserService {

    List<User> list();

    User findUserById(Long id);

    User findInfoById(Long id);

    void update(User user);

    void remove(Long id);

}

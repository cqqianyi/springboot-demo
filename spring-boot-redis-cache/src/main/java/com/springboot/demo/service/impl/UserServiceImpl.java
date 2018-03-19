package com.km.service.impl;

import com.km.entity.Info;
import com.km.entity.User;
import com.km.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/9/21.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private Map<Long, User> userMap = new HashMap<>();
    private Map<Long, Info> infoMap = new HashMap<>();

    public UserServiceImpl() {
        userMap.put(1L, new User(1L, "aaa", "666666"));
        userMap.put(2L, new User(2L, "bbb", "666666"));
        userMap.put(3L, new User(3L, "ccc", "666666"));
        infoMap.put(1L, new Info("18559198715", "福州市"));
    }

    @Override
    public List list() {
        return Arrays.asList(userMap.values().toArray());
    }

    @Override
    @Cacheable(value = "user", key = "'user'.concat(#id.toString())")
    public User findUserById(Long id) {
        log.info("findUserById query from db, id: {}", id);
        return userMap.get(id);
    }

    @Override
    @Cacheable(value = "info", key = "'info'.concat(#id.toString())")
    public User findInfoById(Long id) {
        log.info("findInfoById query from db, id: {}", id);
        return userMap.get(id);
    }

    @Override
    @CachePut(value = "user", key = "'user'.concat(#user.id.toString())")
    public void update(User user) {
        log.info("update db, user: {}", user.toString());
        userMap.put(user.getId(), user);
    }

    @Override
    @CacheEvict(value = "user", key = "'user'.concat(#id.toString())")
    public void remove(Long id) {
        log.info("remove from db, id: {}", id);
        userMap.remove(id);
    }
}

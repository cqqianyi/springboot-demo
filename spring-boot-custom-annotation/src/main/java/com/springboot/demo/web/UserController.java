package com.springboot.demo.web;

import com.springboot.demo.annotation.PermissionOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "access")
public class UserController {

    /**
     * @param id
     * @return
     */
    @GetMapping("add")
    @PermissionOperation(code = "权限Code1", description = "添加用户")
    public int addUser(@RequestParam Integer id) {
        System.out.println("UserController add is running");
        return Integer.MAX_VALUE;
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping("del")
    @PermissionOperation(code = "权限Code2", description = "删除用户")
    public int delUser(@RequestParam Integer id) {
        System.out.println("UserController delete is running");
        return Integer.MAX_VALUE;
    }
}
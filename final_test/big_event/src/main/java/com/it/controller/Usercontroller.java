package com.it.controller;

import com.it.pojo.Result;
import com.it.pojo.User;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Usercontroller {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password){
        User u=userService.findByUserName(username);
        if(u==null){
            userService.register(username, password);
            return Result.success();
        }else{
            return Result.error("用户已被占用");
        }
    }

}

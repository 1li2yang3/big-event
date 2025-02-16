package com.it.service.impl;

import com.it.mapper.UserMapper;
import com.it.pojo.User;
import com.it.service.UserService;
import com.it.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        User u=userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
        String s=Md5Util.getMD5String(password);
        userMapper.add(username,s);
    }
}

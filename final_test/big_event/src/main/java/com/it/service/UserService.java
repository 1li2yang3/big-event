package com.it.service;

import com.it.pojo.User;

public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);
}

package org.wtm.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wtm.logistics.mapper.UserMapper;
import org.wtm.logistics.model.User;

@Service
public class LoginService {

    @Autowired
    UserMapper userMapper;

    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }
}

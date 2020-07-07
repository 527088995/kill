package com.debug.kill.server.service.impl;


import com.debug.kill.model.entity.User;
import com.debug.kill.model.mapper.UserMapper;
import com.debug.kill.server.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {
        User user1 = userMapper.selectByUserNamePsd(user.getUserName(), user.getPassword());
        if (user1 != null) {
            return true;
        } else {
            return false;
        }
    }
}

package com.turling.service;

import com.turling.dao.UserMapper;
import com.turling.entity.User;
import com.turling.entity.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Resource
    private UserMapper userMapper;

    @Override
    public User loginUser(User u) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(u.getUsername())
        .andPasswordEqualTo(u.getPassword());
        List<User> users = userMapper.selectByExample(userExample);
        if(users!=null && users.size()>0){
                return users.get(0);
        }else {
            return null;
        }
    }
}

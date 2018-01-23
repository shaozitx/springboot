package com.yhshao.springboot.service;

import com.yhshao.springboot.dao.UserDao;
import com.yhshao.springboot.entity.User;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shaoqi on 18/1/20.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;
    public User getUserById(Integer id) {
        return userDao.unique(id);
    }
    @Override
    public List<User> select(String name) {
        User paras = new User();
        paras.setName(name);
        return userDao.selectSample(paras);
    }
}

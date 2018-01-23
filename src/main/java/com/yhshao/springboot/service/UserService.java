package com.yhshao.springboot.service;

import com.yhshao.springboot.entity.User;

import java.util.List;

/**
 * Created by shaoqi on 18/1/20.
 */
public interface UserService {

    public User getUserById(Integer id);
    public List<User> select(String  name);}

package com.yhshao.springboot.entity;

import com.yhshao.springboot.anotation.WorkOverTime;

import javax.validation.constraints.NotNull;

/**
 * Created by shaoqi on 18/1/18.
 */
public class User {

    Integer id;
    @NotNull
    String name;
    @NotNull
    String password;
    @WorkOverTime
    Integer overworktime;


    public Integer getOverworktime() {
        return overworktime;
    }

    public void setOverworktime(Integer overworktime) {
        this.overworktime = overworktime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

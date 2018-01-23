package com.yhshao.springboot.entity;

import com.yhshao.springboot.anotation.WorkOverTime;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by shaoqi on 18/1/18.
 */
public class User {

    Integer id;
    @NotNull
    String name;

    Integer department_id;

    Date create_time;

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
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


}

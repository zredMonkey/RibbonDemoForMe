package com.userservice.demo.dto;

/**
 * @author: zhouhongzhan
 * @description:
 * @date: 2020/11/6 11:05
 **/
public class UserAddDTO {
    /**
     * 昵称
     */
    private String name;
    /**
     * 性别
     */
    private Integer gender;

    public String getName() {
        return name;
    }

    public UserAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UserAddDTO setGender(Integer gender) {
        this.gender = gender;
        return this;
    }
}

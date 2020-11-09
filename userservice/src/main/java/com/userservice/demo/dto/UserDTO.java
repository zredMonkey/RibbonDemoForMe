package com.userservice.demo.dto;

/**
 * @author: zhouhongzhan
 * @description:
 * @date: 2020/11/6 11:06
 **/
public class UserDTO {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 性别
     */
    private Integer gender;

    private Integer port;

    public Integer getPort() {
        return port;
    }

    public UserDTO setPort(Integer port) {
        this.port = port;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public UserDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UserDTO setGender(Integer gender) {
        this.gender = gender;
        return this;
    }
}

package com.userservice.demo.controller;

import com.userservice.demo.dto.UserAddDTO;
import com.userservice.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/get")
    public UserDTO get(@RequestParam("id") Integer id) {
        System.out.println("===== port =======" + serverPort + "被调用了！！！");
        return new UserDTO().setId(id)
                .setName("没有昵称：" + id)
                .setGender(id % 2 + 1).setPort(serverPort); // 1 - 男；2 - 女
    }

    @PostMapping("/add")
    public Integer add(UserAddDTO addDTO) {
        return (int) (System.currentTimeMillis() / 1000); // 嘿嘿，随便返回一个 id
    }

}
package com.springstudy.mybatisdemo.restcontroller;

import com.springstudy.mybatisdemo.mapper.UserMapper;
import com.springstudy.mybatisdemo.module.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private UserMapper userMapper;

    public UserRestController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/all")
    public List<User> show(){
        return userMapper.showAll();
    }
/*    @GetMapping("/customshow")
    public HashMap<String, String> customShow(){
        return userMapper.customShow();
    }*/

    @GetMapping("/add")
    private List<User> addUser(){
        User user = new User();
        user.setName("Mersedes");
        user.setSales(100);

        userMapper.insert(user);

        return userMapper.showAll();
    }

    @GetMapping("/update")
    private List<User> updateUser(){
        User user = new User();
        user.setId(2);
        user.setName("Tesla");
        user.setSales(43);

        userMapper.update(user);

        return userMapper.showAll();
    }
    @GetMapping("/delete")
    private List<User> deleteUser(){
        int id = 5;

        userMapper.delete(id);

        return userMapper.showAll();
    }

    @GetMapping("/deleteLast")
    private List<User> deleteLastUser(){

        int id = userMapper.count();
        userMapper.delete(id);

        return userMapper.showAll();
    }
}

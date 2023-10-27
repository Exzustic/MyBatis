package com.springstudy.mybatisdemo.restcontroller;

import com.springstudy.mybatisdemo.mapper.UserMapper;
import com.springstudy.mybatisdemo.module.CustomTable;
import com.springstudy.mybatisdemo.module.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class UserRestController {

    private UserMapper userMapper;

    public UserRestController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/users")
    public List<User> showUser(){
        return userMapper.showUsers();
    }

    @GetMapping("/users/{id}")
    public User showUserById(@PathVariable("id") int id){
        User user = userMapper.showUserById(id);
        return user;
    }

    @GetMapping("/users/customshow")
    public List<CustomTable> customShow(){
        return userMapper.customShow();
    }

    @PostMapping("/users")
    private List<User> addUser(@RequestBody User user){

        userMapper.insert(user);

        return userMapper.showUsers();
    }

    @PutMapping("/users")
    private List<User> updateUser(@RequestBody User user){

        userMapper.update(user);

        return userMapper.showUsers();
    }
    @DeleteMapping("/users/{id}")
    private List<User> deleteUser(@PathVariable("id") int id){

        userMapper.delete(id);
        return userMapper.showUsers();
    }

    @DeleteMapping("/users/deleteLast")
    private List<User> deleteLastUser(){

        int id = userMapper.count();
        userMapper.delete(id);

        return userMapper.showUsers();
    }
}

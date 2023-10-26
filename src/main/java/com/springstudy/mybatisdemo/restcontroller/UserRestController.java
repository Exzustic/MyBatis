package com.springstudy.mybatisdemo.restcontroller;

import com.springstudy.mybatisdemo.mapper.UserMapper;
import com.springstudy.mybatisdemo.module.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<List<String>> customShow(){
        return userMapper.show();
    }

    @GetMapping("/users/add")
    private List<User> addUser(){
        User user = new User();
        user.setName("Mersedes");
        user.setSales(100);

        userMapper.insert(user);

        return userMapper.showUsers();
    }

    @GetMapping("/users/update/{id}")
    private List<User> updateUser(@PathVariable("id") int id){
        User user = new User();
        user.setId(id);
        user.setName("Tesla");
        user.setSales(43);

        userMapper.update(user);

        return userMapper.showUsers();
    }
    @GetMapping("/users/delete/{id}")
    private List<User> deleteUser(@PathVariable("id") int id){

        userMapper.delete(id);
        return userMapper.showUsers();
    }

    @GetMapping("/users/deleteLast")
    private List<User> deleteLastUser(){

        int id = userMapper.count();
        userMapper.delete(id);

        return userMapper.showUsers();
    }
}

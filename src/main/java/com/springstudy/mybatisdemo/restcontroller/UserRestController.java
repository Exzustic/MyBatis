package com.springstudy.mybatisdemo.restcontroller;

import com.springstudy.mybatisdemo.mapper.UserMapper;
import com.springstudy.mybatisdemo.module.User;
import org.apache.ibatis.annotations.Update;
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

/*    @GetMapping("/users/customshow")
    public List<List<String>> customShow(){
        return userMapper.show();
    }*/

    @PostMapping("/users")
    private List<User> addUser(@RequestBody User user){
/*        User user = new User();
        user.setName("Mersedes");
        user.setSales(100);*/

        userMapper.insert(user);

        return userMapper.showUsers();
    }

    @PutMapping("/users")
    private List<User> updateUser(@RequestBody User user){ //
/*        User user = new User();
        user.setId(id);
        user.setName("Tesla");
        user.setSales(43);*/

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

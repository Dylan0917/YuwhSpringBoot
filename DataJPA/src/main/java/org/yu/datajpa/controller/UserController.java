package org.yu.datajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yu.datajpa.entity.User;
import org.yu.datajpa.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/1/29 14:30
 */
@Controller
@ResponseBody
public class UserController {

    UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        Optional<User> one = repository.findById(id);
        return one.get();
    }
    @GetMapping("/user")
    public User insertUser(User user){
        User save = repository.save(user);
        return save;
    }

}

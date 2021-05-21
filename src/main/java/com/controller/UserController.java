package com.controller;

import com.modle.User;
import com.service.UserService;
import com.service.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("mod")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody User user) {
            return userService.login(user);
    }

    @RequestMapping("/add")
    public Map<String,Object> add(@RequestBody User user) {
        return userService.add(user);
    }

}
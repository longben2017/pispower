package com.onecloud.controller;

import com.onecloud.model.User;
import com.onecloud.service.UserService;
import com.onecloud.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public String register(@RequestBody User user){
        log.info("user-service register request: {}",user);
        return userService.register(user);
    }

    @RequestMapping("/listUsers")
    public List<UserVo> listUsers(){
        return userService.listUsers();
    }
}

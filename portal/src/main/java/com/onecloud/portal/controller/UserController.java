package com.onecloud.portal.controller;

import com.onecloud.model.User;
import com.onecloud.portal.service.UserService;
import com.onecloud.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, @Valid User userVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }
        String userName = userVo.getUsername();
        String password = userVo.getPassword();

        if(!"admin".equals(userName)){
            modelAndView.addObject("error","无此用户！");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        if(!"123456".equals(password)){
            modelAndView.addObject("error","密码错误！");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        modelAndView.addObject("userName",userName);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/registerIndex")
    public ModelAndView registerIndex(ModelAndView modelAndView){
        log.info("-------------------------");
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping(value = "/regis")
    public String register(User user){
        log.info("-------------------------portal register request:{}",user);
        return userService.register(user);
    }

    @GetMapping(value = "/getUsers")
    public List<UserVo> listUsers(){
        return userService.listUsers();
    }
}

package com.onecloud.portal.service.hystrix;

import com.onecloud.model.User;
import com.onecloud.portal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class UserServiceHystrix implements UserService{

    @Override
    public String register(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","hystrix");
        modelAndView.setViewName("error");

        log.info("portal register failed");
        return "error";
    }

    @Override
    public List<User> listUsers() {
        log.info("listUsers error");
        return new ArrayList<User>();
    }
}

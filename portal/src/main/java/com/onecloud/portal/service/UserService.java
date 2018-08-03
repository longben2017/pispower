package com.onecloud.portal.service;

import com.onecloud.model.User;
import com.onecloud.portal.service.hystrix.UserServiceHystrix;
import com.onecloud.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user-service",fallback = UserServiceHystrix.class)
public interface UserService {

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    String register(User user);

    @RequestMapping(value = "/listUsers",method = RequestMethod.GET)
    List<UserVo> listUsers();
}

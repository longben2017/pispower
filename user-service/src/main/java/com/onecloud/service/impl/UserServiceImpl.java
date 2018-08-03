package com.onecloud.service.impl;

import com.onecloud.model.User;
import com.onecloud.repository.UserRepository;
import com.onecloud.service.UserService;
import com.onecloud.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${server.port}")
    String port;

    @Value("${version}")
    String version;

    @Override
    public String register(User user) {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        log.info("user register successed");

        userRepository.save(user);

        return "hello," + user.getUsername() + ". My port is " + port;
    }

    @Override
    public List<UserVo> listUsers() {
        log.info("this version is {}",version);

        return userRepository.findAll().stream().map(e -> {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(e,userVo);
            return userVo;
        }).collect(Collectors.toList());
    }
}

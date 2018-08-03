package com.onecloud.service;

import com.onecloud.model.User;
import com.onecloud.vo.UserVo;

import java.util.List;

public interface UserService {

    String register(User user);

    List<UserVo> listUsers();
}

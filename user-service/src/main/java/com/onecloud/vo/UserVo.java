package com.onecloud.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Data
public class UserVo {

    private Integer id;

    private String realname;

    private String username;

    private Long cellphone;

    private String email;

    private Date createTime;
}

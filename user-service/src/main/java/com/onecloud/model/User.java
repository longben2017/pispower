package com.onecloud.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Slf4j
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 用户名
     */
    @NotEmpty(message="用户名不能为空！")
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private Long cellphone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 创建时间
     */
    @Column(name = "create_time",columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date createTime;

}
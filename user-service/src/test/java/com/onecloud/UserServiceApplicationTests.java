package com.onecloud;

import com.onecloud.controller.UserController;
import com.onecloud.model.User;
import com.onecloud.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void getHello() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));
    }

    @Test
    public void findByRealName(){
        User user = userRepository.findByUsername("long");
        Assert.assertEquals("longgq",user.getRealname());
    }

    @Test
   // @Transactional
    public void testSave(){
        User user = new User();
        user.setUsername("long1");
        user.setPassword(DigestUtils.md5Hex("123456"));
        user.setRealname("longgq1");
        user.setCellphone(12345678910L);
        user.setEmail("mm@mail.com");
        User resultUser = userRepository.save(user);
        log.info("--------------"+resultUser);
    }

}

package com.complaints;

import com.complaints.mapper.UserMapper;
import com.complaints.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest

public class LoginControllerTests {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
    private MockHttpSession session;
    @Autowired
    private UserMapper userMapper;


    @Before
    public void setUpMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
        User user = new User();
        session.setAttribute("user",user);
    }

    @Test
    public void signUp(){
        User user =new User();
        user.setId(176);
        user.setLastName("Wiggins");
        user.setPassword("1234");
        user.setAdmin(0);
        userMapper.addUser(user);
    }
}

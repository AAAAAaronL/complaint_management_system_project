package com.complaints;

import com.complaints.controller.ComplaintsController;
import com.complaints.mapper.ComplaintsMapper;
import com.complaints.pojo.Complaints;
import com.complaints.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplaintsControllerTests {
    @Autowired
    private ComplaintsController complaintsController;
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    private MockHttpSession session;
    @Autowired
    ComplaintsMapper complaintsMapper;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(complaintsController).build();
        session = new MockHttpSession();
        User user = new User();
        session.setAttribute("user",user);

    }

    @Test
    public void addComplaints() {
        Complaints c = new Complaints(1080,"slow","Anna",1, "Andrews");

        complaintsMapper.addComplaints(c);
        System.out.println("ok");
    }
    @Test
    public void queryComplaintsList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/comps")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    @Rollback
    public void delete() throws Exception{
        int n = 1003;
        complaintsMapper.deleteComplaints(n);
        System.out.println("ok");
    }
    @Test
    public void update() throws Exception{
        Complaints c1 = complaintsMapper.queryComplaintsByNumber(1003);
        c1.setContent("fine");
        complaintsMapper.updateComplaints(c1);
    }

}

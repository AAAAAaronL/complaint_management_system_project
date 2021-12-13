package com.complaints;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class ComplaintsApplicationTests {
   @Autowired
    JavaMailSenderImpl javaMailSender;
   @Test
    void contextLoads() {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("Complaint status has been updated.");
        mailMessage.setText("Thanks for your complaint. Now the problem from your Complaint has been updated.");
        mailMessage.setTo("790214624@qq.com");
        mailMessage.setFrom("790214624@qq.com");
    }

}

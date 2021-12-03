package com.complaints.controller;


/*import com.complaints.Dao.ComplaintsDao;
import com.complaints.Dao.UserDao;*/
import com.complaints.mapper.ComplaintsMapper;
import com.complaints.mapper.UserMapper;
import com.complaints.pojo.Complaints;
import com.complaints.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class  ComplaintsController {

   /* @Autowired
    ComplaintsDao complaintsDao;
    @Autowired
    UserDao userDao;*/
    @Autowired
    ComplaintsMapper complaintsMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    JavaMailSenderImpl mailSender;

    @RequestMapping("/comps")

    public String list(Model model){
        Collection<Complaints> complaints1 = /*complaintsDao.getComplaints()*/ complaintsMapper.queryComplaintsList();
        model.addAttribute("complaints",complaints1);
        return "comp/list";
    }
    @GetMapping("/comp")
    public String toAddpage(Model model){
        //查出所有员工信息
        Collection<User> allusers = userMapper.queryUserList();//userDao.getUsers();
        model.addAttribute("allusers",allusers);
        return "comp/add";
    }
    @PostMapping("/comp")
    public String addComp(Complaints complaint){

       // complaintsDao.save(complaint);
        complaintsMapper.addComplaints(complaint);
       return "redirect:/comps";//返回投诉页
    }
    //去到投诉修改页面
    @GetMapping("comp/{number}")
    public String toUpdateComp(@PathVariable("number") Integer number,Model model){
        //查出原来数据
        Complaints complaintsById =  complaintsMapper.queryComplaintsByNumber(number);//complaintsDao.getComplaint(number);
        model.addAttribute("comp",complaintsById);
        return "comp/update";
    }
        @PostMapping("/updateComp")
    public String updateComp(Complaints complaint){
        //complaintsDao.save(complaint);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject("Complaint status has been updated.");
            mailMessage.setText("Thanks for your complaint. Now the problem from your Complaint has been updated.");
            mailMessage.setTo(complaint.getComplainant());
            mailMessage.setFrom("790214624@qq.com");
            complaintsMapper.updateComplaints(complaint);

        return "redirect:/comps";
    }
    //删除投诉
    @GetMapping("/deleteComp/{number}")
    public String deleteComp(@PathVariable("number")Integer number){
       // complaintsDao.delete(number);
        complaintsMapper.deleteComplaints(number);
        return "redirect:/comps";
    }

    @RequestMapping("/monitor")
    public String monitor(Model model){
        Collection<Complaints> complaints1 = /*complaintsDao.getComplaints()*/ complaintsMapper.queryComplaintsList();
        model.addAttribute("complaints",complaints1);
        return "comp/monitor";
    }
}

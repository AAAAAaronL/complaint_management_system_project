/*
package com.complaints.Dao;

import com.complaints.pojo.Complaints;
import com.complaints.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class ComplaintsDao {
    //模拟数据库中数据
    private static Map<Integer, Complaints> complaints = null;
    @Autowired
    private UserDao userDao;
    static {
        complaints = new HashMap<Integer, Complaints>();//创建一个投诉表
        complaints.put(1001, new Complaints(1001, "slow", "Jack",  "no","Harris"));
        complaints.put(1002, new Complaints(1002, "slow", "Rose", "no","Rose"));
        complaints.put(1003, new Complaints(1003, "slow", "Andrew", "no","Andrew"));
        complaints.put(1004, new Complaints(1004, "slow", "Loki",  "no","Loki"));
        complaints.put(1005, new Complaints(1005, "slow", "Leon", "no","Leon"));
    }
    //获得所有投诉信息
    public Collection<Complaints> getComplaints(){
        return complaints.values();
    }
    //通过id找到投诉
    public Complaints getComplaint(Integer number){
        return complaints.get(number);
    }
    //主键自增
    private static Integer initId = 1006;
    //增加一个投诉
    public void save(Complaints complaint){
        if (complaint.getNumber() == null){
            complaint.setNumber(initId++);
        }
       */
/* complaint.setUser(UserDao.getUserById(complaint.getUser().getId()));*//*


        complaints.put(complaint.getNumber(),complaint);
    }
    public void delete(Integer number){
        complaints.remove(number);
    }
}
*/

package com.complaints.mapper;


import com.complaints.pojo.Complaints;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ComplaintsMapper {
    List<Complaints> queryComplaintsList();
    Complaints queryComplaintsByNumber(int id);
    int addComplaints(Complaints complaints);
    int updateComplaints(Complaints complaints);
    int deleteComplaints(int id);
}

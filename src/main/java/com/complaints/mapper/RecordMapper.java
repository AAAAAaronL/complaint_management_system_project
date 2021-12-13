package com.complaints.mapper;


import com.complaints.pojo.Complaints;
import com.complaints.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecordMapper {
    List<Record> queryRecordList();
    int addRecord(Record record);
    int deleteRecords(int id);
}

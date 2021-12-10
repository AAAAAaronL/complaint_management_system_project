package com.complaints.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private Integer number;
    private String content;
    private String complainant;
    private int processStatus;
    private String user;
}

package com.complaints.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complaints {
    private Integer number;
    private String content;
    private String complainant;
    private String processStatus;
    private String user;
}

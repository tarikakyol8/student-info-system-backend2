package com.akyol.studentinfoapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDTO {

    private Long studentId;
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String email;
    private Long departmentId;
    private Date registrationDate;
}

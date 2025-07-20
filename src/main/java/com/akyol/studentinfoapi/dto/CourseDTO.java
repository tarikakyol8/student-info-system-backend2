package com.akyol.studentinfoapi.dto;

import com.akyol.studentinfoapi.model.CourseType;
import lombok.Data;

@Data
public class CourseDTO {

    private Long courseId;
    private String courseCode;
    private String courseName;
    private Integer credits;
    private Long departmentId;
    private CourseType courseType;
}

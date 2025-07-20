package com.akyol.studentinfoapi.dto;

import com.akyol.studentinfoapi.model.CourseStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentCourseRegistrationDTO {

    private Long registrationId;
    private Long studentId;
    private Long courseId;
    private Long semesterId;
    private BigDecimal grade;
    private CourseStatus status;
}

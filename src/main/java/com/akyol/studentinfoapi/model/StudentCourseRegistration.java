package com.akyol.studentinfoapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "studentcourseregistrations")
public class StudentCourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semester;

    private BigDecimal grade;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;
}

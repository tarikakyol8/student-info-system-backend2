package com.akyol.studentinfoapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(unique = true)
    private String courseCode;

    private String courseName;

    private Integer credits;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    @Enumerated(EnumType.STRING)
    private CourseType courseType;
}

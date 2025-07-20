package com.akyol.studentinfoapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String facultyName;

    private String departmentName;
}

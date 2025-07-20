package com.akyol.studentinfoapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String studentNumber;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    @Temporal(TemporalType.DATE)
    private Date registrationDate;
}

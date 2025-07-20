package com.akyol.studentinfoapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "semesters")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long semesterId;

    private Integer year;

    private String term;
}

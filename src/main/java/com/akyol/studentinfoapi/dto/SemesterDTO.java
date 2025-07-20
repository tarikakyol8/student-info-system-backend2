package com.akyol.studentinfoapi.dto;

import lombok.Data;

@Data
public class SemesterDTO {

    private Long semesterId;
    private Integer year;
    private String term;
}

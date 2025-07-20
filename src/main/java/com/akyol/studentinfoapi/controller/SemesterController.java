package com.akyol.studentinfoapi.controller;

import com.akyol.studentinfoapi.dto.SemesterDTO;
import com.akyol.studentinfoapi.service.SemesterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semesters")
public class SemesterController {

    private final SemesterService semesterService;

    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @PostMapping
    public SemesterDTO createSemester(@RequestBody SemesterDTO semesterDTO) {
        return semesterService.createSemester(semesterDTO);
    }

    @GetMapping("/{id}")
    public SemesterDTO getSemesterById(@PathVariable Long id) {
        return semesterService.getSemesterById(id);
    }

    @GetMapping
    public List<SemesterDTO> getAllSemesters() {
        return semesterService.getAllSemesters();
    }

    @PutMapping("/{id}")
    public SemesterDTO updateSemester(@PathVariable Long id, @RequestBody SemesterDTO semesterDTO) {
        return semesterService.updateSemester(id, semesterDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSemester(@PathVariable Long id) {
        semesterService.deleteSemester(id);
    }
}

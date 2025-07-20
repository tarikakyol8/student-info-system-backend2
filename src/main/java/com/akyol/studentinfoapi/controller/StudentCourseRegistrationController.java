package com.akyol.studentinfoapi.controller;

import com.akyol.studentinfoapi.dto.StudentCourseRegistrationDTO;
import com.akyol.studentinfoapi.service.StudentCourseRegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-course-registrations")
public class StudentCourseRegistrationController {

    private final StudentCourseRegistrationService studentCourseRegistrationService;

    public StudentCourseRegistrationController(StudentCourseRegistrationService studentCourseRegistrationService) {
        this.studentCourseRegistrationService = studentCourseRegistrationService;
    }

    @PostMapping
    public StudentCourseRegistrationDTO createStudentCourseRegistration(@RequestBody StudentCourseRegistrationDTO studentCourseRegistrationDTO) {
        return studentCourseRegistrationService.createStudentCourseRegistration(studentCourseRegistrationDTO);
    }

    @GetMapping("/{id}")
    public StudentCourseRegistrationDTO getStudentCourseRegistrationById(@PathVariable Long id) {
        return studentCourseRegistrationService.getStudentCourseRegistrationById(id);
    }

    @GetMapping
    public List<StudentCourseRegistrationDTO> getAllStudentCourseRegistrations() {
        return studentCourseRegistrationService.getAllStudentCourseRegistrations();
    }

    @PutMapping("/{id}")
    public StudentCourseRegistrationDTO updateStudentCourseRegistration(@PathVariable Long id, @RequestBody StudentCourseRegistrationDTO studentCourseRegistrationDTO) {
        return studentCourseRegistrationService.updateStudentCourseRegistration(id, studentCourseRegistrationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentCourseRegistration(@PathVariable Long id) {
        studentCourseRegistrationService.deleteStudentCourseRegistration(id);
    }
}

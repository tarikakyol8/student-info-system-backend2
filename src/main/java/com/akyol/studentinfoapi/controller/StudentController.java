package com.akyol.studentinfoapi.controller;

import com.akyol.studentinfoapi.dto.StudentDTO;
import com.akyol.studentinfoapi.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}

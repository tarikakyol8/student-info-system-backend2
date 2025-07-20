package com.akyol.studentinfoapi.controller;

import com.akyol.studentinfoapi.dto.CourseDTO;
import com.akyol.studentinfoapi.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        return courseService.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}

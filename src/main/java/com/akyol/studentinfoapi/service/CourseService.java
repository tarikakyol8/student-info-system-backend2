package com.akyol.studentinfoapi.service;

import com.akyol.studentinfoapi.dto.CourseDTO;
import com.akyol.studentinfoapi.model.Course;
import com.akyol.studentinfoapi.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public CourseService(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        course = courseRepository.save(course);
        return modelMapper.map(course, CourseDTO.class);
    }

    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        return modelMapper.map(course, CourseDTO.class);
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        modelMapper.map(courseDTO, course);
        course = courseRepository.save(course);
        return modelMapper.map(course, CourseDTO.class);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}

package com.akyol.studentinfoapi.service;

import com.akyol.studentinfoapi.dto.StudentDTO;
import com.akyol.studentinfoapi.model.Student;
import com.akyol.studentinfoapi.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return modelMapper.map(student, StudentDTO.class);
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        modelMapper.map(studentDTO, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

package com.akyol.studentinfoapi.service;

import com.akyol.studentinfoapi.dto.StudentCourseRegistrationDTO;
import com.akyol.studentinfoapi.model.StudentCourseRegistration;
import com.akyol.studentinfoapi.repository.StudentCourseRegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentCourseRegistrationService {

    private final StudentCourseRegistrationRepository studentCourseRegistrationRepository;
    private final ModelMapper modelMapper;

    public StudentCourseRegistrationService(StudentCourseRegistrationRepository studentCourseRegistrationRepository, ModelMapper modelMapper) {
        this.studentCourseRegistrationRepository = studentCourseRegistrationRepository;
        this.modelMapper = modelMapper;
    }

    public StudentCourseRegistrationDTO createStudentCourseRegistration(StudentCourseRegistrationDTO studentCourseRegistrationDTO) {
        StudentCourseRegistration studentCourseRegistration = modelMapper.map(studentCourseRegistrationDTO, StudentCourseRegistration.class);
        studentCourseRegistration = studentCourseRegistrationRepository.save(studentCourseRegistration);
        return modelMapper.map(studentCourseRegistration, StudentCourseRegistrationDTO.class);
    }

    public StudentCourseRegistrationDTO getStudentCourseRegistrationById(Long id) {
        StudentCourseRegistration studentCourseRegistration = studentCourseRegistrationRepository.findById(id).orElseThrow(() -> new RuntimeException("StudentCourseRegistration not found"));
        return modelMapper.map(studentCourseRegistration, StudentCourseRegistrationDTO.class);
    }

    public List<StudentCourseRegistrationDTO> getAllStudentCourseRegistrations() {
        return studentCourseRegistrationRepository.findAll().stream()
                .map(studentCourseRegistration -> modelMapper.map(studentCourseRegistration, StudentCourseRegistrationDTO.class))
                .collect(Collectors.toList());
    }

    public StudentCourseRegistrationDTO updateStudentCourseRegistration(Long id, StudentCourseRegistrationDTO studentCourseRegistrationDTO) {
        StudentCourseRegistration studentCourseRegistration = studentCourseRegistrationRepository.findById(id).orElseThrow(() -> new RuntimeException("StudentCourseRegistration not found"));
        modelMapper.map(studentCourseRegistrationDTO, studentCourseRegistration);
        studentCourseRegistration = studentCourseRegistrationRepository.save(studentCourseRegistration);
        return modelMapper.map(studentCourseRegistration, StudentCourseRegistrationDTO.class);
    }

    public void deleteStudentCourseRegistration(Long id) {
        studentCourseRegistrationRepository.deleteById(id);
    }
}

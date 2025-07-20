package com.akyol.studentinfoapi.service;

import com.akyol.studentinfoapi.dto.SemesterDTO;
import com.akyol.studentinfoapi.model.Semester;
import com.akyol.studentinfoapi.repository.SemesterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SemesterService {

    private final SemesterRepository semesterRepository;
    private final ModelMapper modelMapper;

    public SemesterService(SemesterRepository semesterRepository, ModelMapper modelMapper) {
        this.semesterRepository = semesterRepository;
        this.modelMapper = modelMapper;
    }

    public SemesterDTO createSemester(SemesterDTO semesterDTO) {
        Semester semester = modelMapper.map(semesterDTO, Semester.class);
        semester = semesterRepository.save(semester);
        return modelMapper.map(semester, SemesterDTO.class);
    }

    public SemesterDTO getSemesterById(Long id) {
        Semester semester = semesterRepository.findById(id).orElseThrow(() -> new RuntimeException("Semester not found"));
        return modelMapper.map(semester, SemesterDTO.class);
    }

    public List<SemesterDTO> getAllSemesters() {
        return semesterRepository.findAll().stream()
                .map(semester -> modelMapper.map(semester, SemesterDTO.class))
                .collect(Collectors.toList());
    }

    public SemesterDTO updateSemester(Long id, SemesterDTO semesterDTO) {
        Semester semester = semesterRepository.findById(id).orElseThrow(() -> new RuntimeException("Semester not found"));
        modelMapper.map(semesterDTO, semester);
        semester = semesterRepository.save(semester);
        return modelMapper.map(semester, SemesterDTO.class);
    }

    public void deleteSemester(Long id) {
        semesterRepository.deleteById(id);
    }
}

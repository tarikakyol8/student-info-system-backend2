package com.akyol.studentinfoapi.service;

import com.akyol.studentinfoapi.dto.DepartmentDTO;
import com.akyol.studentinfoapi.model.Department;
import com.akyol.studentinfoapi.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = modelMapper.map(departmentDTO, Department.class);
        department = departmentRepository.save(department);
        return modelMapper.map(department, DepartmentDTO.class);
    }

    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        return modelMapper.map(department, DepartmentDTO.class);
    }

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        modelMapper.map(departmentDTO, department);
        department = departmentRepository.save(department);
        return modelMapper.map(department, DepartmentDTO.class);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}

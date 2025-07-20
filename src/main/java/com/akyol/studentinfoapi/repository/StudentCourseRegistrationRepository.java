package com.akyol.studentinfoapi.repository;

import com.akyol.studentinfoapi.model.StudentCourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRegistrationRepository extends JpaRepository<StudentCourseRegistration, Long> {
}

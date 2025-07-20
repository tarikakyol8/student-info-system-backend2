package com.akyol.studentinfoapi.repository;

import com.akyol.studentinfoapi.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
}

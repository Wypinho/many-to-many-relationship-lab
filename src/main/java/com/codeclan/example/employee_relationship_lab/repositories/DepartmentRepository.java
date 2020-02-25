package com.codeclan.example.employee_relationship_lab.repositories;

import com.codeclan.example.employee_relationship_lab.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

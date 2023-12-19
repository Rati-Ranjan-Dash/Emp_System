package com.ldtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ldtech.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

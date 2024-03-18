package com.elkased.employeedirectory.dao;

import com.elkased.employeedirectory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findAllByOrderByLastNameAsc();

}

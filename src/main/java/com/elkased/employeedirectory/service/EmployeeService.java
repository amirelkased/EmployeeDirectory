package com.elkased.employeedirectory.service;

import com.elkased.employeedirectory.entity.Employee;

import java.util.List;


public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
}

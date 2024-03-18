package com.elkased.employeedirectory.service;

import com.elkased.employeedirectory.dao.EmployeeRepository;
import com.elkased.employeedirectory.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(Long id) {

        Optional<Employee> theEmployee = employeeRepository.findById(id);
        return theEmployee.orElse(null);
    }

    @Override
    public Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {

        employeeRepository.deleteById(id);
    }
}

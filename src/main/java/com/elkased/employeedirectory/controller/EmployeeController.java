package com.elkased.employeedirectory.controller;

import com.elkased.employeedirectory.entity.Employee;
import com.elkased.employeedirectory.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> listEmployees = employeeService.findAll();
        model.addAttribute("employees", listEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String processEmployee(@ModelAttribute(value = "employee") @Valid Employee employee, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getModel());
            return "employees/employee-form";
        }

        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") Long employeeId, ModelMap modelMap) {
        Employee employee = employeeService.findById(employeeId);
        modelMap.addAttribute("employee", employee);
        return "/employees/employee-form";
    }

    @GetMapping("/showFormForDelete")
    public String deleteEmployee(@RequestParam("employeeId") Long employeeId) {
        employeeService.deleteById(employeeId);

        return "redirect:/employees/list";
    }
}

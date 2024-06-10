package com.arias.company.controller;

import com.arias.company.dto.EmployeeDTO;
import com.arias.company.entity.Employee;
import com.arias.company.service.EmployeeSvc;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/api/employee")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeSvc employeeSvc;

    @GetMapping
    Iterable<Employee> list(){
        return employeeSvc.findAll();
    }

    @GetMapping("{id}")
    public Employee get(@PathVariable() Integer id){
        return employeeSvc.findById(id);
    }

    @PostMapping("/create")
    public Employee create(@Validated @RequestBody EmployeeDTO employeeDTO){
        return employeeSvc.create(employeeDTO);
    }

    @PutMapping("{id}")
    public Employee update(@PathVariable() Integer id,
                           @Validated @RequestBody EmployeeDTO employeeDTO){
        return employeeSvc.update(id, employeeDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable() Integer id){
        employeeSvc.delete(id);
    }

}

package com.arias.company.service;

import com.arias.company.dto.EmployeeDTO;
import com.arias.company.entity.Employee;
import com.arias.company.exception.ResourceNotFoundException;
import com.arias.company.repository.IEmployee;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class EmployeeSvc {

    private final IEmployee employeeRepo;
    private final ModelMapper mapper;

    public Iterable<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public Employee findById(Integer id){
        return employeeRepo.findById(id)
                .orElseThrow(ResourceNotFoundException::new);//Con el 'new' incluís el contructor
    }

    public Employee create(EmployeeDTO employeeDTO){
        Employee employee = mapper.map(employeeDTO, Employee.class);
        employee.setCreateAt(LocalDateTime.now());
        return employeeRepo.save(employee);
    }

    public Employee update(Integer id, EmployeeDTO employeeDTO){
        Employee employeeDb = findById(id);
        mapper.map(employeeDTO, employeeDb);
        return employeeRepo.save(employeeDb);
    }

    public void delete(Integer id){
        Employee employee = findById(id);
        employeeRepo.delete(employee);
    }
}

package com.arias.company.repository;

import com.arias.company.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployee extends CrudRepository<Employee, Integer> {
}

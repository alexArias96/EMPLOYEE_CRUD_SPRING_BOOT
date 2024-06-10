package com.arias.company;

import com.arias.company.entity.Employee;
import com.arias.company.repository.IEmployee;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(IEmployee employeeRepo){
		return args -> {
			List<Employee> employees = Arrays.asList(
					new Employee("Denis Arias", "78965478", "denis@gmail.com", LocalDateTime.now()),
					new Employee("Alexander Arias", "54621281", "alex@gmail.com", LocalDateTime.now()),
					new Employee("Andrea Muchín", "52136254", "andrea@gmail.com", LocalDateTime.now()),
					new Employee("Beatriz Chavez", "78784512", "beatriz@gmail.com", LocalDateTime.now())
			);
			employeeRepo.saveAll(employees);
		};
	};

	@Bean
	ModelMapper mapper(){
		return new ModelMapper();
	}
}

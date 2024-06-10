package com.arias.company.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class EmployeeDTO {
    @NotBlank(message = "The name is required")
    private String employeeName;
    @NotBlank(message = "The number contact is required")
    private String employeeContactNumber;

    @Email(message = "Email has an invalid format")
    @NotBlank(message = "The email address is required")
    private String employeeAddress;
}

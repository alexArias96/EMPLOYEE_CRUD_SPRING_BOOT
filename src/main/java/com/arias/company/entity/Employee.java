package com.arias.company.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;

    @NonNull
    private String employeeName;
    @NonNull
    private String employeeContactNumber;
    @NonNull
    private String employeeAddress;
    @NonNull
    private LocalDateTime createAt;
}

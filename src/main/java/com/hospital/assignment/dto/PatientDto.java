package com.hospital.assignment.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class PatientDto {
    private Long id;
    private String name;
    private Date birthDate;
    private String gender;
    private String phoneNumber;
}

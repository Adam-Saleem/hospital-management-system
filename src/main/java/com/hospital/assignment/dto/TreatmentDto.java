package com.hospital.assignment.dto;

import lombok.Data;

@Data
public class TreatmentDto {
    private Long id;
    private String name;
    private int price;
    private String description;
}

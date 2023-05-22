package com.hospital.assignment.dto;

import lombok.Data;
import java.sql.Date;

@Data
public class AppointmentDto {
    private Long id;
    private Long patient_id;
    private Long doctor_id;
    private Date appointment_date;
    private int payment;
}

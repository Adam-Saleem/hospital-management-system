package com.hospital.assignment.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long patient_id;
    @Column
    private Long doctor_id;
    @Column
    private Date appointment_date;
    @Column
    private int payment;
}

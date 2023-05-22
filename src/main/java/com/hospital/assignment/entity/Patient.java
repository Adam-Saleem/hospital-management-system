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
@Table(name = "patient")
public class Patient implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private Date birthDate;
    @Column
    private String gender;
    @Column
    private String phoneNumber;
}

package com.hospital.assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "treatment")

public class Treatment implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private int price;
    @Column
    private String description;
}

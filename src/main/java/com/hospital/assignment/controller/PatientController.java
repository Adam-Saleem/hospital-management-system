package com.hospital.assignment.controller;


import com.hospital.assignment.dto.PatientDto;
import com.hospital.assignment.exception.BadRequestException;
import com.hospital.assignment.service.PatientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final Logger log = LoggerFactory.getLogger(PatientController.class);

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getCategoryById(
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@Valid @RequestBody PatientDto patientDto) {
        if (patientDto.getId() == 0) {
            log.error("Cannot have an ID {}", patientDto);
            throw new BadRequestException(PatientController.class.getSimpleName(), "Id");
        }
        return new ResponseEntity<>(patientService.createPatient(patientDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updateCategory
            (@Valid @RequestBody PatientDto patientDto, @PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(patientService.updatePatient(patientDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") Long id) {
        patientService.deletePatientById(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}

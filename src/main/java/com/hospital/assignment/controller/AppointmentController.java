package com.hospital.assignment.controller;


import com.hospital.assignment.dto.AppointmentDto;
import com.hospital.assignment.exception.BadRequestException;
import com.hospital.assignment.service.AppointmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final Logger log = LoggerFactory.getLogger(AppointmentController.class);

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        return ResponseEntity.ok().body(appointmentService.getAllAppointments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getCategoryById(
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@Valid @RequestBody AppointmentDto appointmentDto) {
        if (appointmentDto.getId() == 0) {
            log.error("Cannot have an ID {}", appointmentDto);
            throw new BadRequestException(AppointmentController.class.getSimpleName(), "Id");
        }
        return new ResponseEntity<>(appointmentService.createAppointment(appointmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> updateCategory
            (@Valid @RequestBody AppointmentDto appointmentDto, @PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(appointmentService.updateAppointment(appointmentDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") Long id) {
        appointmentService.deleteAppointmentById(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}

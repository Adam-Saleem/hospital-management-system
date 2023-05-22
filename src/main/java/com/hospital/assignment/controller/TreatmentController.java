package com.hospital.assignment.controller;


import com.hospital.assignment.dto.TreatmentDto;
import com.hospital.assignment.exception.BadRequestException;
import com.hospital.assignment.service.TreatmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treatment")
public class TreatmentController {
    private final Logger log = LoggerFactory.getLogger(TreatmentController.class);

    private TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping
    public ResponseEntity<List<TreatmentDto>> getAllTreatments() {
        return ResponseEntity.ok().body(treatmentService.getAllTreatments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentDto> getCategoryById(
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(treatmentService.getTreatmentById(id));
    }

    @PostMapping
    public ResponseEntity<TreatmentDto> createTreatment(@Valid @RequestBody TreatmentDto treatmentDto) {
        if (treatmentDto.getId() == 0) {
            log.error("Cannot have an ID {}", treatmentDto);
            throw new BadRequestException(TreatmentController.class.getSimpleName(), "Id");
        }
        return new ResponseEntity<>(treatmentService.createTreatment(treatmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentDto> updateCategory
            (@Valid @RequestBody TreatmentDto treatmentDto, @PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(treatmentService.updateTreatment(treatmentDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") Long id) {
        treatmentService.deleteTreatmentById(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}

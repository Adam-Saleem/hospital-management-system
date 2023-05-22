package com.hospital.assignment.service;

import com.hospital.assignment.dto.TreatmentDto;

import java.util.List;

public interface TreatmentService {
    TreatmentDto createTreatment(TreatmentDto treatmentDto);

    List<TreatmentDto> getAllTreatments();

    TreatmentDto getTreatmentById(Long id);

    TreatmentDto updateTreatment(TreatmentDto treatmentDto, Long id);

    void deleteTreatmentById(Long id);
}

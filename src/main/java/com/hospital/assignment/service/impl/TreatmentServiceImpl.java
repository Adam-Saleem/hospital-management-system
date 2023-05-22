package com.hospital.assignment.service.impl;

import com.hospital.assignment.dto.TreatmentDto;
import com.hospital.assignment.entity.Treatment;
import com.hospital.assignment.exception.ResourceNotFoundException;
import com.hospital.assignment.repository.TreatmentRepository;
import com.hospital.assignment.service.TreatmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreatmentServiceImpl implements TreatmentService {

    private TreatmentRepository treatmentRepository;

    public TreatmentServiceImpl(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public TreatmentDto createTreatment(TreatmentDto treatmentDto) {
        Treatment treatment = mapToEntity(treatmentDto);
        Treatment newTreatment = treatmentRepository.save(treatment);

        TreatmentDto treatmentResponse = mapToDto(newTreatment);
        return treatmentResponse;
    }

    @Override
    public List<TreatmentDto> getAllTreatments() {
        List<Treatment> treatments = treatmentRepository.findAll();
        return treatments.stream().map(treatment -> mapToDto(treatment)).collect(Collectors.toList());
    }

    @Override
    public TreatmentDto getTreatmentById(Long id) {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Treatment", "id", id));
        return mapToDto(treatment);
    }

    @Override
    public TreatmentDto updateTreatment(TreatmentDto treatmentDto, Long id) {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Treatment", "id", id));
        treatment.setName(treatmentDto.getName());
        treatment.setPrice(treatmentDto.getPrice());
        treatment.setDescription(treatmentDto.getDescription());
        Treatment updatedTreatment = treatmentRepository.save(treatment);
        return mapToDto(updatedTreatment);
    }

    @Override
    public void deleteTreatmentById(Long id) {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Treatment", "id", id));
        treatmentRepository.delete(treatment);
    }

    private TreatmentDto mapToDto(Treatment treatment) {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(treatment.getId());
        treatmentDto.setName(treatment.getName());
        treatmentDto.setPrice(treatment.getPrice());
        treatmentDto.setDescription(treatment.getDescription());
        return treatmentDto;
    }

    private Treatment mapToEntity(TreatmentDto treatmentDto) {
        Treatment treatment = new Treatment();
        treatment.setName(treatmentDto.getName());
        treatment.setPrice(treatmentDto.getPrice());
        treatment.setDescription(treatmentDto.getDescription());
        return treatment;
    }
}

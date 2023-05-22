package com.hospital.assignment.service.impl;

import com.hospital.assignment.dto.PatientDto;
import com.hospital.assignment.entity.Patient;
import com.hospital.assignment.exception.ResourceNotFoundException;
import com.hospital.assignment.repository.PatientRepository;
import com.hospital.assignment.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = mapToEntity(patientDto);
        Patient newPatient = patientRepository.save(patient);

        PatientDto patientResponse = mapToDto(newPatient);
        return patientResponse;
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(patient -> mapToDto(patient)).collect(Collectors.toList());
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        return mapToDto(patient);
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto, Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        patient.setName(patientDto.getName());
        patient.setBirthDate(patientDto.getBirthDate());
        patient.setGender(patientDto.getGender());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        Patient updatedPatient = patientRepository.save(patient);
        return mapToDto(updatedPatient);
    }

    @Override
    public void deletePatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        patientRepository.delete(patient);
    }

    private PatientDto mapToDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setBirthDate(patient.getBirthDate());
        patientDto.setGender(patient.getGender());
        patientDto.setPhoneNumber(patient.getPhoneNumber());
        return patientDto;
    }

    private Patient mapToEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setBirthDate(patientDto.getBirthDate());
        patient.setGender(patientDto.getGender());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        return patient;
    }
}

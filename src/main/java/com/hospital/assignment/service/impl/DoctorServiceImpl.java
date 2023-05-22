package com.hospital.assignment.service.impl;

import com.hospital.assignment.dto.DoctorDto;
import com.hospital.assignment.entity.Doctor;
import com.hospital.assignment.exception.ResourceNotFoundException;
import com.hospital.assignment.repository.DoctorRepository;
import com.hospital.assignment.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor = mapToEntity(doctorDto);
        Doctor newDoctor = doctorRepository.save(doctor);

        DoctorDto doctorResponse = mapToDto(newDoctor);
        return doctorResponse;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(doctor -> mapToDto(doctor)).collect(Collectors.toList());
    }

    @Override
    public DoctorDto getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));
        return mapToDto(doctor);
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));
        doctor.setName(doctorDto.getName());
        doctor.setPhoneNumber(doctorDto.getPhoneNumber());
        doctor.setAddress(doctorDto.getAddress());
        Doctor updatedDoctor = doctorRepository.save(doctor);
        return mapToDto(updatedDoctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));
        doctorRepository.delete(doctor);
    }

    private DoctorDto mapToDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setPhoneNumber(doctor.getPhoneNumber());
        doctorDto.setAddress(doctor.getAddress());
        return doctorDto;
    }

    private Doctor mapToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setPhoneNumber(doctorDto.getPhoneNumber());
        doctor.setAddress(doctorDto.getAddress());
        return doctor;
    }
}

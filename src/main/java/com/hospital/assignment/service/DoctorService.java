package com.hospital.assignment.service;

import com.hospital.assignment.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor(DoctorDto doctorDto);

    List<DoctorDto> getAllDoctors();

    DoctorDto getDoctorById(Long id);

    DoctorDto updateDoctor(DoctorDto doctorDto, Long id);

    void deleteDoctorById(Long id);
}

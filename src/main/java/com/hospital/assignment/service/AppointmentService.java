package com.hospital.assignment.service;

import com.hospital.assignment.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto treatmentDto);

    List<AppointmentDto> getAllAppointments();

    AppointmentDto getAppointmentById(Long id);

    AppointmentDto updateAppointment(AppointmentDto treatmentDto, Long id);

    void deleteAppointmentById(Long id);
}

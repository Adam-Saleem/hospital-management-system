package com.hospital.assignment.service.impl;

import com.hospital.assignment.dto.AppointmentDto;
import com.hospital.assignment.entity.Appointment;
import com.hospital.assignment.exception.ResourceNotFoundException;
import com.hospital.assignment.repository.AppointmentRepository;
import com.hospital.assignment.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = mapToEntity(appointmentDto);
        Appointment newAppointment = appointmentRepository.save(appointment);

        AppointmentDto appointmentResponse = mapToDto(newAppointment);
        return appointmentResponse;
    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream().map(appointment -> mapToDto(appointment)).collect(Collectors.toList());
    }

    @Override
    public AppointmentDto getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
        return mapToDto(appointment);
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto, Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
        appointment.setDoctor_id(appointmentDto.getDoctor_id());
        appointment.setPatient_id(appointmentDto.getPatient_id());
        appointment.setPayment(appointmentDto.getPayment());
        appointment.setAppointment_date(appointmentDto.getAppointment_date());
        Appointment updatedAppointment = appointmentRepository.save(appointment);
        return mapToDto(updatedAppointment);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
        appointmentRepository.delete(appointment);
    }

    private AppointmentDto mapToDto(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setId(appointment.getId());
        appointmentDto.setDoctor_id(appointment.getDoctor_id());
        appointmentDto.setPatient_id(appointment.getPatient_id());
        appointmentDto.setPayment(appointment.getPayment());
        appointmentDto.setAppointment_date(appointment.getAppointment_date());
        return appointmentDto;
    }

    private Appointment mapToEntity(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setDoctor_id(appointmentDto.getDoctor_id());
        appointment.setPatient_id(appointmentDto.getPatient_id());
        appointment.setPayment(appointmentDto.getPayment());
        appointment.setAppointment_date(appointmentDto.getAppointment_date());
        return appointment;
    }
}

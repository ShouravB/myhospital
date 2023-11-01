package com.myhospital.doctorservices.service;

import com.myhospital.doctorservices.dto.DoctorDTO;
import com.myhospital.doctorservices.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface IDoctorService {
    Doctor createDoctor(DoctorDTO doctorDTO);

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long id);

    List<Doctor> getDoctorsBySpeciality(String special);

    Doctor updateDoctor(Long id , DoctorDTO doctorDTO);

    void deleteDoctor(Long id);
}

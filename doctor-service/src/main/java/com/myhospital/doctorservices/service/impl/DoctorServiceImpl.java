package com.myhospital.doctorservices.service.impl;

import com.myhospital.doctorservices.dto.DoctorDTO;
import com.myhospital.doctorservices.exceptions.DoctorNotFoundException;
import com.myhospital.doctorservices.model.Doctor;
import com.myhospital.doctorservices.repository.DoctorRepository;
import com.myhospital.doctorservices.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public Doctor createDoctor(DoctorDTO doctorDTO) {
        return doctorRepository.save(doctorDTO.mapToDoctor());
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(
                ()-> new DoctorNotFoundException("Doctor not found with given information")
        );
    }

    @Override
    public List<Doctor> getDoctorsBySpeciality(String special) {

        return doctorRepository.findBySpeciality(special).orElseThrow(
                ()->new DoctorNotFoundException("No doctors found with given speciality")
        );

    }

    @Override
    public Doctor updateDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                ()-> new DoctorNotFoundException("No doctor with given id exists")
        );
       return doctorRepository.save(doctorDTO.mapToDoctor(doctorDTO,doctor));

    }

    @Override
    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                ()-> new DoctorNotFoundException("No doctor with given id exists")
                );
        doctorRepository.delete(doctor);
    }


}

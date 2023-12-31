package com.myhospital.doctorservices.repository;

import com.myhospital.doctorservices.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
   Optional<List<Doctor>> findBySpeciality(String speciality);


}

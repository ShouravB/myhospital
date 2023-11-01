package com.myhospital.doctorservices.controller;

import com.myhospital.doctorservices.dto.DoctorDTO;
import com.myhospital.doctorservices.model.Doctor;
import com.myhospital.doctorservices.service.IDoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Tag(name = "Doctor", description = "Doctor management API")
@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
@Validated
public class DoctorController {


    @Autowired
    private IDoctorService iDoctorService;

    @Operation(
            summary = "Create a new Doctor",
            description = "Create a new doctor from data taken in request body."
    )
    @PostMapping(value = "/doctor")
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody DoctorDTO doctorDTO){
        log.info(doctorDTO.toString());
        Doctor doctor = iDoctorService.createDoctor(doctorDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(doctor);
    }

    @Operation(
            summary = "Get Doctors",
            description = "Get the details of all doctors."
    )
    @GetMapping(value="/doctor")
    public ResponseEntity<List<Doctor>> getDoctors(){
       List<Doctor> doctors = iDoctorService.getAllDoctors();

        return  ResponseEntity.status(HttpStatus.OK)
                .body(doctors);
    }

    @Operation(
            summary = "Get specific Doctor from given id in path",
            description = "Get the details of a specific doctors."
    )
    @GetMapping(value="/doctor/{doctorId}")
    public ResponseEntity<Doctor> getDoctorDetail(@PathVariable(value = "doctorId") Long id){
        log.info(String.valueOf(id));
        Doctor doctor = iDoctorService.getDoctorById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(doctor);

    }

    @Operation(
            summary = "Get specific Doctors",
            description = "Get the list of doctors based on speciality."
    )
    @GetMapping(value="/doctor/speciality")
    public ResponseEntity<List<Doctor>> getDoctorWithSpeciality(@RequestParam(value = "spec") String special){
        log.info(String.valueOf(special));
        List<Doctor> doctors = iDoctorService.getDoctorsBySpeciality(special);
        return  ResponseEntity.status(HttpStatus.FOUND)
                .body(doctors);
    }

    @Operation(
            summary = "Update Doctor",
            description = "Update the information of existing doctor"
    )
    @PutMapping(value = "/doctor/{doctorId}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("doctorId") Long doctorId, @RequestBody DoctorDTO doctorDTO){
        Doctor doctor = iDoctorService.updateDoctor(doctorId,doctorDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(doctor);

    }

    @Operation(
            summary = "Delete Doctor",
            description = "Delete the information of a doctor"
    )
    @DeleteMapping(value = "/doctor/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("doctorId") Long id){

        iDoctorService.deleteDoctor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("");

    }
}

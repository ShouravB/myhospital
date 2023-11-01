package com.myhospital.doctorservices.dto;

import com.myhospital.doctorservices.model.Doctor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Slf4j
@ToString
@Component
public class DoctorDTO {

    @Setter
    @NotEmpty(message = "NMC number cannot be empty")
    private String nmcNumber;

    @Setter
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Setter
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email address should be valid")
    private String email;

    @Setter
    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must contain valid 10 digits")
    private String phoneNumber;

    @Setter
    private String speciality="general";

    @Setter
    private double fees=100.0;

    public Doctor mapToDoctor(){
        Doctor doctor = new Doctor();
        doctor.setName(this.getName());
        doctor.setNmcNumber(this.getNmcNumber());
        doctor.setEmail(this.getEmail());
        doctor.setPhoneNumber(this.getPhoneNumber());
        doctor.setSpeciality(this.getSpeciality());
        doctor.setFees(this.getFees());
        return doctor;
    }

    public Doctor mapToDoctor(DoctorDTO doctorDTO, Doctor doctor){
        doctor.setNmcNumber(doctorDTO.getNmcNumber());
        doctor.setName(doctorDTO.getName());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
        doctor.setSpeciality(doctorDTO.getSpeciality());
        doctor.setFees(doctorDTO.getFees());
        return doctor;
    }

}

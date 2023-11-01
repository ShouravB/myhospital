package com.myhospital.doctorservices;

import com.myhospital.doctorservices.model.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DoctorServicesApplication {

	public static void main(String[] args) {

		SpringApplication.run(DoctorServicesApplication.class, args);
		Doctor doc = new Doctor();
		log.info("Application is running");


	}



}

package com.myhospital.doctorservices.model;

//import lombok.Data;
import lombok.*;
import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@ToString
@Component
@Entity
@Table(name = "doctor_tbl")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Setter
    @Column(name = "nmc_number")
    private String nmcNumber;

    @Setter
    @Column(name = "name")
    private String name;

    @Setter
    @Column
    private String email;

    @Setter
    @Column(name = "phone_number")
    private String phoneNumber;

    @Setter
    @Column
    private String speciality;

    @Setter
    @Column
    private double fees;


}

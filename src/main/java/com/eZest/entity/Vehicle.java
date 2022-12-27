package com.eZest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Vehicle {


    @Id
    @GeneratedValue
    private long vehicle_Id;

    private String vehicle_RegNo;

    private String vehicle_Colour;

    private  String vehicle_Type;



}


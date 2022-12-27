package com.eZest.service;

import com.eZest.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {



     Vehicle createVehicle(Vehicle vehicle);

     List<Vehicle> getAllVehicles();

     Optional<Vehicle> getVehicleByRegNO(String vehicleRegNo);




}

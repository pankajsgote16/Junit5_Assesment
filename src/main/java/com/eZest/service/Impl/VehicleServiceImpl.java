package com.eZest.service.Impl;

import com.eZest.entity.Vehicle;
import com.eZest.exceptions.VehicleAlreadyExistsException;
import com.eZest.exceptions.VehicleNotFoundException;
import com.eZest.repository.VehicleRepository;
import com.eZest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public Vehicle createVehicle(Vehicle vehicle) {

        Optional<Vehicle> dbVehicleByRegNo = this.vehicleRepository.findByVehicle_regno(vehicle.getVehicle_RegNo());
        if (dbVehicleByRegNo.isPresent())
        {
            throw new VehicleAlreadyExistsException(dbVehicleByRegNo.get().getVehicle_RegNo());
        }
        return   this.vehicleRepository.save(vehicle);


    }


    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> all_Vehicles = this.vehicleRepository.findAll();
        return all_Vehicles;
    }


    @Override
    public Optional<Vehicle> getVehicleByRegNO(String vehicleRegNo) {
        Optional<Vehicle> vehicleByRegNo = this.vehicleRepository.findByVehicle_regno(vehicleRegNo);
        if (vehicleByRegNo.isPresent()) {

            return vehicleByRegNo;
        }
        throw  new VehicleNotFoundException(vehicleRegNo);
    }
}

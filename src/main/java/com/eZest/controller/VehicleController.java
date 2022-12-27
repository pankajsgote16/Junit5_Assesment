package com.eZest.controller;

import com.eZest.entity.Vehicle;
import com.eZest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/generate")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle)
    {
        Vehicle vehicle1 = this.vehicleService.createVehicle(vehicle);

        return new ResponseEntity<Vehicle>(vehicle1,HttpStatus.CREATED);
    }

    @GetMapping("/listall")
    public  ResponseEntity<List<Vehicle>> getAllVehicles()
    {
        List<Vehicle> allVehicles = this.vehicleService.getAllVehicles();
        return  new ResponseEntity<List<Vehicle>>(allVehicles,HttpStatus.OK);
    }

    @GetMapping("/{vehicle_RegNo}")
    public ResponseEntity<Optional<Vehicle>>getVehicleByRegNo(@PathVariable ("vehicle_RegNo") String regNO)
    {
        Optional<Vehicle> vehicleByRegNO = this.vehicleService.getVehicleByRegNO(regNO);
        return new ResponseEntity<Optional<Vehicle>>(vehicleByRegNO,HttpStatus.OK);

    }



}

package com.eZest.service.Impl;

import com.eZest.entity.Vehicle;
import com.eZest.exceptions.VehicleAlreadyExistsException;
import com.eZest.exceptions.VehicleNotFoundException;
import com.eZest.repository.VehicleRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VehicleServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

//    @Test
//    @DisplayName("Should return all vehicles")
//    @Disabled
//    void getAllVehiclesShouldReturnAllVehicles() {
//        Vehicle vehicle = new Vehicle();
//        vehicle.setVehicle_Id(1L);
//        vehicle.setVehicle_Colour("Red");
//        vehicle.setVehicle_RegNo("MH-12-1234");
//        vehicle.setVehicle_Type("Car");
//
//        when(vehicleRepository.findAll()).thenReturn(List.of(vehicle));
//
//        List<Vehicle> allVehicles = vehicleService.getAllVehicles();
//
//        assertEquals(1, allVehicles.size());
//        assertEquals(1L, allVehicles.get(0).getVehicle_Id());
//        assertEquals("Red", allVehicles.get(0).getVehicle_Colour());
//        assertEquals("MH-12-1234", allVehicles.get(0).getVehicle_RegNo());
//        assertEquals("Car", allVehicles.get(0).getVehicle_Type());
//    }

    @Test
    @DisplayName("Should throw an exception when the vehicle is not found")
    void getVehicleByRegNOWhenVehicleIsNotFoundThenThrowException() {
        String vehicleRegNo = "MH-12-1234";
        when(vehicleRepository.findByVehicle_regno(vehicleRegNo)).thenReturn(Optional.empty());

        Throwable exception =
                assertThrows(
                        VehicleNotFoundException.class,
                        () -> vehicleService.getVehicleByRegNO(vehicleRegNo));

        assertEquals("Vehicle with MH-12-1234 not found !!", exception.getMessage());
    }

    @Test
    @DisplayName("Should return the vehicle when the vehicle is found")
    void getVehicleByRegNOWhenVehicleIsFound() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_RegNo("MH-12-1234");
        vehicle.setVehicle_Colour("Red");
        vehicle.setVehicle_Type("Car");

        when(vehicleRepository.findByVehicle_regno(any())).thenReturn(Optional.of(vehicle));

        Optional<Vehicle> actual = vehicleService.getVehicleByRegNO("MH-12-1234");

        assertTrue(actual.isPresent());
        assertEquals(vehicle, actual.get());
    }

    @Test
    @DisplayName("Should save the vehicle when the vehicle is not exists")
    void createVehicleWhenVehicleIsNotExistsThenSaveTheVehicle() {
        Vehicle vehicle = new Vehicle(101l, "5633", "Red", "Car");

        when(vehicleRepository.findByVehicle_regno(any())).thenReturn(Optional.empty());
        when(vehicleRepository.save(any())).thenReturn(vehicle);

        Vehicle savedVehicle = vehicleService.createVehicle(vehicle);

        assertEquals(vehicle, savedVehicle);
    }

    @Test
    @DisplayName("Should throw an exception when the vehicle is already exists")
    void createVehicleWhenVehicleIsAlreadyExistsThenThrowException() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_RegNo("KA-01-HH-1234");
        vehicle.setVehicle_Colour("White");
        vehicle.setVehicle_Type("4 Wheeler");

        when(vehicleRepository.findByVehicle_regno(any())).thenReturn(Optional.of(vehicle));

        assertThrows(
                VehicleAlreadyExistsException.class, () -> vehicleService.createVehicle(vehicle));

        verify(vehicleRepository, times(1)).findByVehicle_regno(any());
    }
}
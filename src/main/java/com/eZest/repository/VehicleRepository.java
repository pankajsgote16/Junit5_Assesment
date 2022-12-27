package com.eZest.repository;

import com.eZest.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    @Query("select v from Vehicle v where upper(v.vehicle_RegNo) = upper(?1)")
    Optional<Vehicle> findByVehicle_regno(String vehicle_RegNo);



}

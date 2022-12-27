package com.eZest.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleAlreadyExistsException extends RuntimeException{
    String vehicle_RegNo;

    public VehicleAlreadyExistsException( String vehicle_RegNo) {
        super(String.format("Vehicle of Reg.No %s already exists !!",vehicle_RegNo));
        this.vehicle_RegNo = vehicle_RegNo;
    }
}

package com.eZest.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleNotFoundException extends  RuntimeException{

    String vehicle_RegNo;

    public VehicleNotFoundException(String vehicle_RegNo) {
       super(String.format("Vehicle with %s not found !!",vehicle_RegNo));
       this.vehicle_RegNo=vehicle_RegNo;
    }
}

package com.pufi.Model.Values;

import com.pufi.Model.Types.InterfaceType;
import com.pufi.Model.Types.ReferenceType;

public class ReferenceValue implements InterfaceValue{
    private int address;
    private InterfaceType locationType;

    public ReferenceValue(int address, InterfaceType locationType){
        this.address = address;
        this.locationType = locationType;
    }

    public int getAddress(){
        return this.address;
    }

    public InterfaceType getLocationType(){
        return this.locationType;
    }

    public String toString(){
        return "(" + Integer.toString(address) + ", " + locationType.toString() + ")";
    }

    public InterfaceType getType(){
        return new ReferenceType(locationType);
    }

    public boolean equals(Object another){
        if (another instanceof ReferenceValue){
            return address == ((ReferenceValue) another).getAddress() && locationType.equals(((ReferenceValue) another).getLocationType());
        }
        else
            return false;
    }
    
}

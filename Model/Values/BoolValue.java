package com.pufi.Model.Values;

import com.pufi.Model.Types.InterfaceType;
import com.pufi.Model.Types.BoolType;

public class BoolValue implements InterfaceValue{
    private boolean value;
    public InterfaceType getType() {
        return new BoolType();
    }
    public BoolValue(boolean value){
        this.value=value;
    }
    public boolean getValue(){
        return value;
    }
    public String toString(){
        return String.valueOf(value);
    }
    public boolean equals(Object another){
        if (another instanceof BoolValue&& ((BoolValue)another).getValue()==this.value)
            return true;
        else
            return false;
    }
}

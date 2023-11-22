package com.pufi.Model.Types;

import com.pufi.Model.Values.BoolValue;
import com.pufi.Model.Values.InterfaceValue;

public class BoolType implements InterfaceType{
    @Override
    public InterfaceValue defaultValue() {
        InterfaceValue defaultValue=new BoolValue(false);
        return defaultValue;
    }
    public String toString(){
        return "bool";
    }
    public boolean equals(Object another){
        if (another instanceof BoolType)
            return true;
        else
            return false;
    }
}

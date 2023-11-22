package com.pufi.Model.Types;

import com.pufi.Model.Values.IntValue;
import com.pufi.Model.Values.InterfaceValue;

public class IntType implements InterfaceType{
    public boolean equals(Object another){
        return another instanceof IntType;
    }

    public String toString(){
        return "int";
    }

    public InterfaceValue defaultValue(){
        return new IntValue(0);
    }
}

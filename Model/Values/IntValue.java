package com.pufi.Model.Values;

import com.pufi.Model.Types.InterfaceType;
import com.pufi.Model.Types.IntType;

public class IntValue implements InterfaceValue{
    private int value;

    public IntValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public InterfaceType getType(){
        return new IntType();
    }

    public boolean equals(Object another){
        if (another instanceof IntValue){
            IntValue anotherIntValue = (IntValue) another;
            return this.value == anotherIntValue.getValue();
        }
        else
            return false;
    }

    public String toString(){
        return Integer.toString(this.value);
    }


}

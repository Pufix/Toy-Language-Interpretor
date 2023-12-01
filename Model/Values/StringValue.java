package com.pufi.Model.Values;

import com.pufi.Model.Types.InterfaceType;
import com.pufi.Model.Types.StringType;

public class StringValue implements InterfaceValue{
    private String value;

    
    public StringValue(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public InterfaceType getType(){
        return new StringType();
    }

    public boolean equals(Object another){
        if (another instanceof StringValue){
            StringValue anotherStringValue = (StringValue) another;
            return this.value.equals(anotherStringValue.getValue());
        }
        else
            return false;
    }

    public String toString(){
        return this.value;
    }
}

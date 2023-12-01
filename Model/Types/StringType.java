package com.pufi.Model.Types;

import com.pufi.Model.Values.InterfaceValue;
import com.pufi.Model.Values.StringValue;

public class StringType implements InterfaceType{
    public boolean equals(Object another){
        return another instanceof StringType;
    }

    public String toString(){
        return "string";
    }

    public InterfaceValue defaultValue(){
        return new StringValue("");
    }

}

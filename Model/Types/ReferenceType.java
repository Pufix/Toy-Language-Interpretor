package com.pufi.Model.Types;

import com.pufi.Model.Values.InterfaceValue;
import com.pufi.Model.Values.ReferenceValue;

public class ReferenceType implements InterfaceType{
    private InterfaceType inner;

    public ReferenceType(InterfaceType inner){
        this.inner = inner;
    }

    public InterfaceType getInner(){
        return this.inner;
    }

    public boolean equals(Object another){
        if (another instanceof ReferenceType){
            return inner.equals(((ReferenceType) another).getInner());
        }
        else
            return false;
    }

    public String toString(){
        return "Ref(" + inner.toString() + ")";
    }

    public InterfaceValue defaultValue(){
        return new ReferenceValue(0, inner);
    }
    
}

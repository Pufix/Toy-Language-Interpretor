package com.pufi.Model.Types;

import com.pufi.Model.Values.InterfaceValue;

public interface InterfaceType {

    boolean equals(Object another);
    String toString();
    InterfaceValue defaultValue();
    

}

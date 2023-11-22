package com.pufi.Model.Values;

import com.pufi.Model.Types.InterfaceType;

public interface InterfaceValue {


    InterfaceType getType();
    boolean equals(Object another);
    String toString();
}

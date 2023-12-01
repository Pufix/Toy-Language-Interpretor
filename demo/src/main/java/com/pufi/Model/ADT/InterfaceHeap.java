package com.pufi.Model.ADT;

import java.util.HashMap;
import java.util.Map;

import com.pufi.Model.Values.InterfaceValue;

public interface InterfaceHeap<Type> {
    void put(int address, Type value);
    Type get(int address);
    boolean isDefined(int address);
    void update(int address, Type value);
    void clearAddress(int address);
    Map<Integer, Type> getContent();
    String toString();
    int getFreeAddress();
    void setContent(myHeap<Type> newHeap);
}

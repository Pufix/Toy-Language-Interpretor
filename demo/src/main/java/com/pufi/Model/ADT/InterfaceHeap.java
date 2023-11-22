package com.pufi.Model.ADT;

import java.util.HashMap;

public interface InterfaceHeap<Type> {
    void put(int address, Type value);
    Type get(int address);
    boolean isDefined(int address);
    void update(int address, Type value);
    void clearAddress(int address);
    HashMap<Integer, Type> getContent();
    String toString();
    int getFreeAddress();
}

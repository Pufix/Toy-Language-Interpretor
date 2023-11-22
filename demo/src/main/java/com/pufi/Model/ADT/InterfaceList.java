package com.pufi.Model.ADT;

import java.util.ArrayList;

public interface InterfaceList <Type>{
    void add(Type value);
    void remove(Type value);
    ArrayList<Type> getList();
    String toString();
    void clear();
    int getSize();
    Type get(int index);

    void remove(int i);
}

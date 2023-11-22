package com.pufi.Model.ADT;

import java.util.ArrayList;
public class myList<Type> implements InterfaceList<Type>{
    private java.util.ArrayList<Type> list;

    public myList(){
        list = new java.util.ArrayList<Type>();
    }

    public void add(Type value){
        list.add(value);
    }

    public void remove(Type value){
        list.remove(value);
    }

    public java.util.ArrayList<Type> getList(){
        return list;
    }

    public String toString(){
        return list.toString();
    }

    public void clear(){
        list.clear();
    }

    public int getSize(){
        return list.size();
    }

    public Type get(int index){
        return list.get(index);
    }

    public void remove(int i){
        list.remove(i);
    }
}

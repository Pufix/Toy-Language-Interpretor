package com.pufi.Model.ADT;
import java.util.HashMap;

public class myHeap<Type> implements InterfaceHeap<Type>{
    private HashMap<Integer, Type> heap;
    private int freeAddress;

    public myHeap(){
        heap = new HashMap<Integer, Type>();
        freeAddress = 1;
    }

    public void put(int address, Type value){
        heap.put(address, value);
    }

    public Type get(int address){
        return heap.get(address);
    }

    public boolean isDefined(int address){
        return heap.containsKey(address);
    }

    public void update(int address, Type value){
        heap.replace(address, value);
    }

    public void clearAddress(int address){
        heap.remove(address);
    }

    public void setContent(HashMap<Integer, Type> newHeap){
        heap = newHeap;
    }

    public HashMap<Integer, Type> getContent(){
        return heap;
    }

    public String toString(){
        return heap.toString();
    }

    public int getFreeAddress(){
        return freeAddress++;
    }

}

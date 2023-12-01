package com.pufi.Model.ADT;
import java.util.HashMap;
import java.util.Map;

import com.pufi.Model.Values.InterfaceValue;

public class myHeap<Type> implements InterfaceHeap<Type>{
    private Map<Integer, Type> heap;
    private int freeAddress;

    public myHeap(){
        heap = new HashMap<Integer, Type>();
        freeAddress = 1;
    }
    public myHeap(Map<Integer, Type> map){
        this.heap = map;
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
    @Override
    public void setContent(myHeap<Type> newHeap){
        heap = newHeap.getContent();
        freeAddress = newHeap.getFreeAddress();
    }

    public Map<Integer, Type> getContent(){
        return heap;
    }

    public String toString(){
        return heap.toString();
    }

    public int getFreeAddress(){
        freeAddress = 1;
        while(heap.containsKey(freeAddress))
            freeAddress++;
        return freeAddress;
    }
}

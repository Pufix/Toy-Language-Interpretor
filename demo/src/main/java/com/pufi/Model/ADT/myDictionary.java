package com.pufi.Model.ADT;

import com.pufi.Model.*;

import java.util.HashMap;

public class myDictionary<Key,Value> implements InterfaceDictionary<Key,Value>{
    private HashMap<Key,Value> dictionary;
    
    public myDictionary(){
        dictionary = new HashMap<Key,Value>();
    }
    public void add(Key key, Value value){
        dictionary.put(key,value);
    }
    public void update(Key key, Value value){
        dictionary.put(key,value);
    }
    public void remove(Key key){
        dictionary.remove(key);
    }
    public Value lookup(Key key) throws Exception{
        return dictionary.get(key);
    }
    public boolean isDefined(Key key){
        return dictionary.containsKey(key);
    }
    public String toString(){
        return dictionary.toString();
    }
    public void clear(){
        dictionary.clear();
    }
    public InterfaceDictionary<Key, Value> clone() {
        InterfaceDictionary<Key, Value> clone = new myDictionary<Key, Value>();
        for (Key key : dictionary.keySet())
            clone.add(key, dictionary.get(key));
        return clone;
    }


}

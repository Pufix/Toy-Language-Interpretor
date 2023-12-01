package com.pufi.Model.ADT;

import java.util.HashMap;
import java.util.Map;


public class myDictionary<Key,Value> implements InterfaceDictionary<Key,Value>{
    private Map<Key,Value> dictionary;
    
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
    @Override
    public Map<Key, Value> getContent() {
        return this.dictionary;
    }

    


}

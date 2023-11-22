package com.pufi.Model.ADT;

public interface InterfaceDictionary<Key,Value> {
    void add(Key key, Value value);
    void update(Key key, Value value);
    void remove(Key key);
    Value lookup(Key key) throws Exception;
    boolean isDefined(Key key);
    String toString();
    void clear();
    InterfaceDictionary<Key,Value> clone();
}

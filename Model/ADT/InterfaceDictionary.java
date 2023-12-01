package com.pufi.Model.ADT;

import java.util.Map;


public interface InterfaceDictionary<Key,Value> {
    void add(Key key, Value value);
    void update(Key key, Value value);
    void remove(Key key);
    Value lookup(Key key) throws Exception;
    boolean isDefined(Key key);
    String toString();
    void clear();
    Map<Key, Value> getContent();
}

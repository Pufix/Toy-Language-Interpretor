package com.pufi.Model.ADT;

import java.util.Stack;

public interface InterfaceStack<Type> {
    Type pop() throws Exception;
    void push(Type value);
    boolean isEmpty();
    String toString();
    Stack<Type> getContent();
    void clear();
    int getSize();
}

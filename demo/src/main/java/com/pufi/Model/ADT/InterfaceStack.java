package com.pufi.Model.ADT;

import com.pufi.Model.*;
import com.pufi.Model.Statements.InterfaceStatement;
import com.pufi.Model.Values.InterfaceValue;
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

package com.pufi.Model.ADT;

import java.util.Stack;

public class myStack<Type> implements InterfaceStack<Type>{
    Stack<Type> stack;

    public myStack(){
        stack = new Stack<Type>();
    }

    public Type pop() throws Exception{
        if(stack.isEmpty())
            throw new Exception("Stack is empty!");
        return stack.pop();
    }

    public void push(Type value){
        stack.push(value);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public String toString(){
        return stack.toString();
    }

    public Stack<Type> getContent(){
        return stack;
    }

    public void clear(){
        stack.clear();
    }

    public int getSize(){
        return stack.size();
    }
}

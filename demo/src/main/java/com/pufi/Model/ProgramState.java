package com.pufi.Model;

import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.InterfaceHeap;
import com.pufi.Model.ADT.InterfaceList;
import com.pufi.Model.ADT.InterfaceStack;
import com.pufi.Model.Statements.InterfaceStatement;
import com.pufi.Model.Values.InterfaceValue;

import java.io.BufferedReader;

public class ProgramState {
    private InterfaceStack<InterfaceStatement> stack;
    private InterfaceDictionary<String, InterfaceValue> symbolTable;
    private InterfaceList<InterfaceValue> output;
    private InterfaceStatement originalProgram;
    private InterfaceDictionary<String, BufferedReader> fileTable;

    public ProgramState(InterfaceStack<InterfaceStatement> stack,
                        InterfaceDictionary<String, InterfaceValue> symbolTable,
                        InterfaceList<InterfaceValue> output,
                        InterfaceStatement originalProgram,
                        InterfaceDictionary<String, BufferedReader> fileTable){
        this.stack = stack;
        this.symbolTable = symbolTable;
        this.output = output;
        this.originalProgram = originalProgram;
        this.fileTable = fileTable;
        stack.push(originalProgram);
    }

    public InterfaceStack<InterfaceStatement> getStack(){
        return stack;
    }

    public InterfaceDictionary<String, InterfaceValue> getSymbolTable(){
        return symbolTable;
    }

    public InterfaceList<InterfaceValue> getOutput(){
        return output;
    }

    public InterfaceStatement getOriginalProgram(){
        return originalProgram;
    }

    public boolean isNotCompleted(){
        return !stack.isEmpty();
    }

    public ProgramState oneStep() throws Exception{
        if(stack.isEmpty()) throw new Exception("The stack is empty!");
        try{
            InterfaceStatement currentStatement = stack.pop();
            return currentStatement.execute(this);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public String toString(){
        return "Stack:\n" + stack.toString() + "\nSymbol Table:\n" + symbolTable.toString() + "\nOutput:\n" + output.toString() + "\n";
    }

    public InterfaceDictionary<String, BufferedReader> getFileTable() {
        return fileTable;
    }
}

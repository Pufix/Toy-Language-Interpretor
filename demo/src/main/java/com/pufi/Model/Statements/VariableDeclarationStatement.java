package com.pufi.Model.Statements;

import com.pufi.Exceptions.StatementException;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ProgramState;
import com.pufi.Model.Types.InterfaceType;
import com.pufi.Model.Values.InterfaceValue;

public class VariableDeclarationStatement implements InterfaceStatement{
    String name;
    InterfaceType type;

    public VariableDeclarationStatement(String name, InterfaceType type){
        this.name = name;
        this.type = type;
    }

    public String toString(){
        return type.toString() + " " + name;
    }
    @Override
    public ProgramState execute(ProgramState state) throws StatementException{
        InterfaceDictionary<String, InterfaceValue> symbolTable = state.getSymbolTable();
        if(symbolTable.isDefined(name))
            throw new StatementException("Variable " + name + " is already defined!");
        symbolTable.add(name,type.defaultValue());
        return null;
    }

}

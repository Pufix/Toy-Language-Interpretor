package com.pufi.Model.Statements;

import com.pufi.Exceptions.StatementException;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.InterfaceHeap;
import com.pufi.Model.Expressions.Expression;
import com.pufi.Model.ProgramState;
import com.pufi.Model.Types.InterfaceType;
import com.pufi.Model.Values.InterfaceValue;

public class AssignStatement implements InterfaceStatement{
    String id;
    Expression expression;

    public AssignStatement(String id, Expression expression){
        this.id = id;
        this.expression = expression;
    }

    @Override
    public String toString(){
        return id + "=" + expression.toString();
    }

    @Override
    public ProgramState execute(ProgramState state) throws StatementException {
        InterfaceDictionary<String, InterfaceValue> symbolTable = state.getSymbolTable();
        InterfaceHeap<InterfaceValue> heap = state.getHeapTable();
        try{
        if(symbolTable.isDefined(id)){
            InterfaceValue value;
            try{
            value = expression.evaluate(symbolTable, heap);}
            catch (Exception e){
                System.out.println(e.getMessage());
                throw new StatementException(e.getMessage());
            }
            InterfaceType type = (symbolTable.lookup(id)).getType();
            if(value.getType().equals(type)){
                symbolTable.update(id, value);
            }
            else{
                throw new StatementException("Declared type of variable " + id + " and type of the assigned expression do not match!");
            }
        }
        else{
            throw new StatementException("The used variable " + id + " was not declared before!");
        }}
        catch (Exception e){
            throw new StatementException(e.getMessage());
        }
        return null;
    }
}

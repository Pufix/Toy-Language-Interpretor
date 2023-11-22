package com.pufi.Model.Statements;

import com.pufi.Exceptions.StatementException;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.InterfaceHeap;
import com.pufi.Model.ADT.InterfaceStack;
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
    public ProgramState execute(ProgramState state) throws StatementException{
        InterfaceStack<InterfaceStatement> stack = state.getStack();
        InterfaceDictionary<String, InterfaceValue> symbolTable = state.getSymbolTable();

        if (symbolTable.isDefined(id)){
            try {
                InterfaceValue value = expression.evaluate(symbolTable);
                InterfaceType type = (symbolTable.lookup(id)).getType();
                if (value.getType().equals(type)) {
                    symbolTable.update(id, value);
                } else {
                    throw new StatementException("Declared type of variable " + id + " and type of the assigned expression do not match!");
                }
            }catch (Exception e){
                throw new StatementException("Variable " + id + " is not defined!");
            }
        }
        else{
            throw new StatementException("Variable " + id + " is not defined!");
        }
        return state;
    }
}

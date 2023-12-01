package com.pufi.Model.Statements;

import com.pufi.Exceptions.EvalException;
import com.pufi.Exceptions.StatementException;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.InterfaceHeap;
import com.pufi.Model.Expressions.Expression;
import com.pufi.Model.ProgramState;
import com.pufi.Model.Values.BoolValue;
import com.pufi.Model.Values.InterfaceValue;

public class IfStatement implements InterfaceStatement {
    Expression expression;
    InterfaceStatement thenStatement;

    public IfStatement(Expression expression, InterfaceStatement thenStatement){
        this.expression = expression;
        this.thenStatement = thenStatement;
    }

    @Override
    public String toString(){
        return "if(" + expression.toString() + "){\n    " + thenStatement.toString()+"}";
    }

    @Override
    public ProgramState execute(ProgramState state) throws StatementException {
        InterfaceDictionary<String, InterfaceValue> symbolTable = state.getSymbolTable();
        InterfaceHeap<InterfaceValue> heap = state.getHeapTable();
        try{
            InterfaceValue condition = expression.evaluate(symbolTable,heap);
            BoolValue boolCondition = (BoolValue) condition;
            if (boolCondition.getValue()){
                state.getStack().push(thenStatement);
            }
        } catch (EvalException e) {
            throw new StatementException(e.getMessage());
        }
        return state;
    }

    
    
}

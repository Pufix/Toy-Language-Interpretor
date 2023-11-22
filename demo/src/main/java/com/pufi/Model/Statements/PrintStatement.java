package com.pufi.Model.Statements;

import com.pufi.Model.Expressions.Expression;
import com.pufi.Model.ProgramState;

public class PrintStatement implements InterfaceStatement{
    private Expression expression;

    public PrintStatement(Expression expression){
        this.expression = expression;
    }

    @Override
    public String toString(){
        return "print(" + expression.toString() + ")";
    }

    @Override

    public ProgramState execute(ProgramState state) throws Exception{
        state.getOutput().add(expression.evaluate(state.getSymbolTable()));
        return state;
    }

}

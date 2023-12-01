package com.pufi.Model.Statements;

import com.pufi.Exceptions.*;
import com.pufi.Model.ADT.InterfaceStack;
import com.pufi.Model.ProgramState;

public class CompoundStatement implements InterfaceStatement{
    private InterfaceStatement expression1;
    private InterfaceStatement expression2;
    
    public CompoundStatement(InterfaceStatement expression1, InterfaceStatement expression2){
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
    
    @Override
    public String toString(){
        return expression1.toString() + ";\n" + expression2.toString();
    }
    
    @Override
    public ProgramState execute(ProgramState state) throws StatementException{
        InterfaceStack<InterfaceStatement> stack = state.getStack();
        stack.push(expression2);
        stack.push(expression1);
        return state;
    }

    
}

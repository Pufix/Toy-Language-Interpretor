package com.pufi.Model.Statements;

import com.pufi.Model.ProgramState;
import com.pufi.Model.Types.InterfaceType;
import com.pufi.Model.Types.ReferenceType;
import com.pufi.Model.Values.InterfaceValue;
import com.pufi.Model.Expressions.Expression;
import com.pufi.Model.Values.ReferenceValue;


public class NewHeapStatement implements InterfaceStatement{
    private String variableName;
    private Expression expression;

    public NewHeapStatement(String variableName, Expression expression){
        this.variableName = variableName;
        this.expression = expression;
    }

    public String toString(){
        return "new(" + variableName + ", " + expression.toString() + ")";
    }

    public ProgramState execute(ProgramState state) throws Exception{
        if(!state.getSymbolTable().isDefined(variableName))
            throw new Exception("The variable is not defined!");
        if(!(state.getSymbolTable().lookup(variableName).getType() instanceof ReferenceType))
            throw new Exception("The variable is not a reference!");
        InterfaceValue value = expression.evaluate(state.getSymbolTable(), state.getHeapTable());
        InterfaceType locationType = ((ReferenceType)state.getSymbolTable().lookup(variableName).getType()).getInner();
        if(!value.getType().equals(locationType))
            throw new Exception("The variable and the expression have different types!");
        int address = state.getHeapTable().getFreeAddress();
        state.getHeapTable().put(address, value);
        state.getSymbolTable().update(variableName, new ReferenceValue(address, locationType));
        return null;
    }
    
}

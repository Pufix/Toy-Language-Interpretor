package com.pufi.Model.Statements;
import com.pufi.Model.ProgramState;
import com.pufi.Model.Expressions.Expression;
import com.pufi.Model.Types.ReferenceType;
import com.pufi.Model.Values.InterfaceValue;
import com.pufi.Model.Values.ReferenceValue;

public class HeapWriteStatement implements InterfaceStatement {
    private String variableName;
    private Expression expression;

    public HeapWriteStatement(String variableName, Expression expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    public ProgramState execute(ProgramState state) throws Exception {
        if (!state.getSymbolTable().isDefined(variableName))
            throw new Exception("Variable is not defined");
        if (!(state.getSymbolTable().lookup(variableName).getType() instanceof ReferenceType))
            throw new Exception("Variable is not a reference type");
        int address = ((ReferenceValue)(state.getSymbolTable().lookup(variableName))).getAddress();
        if (!state.getHeapTable().isDefined(address))
            throw new Exception("Address is not defined in the heap");
        InterfaceValue value = expression.evaluate(state.getSymbolTable(), state.getHeapTable());
        state.getHeapTable().update(address, value);
        return null;
    }

    public String toString() {
        return "wH(" + variableName + ", " + expression.toString() + ")";
    }


    
}

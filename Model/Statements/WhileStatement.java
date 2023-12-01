package com.pufi.Model.Statements;

import com.pufi.Model.ProgramState;
import com.pufi.Model.Expressions.ComparationExpression;
import com.pufi.Model.Expressions.Expression;
import com.pufi.Model.Types.BoolType;
import com.pufi.Model.Values.BoolValue;
import com.pufi.Model.Values.InterfaceValue;


public class WhileStatement implements InterfaceStatement {

    private InterfaceStatement statement;
    private Expression expression;

    public WhileStatement(Expression expression, InterfaceStatement statement){
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        InterfaceValue value = expression.evaluate(state.getSymbolTable(), state.getHeapTable());
        if(value.getType().equals(new BoolType())){
            BoolValue boolValue = (BoolValue)value;
            if(boolValue.getValue()){
                state.getStack().push(this);
                state.getStack().push(statement);
            }
        }
        else
            throw new Exception("Expression is not a boolean!");
        return null;
    }

    @Override
    public String toString(){
        return "while("+expression.toString()+"){\n"+statement.toString()+"\n} \n";
    }
    
}

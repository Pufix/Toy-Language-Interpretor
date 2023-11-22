package com.pufi.Model.Expressions;

import com.pufi.Exceptions.*;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.InterfaceHeap;
import com.pufi.Model.Types.BoolType;
import com.pufi.Model.Types.InterfaceType;
import com.pufi.Model.Values.BoolValue;
import com.pufi.Model.Values.InterfaceValue;

public class LogicExpression implements Expression{
    private Expression e1;
    private Expression e2;
    private String op;

    public LogicExpression(Expression e1, Expression e2, String op){
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    @Override
    public String toString(){
        return e1.toString() + op + e2.toString();
    }


    @Override

    public InterfaceValue evaluate(InterfaceDictionary<String, InterfaceValue> table) throws EvalException{
        InterfaceValue v1, v2;
        v1 = e1.evaluate(table);
        if(v1.getType().equals(new BoolType())){
            v2 = e2.evaluate(table);
            if(v2.getType().equals(new BoolType())){
                BoolValue i1 = (BoolValue)v1;
                BoolValue i2 = (BoolValue)v2;
                boolean n1, n2;
                n1 = i1.getValue();
                n2 = i2.getValue();
                if(op.equals("&&")) return new BoolValue(n1 && n2);
                if(op.equals("||")) return new BoolValue(n1 || n2);
            }
            else throw new EvalException("Second operand is not a boolean!");
        }
        else throw new EvalException("First operand is not a boolean!");
        return new BoolValue(false);
    }


}

package com.pufi.Model.Expressions;

import com.pufi.Exceptions.EvalException;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.Values.InterfaceValue;

public class ValueExpression implements Expression{
    private InterfaceValue value;
    public ValueExpression(InterfaceValue value){
        this.value = value;
    }
    @Override
    public InterfaceValue evaluate(InterfaceDictionary<String, InterfaceValue> table) throws EvalException {
        return value;
    }

    @Override
    public String toString(){
        return value.toString();
    }

}

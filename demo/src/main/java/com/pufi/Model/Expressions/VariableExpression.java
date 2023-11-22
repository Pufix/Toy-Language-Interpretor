package com.pufi.Model.Expressions;

import com.pufi.Exceptions.EvalException;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.Values.InterfaceValue;

public class VariableExpression implements Expression{
    private String id;

    public VariableExpression(String id){
        this.id = id;
    }

    @Override
    public String toString(){
        return id;
    }

    @Override
    public InterfaceValue evaluate(InterfaceDictionary<String, InterfaceValue> table) throws EvalException {
        try {
            return table.lookup(id);
        } catch (Exception e) {
            throw new EvalException(e.getMessage());
        }
    }

}

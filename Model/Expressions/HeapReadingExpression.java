package com.pufi.Model.Expressions;

import com.pufi.Exceptions.EvalException;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.InterfaceHeap;
import com.pufi.Model.Types.ReferenceType;
import com.pufi.Model.Values.IntValue;
import com.pufi.Model.Values.InterfaceValue;
import com.pufi.Model.Values.ReferenceValue;

public class HeapReadingExpression implements Expression{
    private Expression variableName;

    public HeapReadingExpression(Expression variableName){
        this.variableName = variableName;
    }

    public InterfaceValue evaluate(InterfaceDictionary<String, InterfaceValue> table, InterfaceHeap<InterfaceValue> heap) throws EvalException{
        InterfaceValue value = variableName.evaluate(table, heap);
        if(!(value.getType() instanceof ReferenceType))
            throw new EvalException("Variable is not a reference type");
        int address = ((ReferenceValue)value).getAddress();
        if(!heap.isDefined(address))
            throw new EvalException("Address is not defined in the heap");
        return heap.get(address);
    }

    public String toString(){
        return "rH(" + variableName.toString() + ")";
    }
    
}

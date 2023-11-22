package com.pufi.Model.Expressions;

import com.pufi.Exceptions.*;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.InterfaceHeap;
import com.pufi.Model.Types.IntType;
import com.pufi.Model.Types.InterfaceType;
import com.pufi.Model.Values.*;

public class ComparationExpression implements Expression{
    Expression firstExpression;
    Expression secondExpression;
    String operation;

    public ComparationExpression(String operation, Expression firstExpression, Expression secondExpression){
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.operation = operation;
    }

    @Override
    public String toString(){
        return firstExpression.toString() + operation + secondExpression.toString();
    }

    @Override
    public InterfaceValue evaluate(InterfaceDictionary<String, InterfaceValue> table) throws EvalException{
        InterfaceValue firstValue, secondValue;
        firstValue = firstExpression.evaluate(table);
        if (firstValue.getType().equals(new IntType())){
            secondValue = secondExpression.evaluate(table);
            if (secondValue.getType().equals(new IntType())){
                IntValue firstIntValue = (IntValue) firstValue;
                IntValue secondIntValue = (IntValue) secondValue;
                int firstIntNumber, secondIntNumber;
                firstIntNumber = firstIntValue.getValue();
                secondIntNumber = secondIntValue.getValue();
                if (operation == "<")
                    return new BoolValue(firstIntNumber < secondIntNumber);
                if (operation == "<=")
                    return new BoolValue(firstIntNumber <= secondIntNumber);
                if (operation == "==")
                    return new BoolValue(firstIntNumber == secondIntNumber);
                if (operation == "!=")
                    return new BoolValue(firstIntNumber != secondIntNumber);
                if (operation == ">")
                    return new BoolValue(firstIntNumber > secondIntNumber);
                if (operation == ">=")
                    return new BoolValue(firstIntNumber >= secondIntNumber);
                throw new EvalException("Invalid operation!");
            }
            else
                throw new EvalException("Second operand is not an integer!");
        }
        else
            throw new EvalException("First operand is not an integer!");
    }
}

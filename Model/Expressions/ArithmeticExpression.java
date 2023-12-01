package com.pufi.Model.Expressions;

import com.pufi.Exceptions.*;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.InterfaceHeap;
import com.pufi.Model.Types.IntType;
import com.pufi.Model.Values.*;

public class ArithmeticExpression implements Expression{
    Expression firstExpression;
    Expression secondExpression;
    char operation;

    public ArithmeticExpression(char operation, Expression firstExpression, Expression secondExpression){
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.operation = operation;
    }

    @Override

    public String toString(){
        return firstExpression.toString() + operation + secondExpression.toString();
    }

    @Override

    public InterfaceValue evaluate(InterfaceDictionary<String, InterfaceValue> table, InterfaceHeap<InterfaceValue> heap) throws EvalException{
        InterfaceValue firstValue, secondValue;
        firstValue = firstExpression.evaluate(table,heap);
        if (firstValue.getType().equals(new IntType())){
            secondValue = secondExpression.evaluate(table,heap);
            if (secondValue.getType().equals(new IntType())){
                IntValue firstIntValue = (IntValue) firstValue;
                IntValue secondIntValue = (IntValue) secondValue;
                int firstIntNumber, secondIntNumber;
                firstIntNumber = firstIntValue.getValue();
                secondIntNumber = secondIntValue.getValue();
                if (operation == '+')
                    return new IntValue(firstIntNumber + secondIntNumber);
                if (operation == '-')
                    return new IntValue(firstIntNumber - secondIntNumber);
                if (operation == '*')
                    return new IntValue(firstIntNumber * secondIntNumber);
                if (operation == '/'){
                    if (secondIntNumber == 0)
                        throw new EvalException("Division by zero!");
                    else
                        return new IntValue(firstIntNumber / secondIntNumber);
                }
            }
            else
                throw new EvalException("Second operand is not an integer!");
        }
        else
            throw new EvalException("First operand is not an integer!");
        return new IntValue(0);
    }
}

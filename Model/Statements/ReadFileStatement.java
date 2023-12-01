package com.pufi.Model.Statements;

import java.io.BufferedReader;

import com.pufi.Model.ProgramState;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.InterfaceHeap;
import com.pufi.Model.Expressions.Expression;
import com.pufi.Model.Types.IntType;
import com.pufi.Model.Types.StringType;
import com.pufi.Model.Values.IntValue;
import com.pufi.Model.Values.InterfaceValue;
import com.pufi.Model.Values.StringValue;

public class ReadFileStatement implements InterfaceStatement {
    private Expression expression;
    private String variableName;
    
    public ReadFileStatement(Expression expression, String variableName){
        this.expression = expression;
        this.variableName = variableName;
    }

    public String toString(){
        return "readFile(" + expression.toString() + ", " + variableName + ")";
    }

    public ProgramState execute(ProgramState state) throws Exception{
        InterfaceDictionary<String, InterfaceValue> symbolTable = state.getSymbolTable();
        InterfaceDictionary<String, BufferedReader> fileTable = state.getFileTable();
        InterfaceHeap<InterfaceValue> heap = state.getHeapTable();
        if(!symbolTable.isDefined(variableName))
            throw new Exception("The variable is not defined!");
        if(!symbolTable.lookup(variableName).getType().equals(new IntType()))
            throw new Exception("The types are not the same!");

        try{
            if (!(expression.evaluate(symbolTable, heap).getType().equals(new StringType())))
                throw new Exception("The expression is not a string!");
            StringValue fileStream = (StringValue) expression.evaluate(symbolTable, heap);

            if(!fileTable.isDefined(fileStream.getValue()))
                throw new Exception("The file is not opened!");

            BufferedReader bufferedReader = fileTable.lookup(fileStream.getValue());
            String line = bufferedReader.readLine();
            int value;
            if (line == null)
                value = 0;
            else
                value = Integer.parseInt(line);
            symbolTable.update(variableName, new IntValue(value));
        }catch (Exception e){
            throw new Exception("The expression is not a string!");
        }
        return null;
    }
    
}

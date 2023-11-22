package com.pufi.Model.Statements;

import java.io.BufferedReader;

import com.pufi.Model.ProgramState;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.Expressions.Expression;
import com.pufi.Model.Types.StringType;
import com.pufi.Model.Values.InterfaceValue;

public class CloseFileStatement implements InterfaceStatement {
    private Expression expression;

    public CloseFileStatement(Expression expression){
        this.expression = expression;
    }

    public String toString(){
        return "closeFile(" + expression.toString() + ")";
    }

    public ProgramState execute(ProgramState state) throws Exception{
        InterfaceDictionary<String, BufferedReader> fileTable = state.getFileTable();
        InterfaceDictionary<String, InterfaceValue> symbolTable = state.getSymbolTable();
        if (!(expression.evaluate(symbolTable).getType().equals(new StringType())))
            throw new Exception("The expression is not a string!");
        String fileName = expression.evaluate(symbolTable).toString();
        if (!fileTable.isDefined(fileName))
            throw new Exception("The file is not opened!");
        BufferedReader bufferedReader = fileTable.lookup(fileName);
        bufferedReader.close();
        fileTable.remove(fileName);
        return null;
    }
    
}

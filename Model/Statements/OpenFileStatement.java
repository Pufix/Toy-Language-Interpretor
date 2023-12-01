package com.pufi.Model.Statements;

import com.pufi.Model.ProgramState;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.InterfaceHeap;
import com.pufi.Model.Types.StringType;
import com.pufi.Model.Values.InterfaceValue;
import com.pufi.Model.Values.StringValue;
import com.pufi.Model.Expressions.Expression;

import java.io.BufferedReader;
import java.io.FileReader;

public class OpenFileStatement implements InterfaceStatement{
    private Expression expression;

    public OpenFileStatement(Expression expression){
        this.expression = expression;
    }

    public String toString(){
        return "openFile(" + expression.toString() + ")";
    }

    public ProgramState execute(ProgramState state) throws Exception{
        InterfaceDictionary<String, BufferedReader> fileTable = state.getFileTable();
        InterfaceDictionary<String, InterfaceValue> symbolTable = state.getSymbolTable();
        InterfaceHeap<InterfaceValue> heap = state.getHeapTable();
        try{
            InterfaceValue res = expression.evaluate(symbolTable,heap);
            if(!res.getType().equals(new StringType()))
                throw new Exception("The expression is not a string!");
            StringValue fileStream = (StringValue) res;
            String fileName = fileStream.getValue();
            if (fileTable.isDefined(fileName))
                throw new Exception("The file is already opened!");
            //print current folder
            System.out.println(System.getProperty("user.dir"));
            BufferedReader bufferedReader = new BufferedReader(new FileReader("demo/src/main/"+fileName));
            fileTable.add(fileName, bufferedReader);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return null;
    }

    
}

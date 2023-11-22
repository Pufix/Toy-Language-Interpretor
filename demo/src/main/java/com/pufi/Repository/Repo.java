package com.pufi.Repository;

import com.pufi.Model.ADT.InterfaceList;
import com.pufi.Model.ADT.InterfaceStack;
import com.pufi.Model.Expressions.ArithmeticExpression;
import com.pufi.Model.Expressions.VariableExpression;
import com.pufi.Model.ProgramState;
import com.pufi.Model.Statements.*;
import com.pufi.Model.Types.BoolType;
import com.pufi.Model.Types.IntType;
import com.pufi.Model.Values.IntValue;
import com.pufi.Model.Expressions.ValueExpression;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.myList;
import com.pufi.Model.ADT.myDictionary;
import com.pufi.Model.Values.InterfaceValue;
import com.pufi.Model.ADT.myStack;
import com.pufi.Model.Types.InterfaceType;
import com.pufi.Model.Values.BoolValue;
import com.pufi.Model.Expressions.LogicExpression;
import com.pufi.Model.ADT.InterfaceStack;
import com.pufi.Model.Values.StringValue;
import com.pufi.Model.Types.StringType;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Repo {
    private InterfaceList<ProgramState> states = new myList<ProgramState>();
    private String logFilePath; 
    
    public Repo(ProgramState prg,String logFilePath){
        states.add(prg);
        this.logFilePath = logFilePath;
    }

    public void addProgramState(ProgramState state){
        states.add(state);
    }

    public ProgramState getCurrentProgramState(){
        return states.get(0);
    }
    public ProgramState getProgramState(int index){
        return states.get(index);
    }
    public void logPrgStateExec() throws Exception{
        PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter("demo/"+logFilePath, true)));
        logFile.write(getCurrentProgramState().toString() + "\n");
        logFile.close();
    }
    public String getOutput(){
        return states.get(0).getOutput().toString();
    }


}

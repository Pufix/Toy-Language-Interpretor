package com.pufi.Repository;

import com.pufi.Model.ADT.InterfaceList;
import com.pufi.Model.ProgramState;
import com.pufi.Model.ADT.myList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

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

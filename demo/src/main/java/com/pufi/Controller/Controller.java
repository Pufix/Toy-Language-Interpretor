package com.pufi.Controller;

import com.pufi.Model.*;
import com.pufi.Model.ADT.InterfaceStack;
import com.pufi.Model.Statements.InterfaceStatement;
import com.pufi.Repository.Repo;


public class Controller {
    private Repo repository;

    public Controller(Repo repository){
        this.repository = repository;
    }

    public void addProgramState(ProgramState state){
        repository.addProgramState(state);
    }

    public ProgramState getCurrentProgramState(){
        return repository.getCurrentProgramState();
    }

    public ProgramState executeOneStep() throws Exception{
        ProgramState state = repository.getCurrentProgramState();
        InterfaceStack<InterfaceStatement> stack = state.getStack();
        if(stack.isEmpty())
            throw new Exception("Execution stack is empty!");
        InterfaceStatement currentStatement = stack.pop();
        currentStatement.execute(state);
        return state;
    }

    public void displayCurrentProgramState() throws Exception{
        repository.logPrgStateExec();
    }
    public void displaySpecificProgramState(int index) throws Exception{
        System.out.println(repository.getProgramState(index));
    }

    public void executeAll() throws Exception{
        ProgramState state = repository.getCurrentProgramState();
        InterfaceStack<InterfaceStatement> stack = state.getStack();
        displayCurrentProgramState();
        while(!stack.isEmpty()){
            executeOneStep();
            displayCurrentProgramState();
        }
    }
    public String getRepoOutput(){
        return repository.getOutput();
    }
}

package com.pufi.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pufi.Model.*;
import com.pufi.Model.ADT.InterfaceHeap;
import com.pufi.Model.ADT.InterfaceStack;
import com.pufi.Model.ADT.myHeap;
import com.pufi.Model.Statements.InterfaceStatement;
import com.pufi.Model.Values.InterfaceValue;
import com.pufi.Model.Values.ReferenceValue;
import com.pufi.Repository.Repo;


public class Controller {
    private Repo repository;

    public Controller(Repo repository){
        this.repository = repository;
    }

    public Map<Integer, InterfaceValue> unsafeGarbageCollector(List<Integer> symbolTableAddresses,List<Integer> heapAdresses, Map<Integer, InterfaceValue> heap){
        return heap.entrySet().stream()
                .filter(e->symbolTableAddresses.contains(e.getKey()) || heapAdresses.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    List<Integer> getAddrFromSymTable(Collection<InterfaceValue> symTableValues){
        return symTableValues.stream()
                .filter(v->v instanceof ReferenceValue)
                .map(v->{ReferenceValue v1 = (ReferenceValue)v; return v1.getAddress();})
                .collect(Collectors.toList());
    }

    List<Integer> getAddrFromHeap(InterfaceHeap<InterfaceValue> heap){
        return heap.getContent().keySet().stream()
                .collect(Collectors.toList());
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
            state.setHeapTable(new myHeap(unsafeGarbageCollector(getAddrFromSymTable(state.getSymbolTable().getContent().values()), getAddrFromHeap(state.getHeapTable()),state.getHeapTable().getContent())));    
            
            displayCurrentProgramState();
            executeOneStep();
            displayCurrentProgramState();
        }
    }
    public String getRepoOutput(){
        return repository.getOutput();
    }
}

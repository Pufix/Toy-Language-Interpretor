package com.pufi.Model.Statements;

import com.pufi.Model.ProgramState;
public interface InterfaceStatement {
    ProgramState execute(ProgramState state) throws Exception;
    String toString();


}
